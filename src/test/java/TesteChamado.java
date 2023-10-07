import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sistemachamados.model.Chamado;
import sistemachamados.utils.Utilitarios;

import java.time.Instant;

public class TesteChamado {

    private Chamado chamado;
    private Utilitarios ut;

    @BeforeEach
    void iniciar(){
        ut = new Utilitarios();

        chamado = new Chamado(
                ut.gerarIdSolicitacao(),"SES", Instant
                .now(),Instant.now(),"Aberto",2,"Impressora explodiu e saiu farinha");



    }
    @Test
    void testeInstancia(){
        boolean funciona = false;
        if(!(chamado == null))
            funciona = true;

        Assertions.assertTrue(funciona);

    }
    @Test
    void testToString(){
        System.out.println(chamado.toString());

    }
    @Test
    void testeHorario(){

    }



}
