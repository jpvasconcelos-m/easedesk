import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sistemachamados.model.Chamado;
import sistemachamados.model.FilaChamados;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sistemachamados.model.Chamado;
import sistemachamados.utils.Utilitarios;
import org.junit.jupiter.api.Assertions.*;

import java.time.Instant;



public class TesteFilaChamados {

    private  Chamado chamado;
    private  FilaChamados filaChamados;






    @Test
    void testeAdicionarAFila() {
        FilaChamados filaChamados = new FilaChamados();
        Chamado chamado1 = new Chamado(4321,"ses", Instant.now(),Instant.now(),"Aberto",1,"Impressora explodiu");
        Chamado chamado2 = new Chamado(1234,"see", Instant.now(),Instant.now(),"Aberto",1,"Impressora pipocou ao vivo");


        Assertions.assertTrue(filaChamados.adicionarAFila(chamado1));
        Assertions.assertTrue(filaChamados.adicionarAFila(chamado2));
        filaChamados.chamados.stream().forEach(System.out::println);

    }

}
