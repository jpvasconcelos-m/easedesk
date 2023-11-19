package sistemachamados.utils;
import org.apache.commons.codec.digest.DigestUtils;

public class SenhaUtils {


  static   public String senhaHash(String senha){
        return DigestUtils.md5Hex(senha);
    }

    public static void main(String[] args) {
       String hash = senhaHash("senha");
        System.out.println(hash);
    }

}
