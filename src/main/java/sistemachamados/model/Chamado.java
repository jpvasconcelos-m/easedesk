package sistemachamados.model;

import java.time.Instant;


public class Chamado {

   private final Integer numSolicitacao;
    private final String Contrato;
    private final Instant dataCriacao;
   private final Instant prazoLimite;
   private Usuario usuarioResponsavel;
   private String situacao;
   private final int prioridade;
   private String descricao;

    public Chamado(Integer numSolicitacao, String contrato, Instant dataCriacao, Instant prazoLimite, String situacao, int prioridade, String descricao) {
        this.numSolicitacao = numSolicitacao;
        Contrato = contrato;
        this.dataCriacao = dataCriacao;
        this.prazoLimite = prazoLimite;
        this.situacao = situacao;
        this.prioridade = prioridade;
        this.descricao = descricao;
    }


    public Integer getNumSolicitacao() {
        return numSolicitacao;
    }

    public String getContrato() {
        return Contrato;
    }

    public Instant getDataCriacao() {
        return dataCriacao;
    }

    public Instant getPrazoLimite() {
        return prazoLimite;
    }

    public Usuario getUsuarioResponsavel() {
        return usuarioResponsavel;
    }

    public String getSituacao() {
        return situacao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setUsuarioResponsavel(Usuario usuarioResponsavel) {
        this.usuarioResponsavel = usuarioResponsavel;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Chamado{" +
                "numSolicitacao=" + numSolicitacao +
                ", Contrato='" + Contrato + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", prazoLimite=" + prazoLimite +
                ", usuarioResponsavel=" + usuarioResponsavel +
                ", situacao='" + situacao + '\'' +
                ", prioridade=" + prioridade +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
