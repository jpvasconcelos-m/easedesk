package sistemachamados.model;

import java.time.Instant;
import java.util.LinkedList;

 public class FilaChamados {

    public LinkedList<Chamado> chamados = new LinkedList<>();


    public  boolean adicionarAFila(Chamado chamado){

        if(chamados.add(chamado) == true){
            System.out.println("Chamado adicionado!");
            return true;
        }
       else if(chamados.add(chamado) == false){
            System.out.println("Chamado falhou em ser adicionado :/");
            return false;
        }
       else
       return false;


    }










}
