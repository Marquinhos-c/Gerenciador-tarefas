package br.com.marcos.tarefas_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcos.tarefas_api.model.Tarefa;
import br.com.marcos.tarefas_api.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Tarefa> listar() {
        return service.listarTodas();
    }

    @PostMapping
    public ResponseEntity<Tarefa> adicionar(
            @RequestBody Tarefa tarefa) {

        return ResponseEntity.ok(
                service.adicionar(tarefa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable Long id,
            @RequestBody Tarefa tarefa) {

        Tarefa atualizada =
                service.atualizar(id, tarefa);

        if (atualizada == null) {
            return ResponseEntity
                    .notFound()
                    .build();
        }

        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(
            @PathVariable Long id) {

        boolean removido =
                service.excluir(id);

        if (!removido) {
            return ResponseEntity
                    .notFound()
                    .build();
        }

        return ResponseEntity.ok(
                "Tarefa removida com sucesso");
    }
}
