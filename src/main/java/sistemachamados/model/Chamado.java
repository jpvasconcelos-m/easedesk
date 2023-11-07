package sistemachamados.model;

import static sistemachamados.model.FilaChamados.fila;

public class Chamado {




    int id;

    String descricao;
    int prioridade;

    UsuarioComum usuarioCriador;

    UsuarioTI usuarioResponsavel;


    public Chamado(String descricao, int prioridade, UsuarioComum usuarioCriador) {
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

    public UsuarioComum getUsuarioCriador() {
        return usuarioCriador;
    }

    public UsuarioComum getUsuarioResponsavel() {
        return usuarioResponsavel;
    }

    public int getId() {
        return id;
    }

    public void setUsuarioResponsavel(UsuarioTI usuarioResponsavel){
        this.usuarioResponsavel = usuarioResponsavel;

    }


    @Override
    public String toString() {

        String str =
        "ID: " + this.id + ";" + " Descrição:" + " " + this.descricao + ";" + "Usuario criador: " + this.usuarioCriador.login + ";"+ " Prioridade: "  + this.prioridade;

                return str;
    }
}
