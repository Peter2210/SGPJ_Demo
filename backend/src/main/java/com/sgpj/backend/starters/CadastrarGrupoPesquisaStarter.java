package com.sgpj.backend.starters;

import com.sgpj.backend.services.GrupoPesquisaService;
import com.sgpj.backend.mssql.model.GruposPesquisa;
import io.camunda.zeebe.client.ZeebeClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/process")
public class CadastrarGrupoPesquisaStarter {

    private final ZeebeClient zeebeClient;
    private final GrupoPesquisaService grupoPesquisaService;

    public CadastrarGrupoPesquisaStarter(ZeebeClient zeebeClient, GrupoPesquisaService grupoPesquisaService) {
        this.zeebeClient = zeebeClient;
        this.grupoPesquisaService = grupoPesquisaService;
    }

    @PostMapping("/GrupoPesquisa")
    public ResponseEntity<?> startCadastroGrupoPesquisa(@RequestBody Map<String, Object> body) {
        try {
            // Extrair processKey
            Object processKeyObj = body.get("processKey");
            if (!(processKeyObj instanceof String processKey)) {
                return ResponseEntity.badRequest().body("processKey inválido.");
            }

            // Extrair variables
            Object variablesObj = body.get("variables");
            if (!(variablesObj instanceof Map<?, ?> rawVariables)) {
                return ResponseEntity.badRequest().body("Variáveis inválidas.");
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

            // Usar o serviço para salvar o grupo
            GruposPesquisa grupo = grupoPesquisaService.salvarGrupoAPartirDoForm(formData);

            // Iniciar processo no Zeebe com ID do grupo
            var result = zeebeClient.newCreateInstanceCommand()
                    .bpmnProcessId(processKey)
                    .latestVersion()
                    .variables(Map.of("Id", grupo.getId().toString()))
                    .send()
                    .join();

            return ResponseEntity.ok(Map.of(
                    "message", "Processo iniciado com sucesso.",
                    "grupoId", grupo.getId(),
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
