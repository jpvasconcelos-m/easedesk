package sistemachamados.model;

import java.util.LinkedList;

public class FilaChamados {

   public static LinkedList<Chamado> fila = new LinkedList();


   static void listarChamados(){
       fila.stream().forEach(chamado -> {
           System.out.println(chamado.getDescricao());
       });
   }
  /*
    public static void main(String[] args) {
        UsuarioTI usuario = new UsuarioTI("usuario_exemplo");
        usuario.criarChamado();

        listarChamados();
        usuario.capturarChamado();


    }
    */




}
