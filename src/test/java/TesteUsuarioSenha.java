import org.junit.jupiter.api.Test;
import easedesk.model.Usuario;
import easedesk.utils.SenhaUtils;

public class TesteUsuarioSenha {

    private Usuario usuario;
    private String senha;



    @Test
    void TesteUsuarioSenha(){
        SenhaUtils su = new SenhaUtils();
        String senhaArmazenhada = su.senhaHash("senha1234");
        String testeSenha  = su.senhaHash("senha1234");

        System.out.println(testeSenha.equals(senhaArmazenhada));


        System.out.println(senhaArmazenhada);

    }







}
