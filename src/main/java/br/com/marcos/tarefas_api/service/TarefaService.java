package br.com.marcos.tarefas_api.service;

import org.springframework.stereotype.Service;
import br.com.marcos.tarefas_api.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

@Service
public class TarefaService {

    private final List<Tarefa> tarefas = new ArrayList<>();

    public List<Tarefa> listarTodas() {
        return tarefas;
    }

    public Tarefa adicionar(Tarefa tarefa) {
        tarefas.add(tarefa);
        return tarefa;
    }

    public Tarefa atualizar(Long id, Tarefa novaTarefa) {

        for (Tarefa tarefa : tarefas) {

            if (tarefa.getId().equals(id)) {

                tarefa.setTitulo(novaTarefa.getTitulo());
                tarefa.setDescricao(novaTarefa.getDescricao());

                return tarefa;
            }
        }

        return null;
    }

    public boolean excluir(Long id) {

        return tarefas.removeIf(t -> t.getId().equals(id));
    }
}
