package br.com.marcos.tarefas_api.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tarefa {

    private Long id;
    private String titulo;
    private String descricao;

}
