package com.sgpj.backend.starters;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgpj.backend.mssql.model.ProjetosPesquisa;
import com.sgpj.backend.services.ProjetoPesquisaService;

import io.camunda.zeebe.client.ZeebeClient;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/process")
public class CadastrarProjetoPesquisaStarter {
    private final ZeebeClient zeebeClient;
    private final ProjetoPesquisaService projetoPesquisaService;

    public CadastrarProjetoPesquisaStarter(ZeebeClient zeebeClient, ProjetoPesquisaService projetoPesquisa) {
        this.zeebeClient = zeebeClient;
        this.projetoPesquisaService = projetoPesquisa;
    }

    @PostMapping("/ProjetoPesquisa")
    public ResponseEntity<?> startCadastroProjetoPesquisa(@RequestBody Map<String, Object> body){
        try {
            Object processKeyObject = body.get("processKey");
            if (!(processKeyObject instanceof String processKey)){
                return ResponseEntity.badRequest().body("ProcessKey Inválido");
            }

            Object variablesObject = body.get("variables");
            if (!(variablesObject instanceof Map<?,?> rawVariables)){
                return ResponseEntity.badRequest().body("Variáveis Inválidos");
            }

            @SuppressWarnings("unchecked")
            Map<String, Object> variables = (Map<String, Object>) rawVariables;

            // Extrair formData
            Object formDataObj = variables.get("formData");
            if (!(formDataObj instanceof Map<?, ?> rawFormData)) {
                return ResponseEntity.badRequest().body("Dados do formulário inválidos.");
            }

            @SuppressWarnings("unchecked")
            Map<String, Object> formData = (Map<String, Object>) rawFormData;

            ProjetosPesquisa projeto = projetoPesquisaService.salvarProjetoPesquisa(formData);

            var result = zeebeClient.newCreateInstanceCommand()
                .bpmnProcessId(processKey) 
                .latestVersion()
                .variables(
                    Map.of(
                        "Id",projeto.getId().toString(),
                        "Tipo",0, 
                        "ComiteEticaHumana",projeto.getEnvolveEticaHumana(), 
                        "ComiteEticaAnimal", projeto.getEnvolveEticaAnimal(), 
                        "Financiamento", projeto.getFinanciamento()))
                .send()
                .join();

            return ResponseEntity.ok(Map.of(
                        "message", "Processo iniciado com sucesso.",
                        "grupoId", projeto.getId(),
                        "processInstanceKey", result.getProcessInstanceKey()
                ));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Erro de validação: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro ao iniciar processo: " + e.getMessage());
        }
    }
}
