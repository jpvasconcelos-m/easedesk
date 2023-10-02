package sistemachamados.utils;

import java.util.Random;

public class Utilitarios {

    static void gerarIdSolicitacao(){
        Random random = new Random();
        String id = "";

        for (int i = 0; i < 9; i++) {
            Integer temp = random.nextInt(10);
            id = id + temp.toString();
        }
        System.out.println(id);


    }

    public static void main(String[] args) {
        gerarIdSolicitacao();
    }


}
