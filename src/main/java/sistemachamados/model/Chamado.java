package sistemachamados.model;

import static sistemachamados.model.FilaChamados.fila;

public class Chamado {




    Status status;
    int id;
    String descricao;
    int prioridade;
    UsuarioComum usuarioCriador;
    UsuarioTI usuarioResponsavel;

    String solucao = "";





    public void setStatus(Status status) {
        this.status = status;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }




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

    public void setUsuarioResponsavel(UsuarioTI usuarioResponsavel) {
        this.usuarioResponsavel = usuarioResponsavel;

    }



    @Override
    public String toString() {

        String str = "";

        switch(status){

            case ABERTO:
               str = "ID: " + this.id + ";" + " Descrição:" + " " + this.descricao +
                        ";" + "Usuario criador: " + this.usuarioCriador.email + ";" + " Prioridade: "
                        + this.prioridade + ";" + " " + "Responsável: " + ";" +  "Status: " + Status.ABERTO;
               break;
            case CAPTURADO:
                str = "ID: " + this.id + ";" + " Descrição:" + " " + this.descricao +
                        ";" + "Usuario criador: " + this.usuarioCriador.email + ";" + " Prioridade: "
                        + this.prioridade + ";" + " " + "Responsável: " + this.usuarioResponsavel.email + ";" +  " Status: " + Status.CAPTURADO;
                break;
            case CONCLUIDO:
                str = "ID: " + this.id + ";" + " Descrição:" + " " + this.descricao +
                        ";" + "Usuario criador: " + this.usuarioCriador.email + ";" + " Prioridade: "
                        + this.prioridade + ";" + " " + "Responsável: " + this.usuarioResponsavel.email + ";" +  " Status: " + Status.CONCLUIDO
                        + "; Solução : " + this.solucao;
                break;




        }

        return str;




    }

}
