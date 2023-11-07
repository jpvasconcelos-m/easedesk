package sistemachamados.model;

import static sistemachamados.model.FilaChamados.fila;

public class Chamado {




    int id;

    String descricao;
    int prioridade;

    Usuario usuarioCriador;

    Usuario usuarioResponsavel;


    public Chamado(String descricao, int prioridade, Usuario usuarioCriador) {
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.usuarioCriador = usuarioCriador;

        fila.add(this);
        this.id = fila.indexOf(this);

    }


    public String getDescricao() {
        return descricao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public Usuario getUsuarioCriador() {
        return usuarioCriador;
    }

    public Usuario getUsuarioResponsavel() {
        return usuarioResponsavel;
    }

    public int getId() {
        return id;
    }

    public void setUsuarioResponsavel(UsuarioTI usuarioResponsavel){
        this.usuarioResponsavel = usuarioResponsavel;

    }

}
