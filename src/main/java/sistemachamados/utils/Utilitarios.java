package sistemachamados.utils;

import java.util.Random;

public class Utilitarios {

    public Integer gerarIdSolicitacao(){
        Random random = new Random();
        String id = "";

        for (int i = 0; i < 9; i++) {
            Integer temp = random.nextInt(10);
            id = id + temp.toString();
        }

       Integer idInt = Integer.valueOf(id);

        return idInt;

    }




}
