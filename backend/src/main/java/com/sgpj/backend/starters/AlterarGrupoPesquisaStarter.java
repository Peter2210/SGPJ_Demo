package com.sgpj.backend.starters;

import org.springframework.web.bind.annotation.RestController;

import io.camunda.zeebe.client.ZeebeClient;

import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/process")
public class AlterarGrupoPesquisaStarter {
    private final ZeebeClient zeebeClient;

    public AlterarGrupoPesquisaStarter(ZeebeClient zeebeClient){
        this.zeebeClient = zeebeClient;
    }

    @PostMapping("AlterarGrupo")
    public ResponseEntity<?> startAltaracaoGrupoPesquisa(@RequestBody Map<String, Object> body) {
        try{
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

            String grupo = ((String) formData.get("grupoId"));

            var result = zeebeClient.newCreateInstanceCommand()
                .bpmnProcessId(processKey)
                .latestVersion()
                .variables(Map.of("Id", grupo))
                .send()
                .join();

            return ResponseEntity.ok(Map.of(
                    "message", "Processo iniciado com sucesso.",
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
