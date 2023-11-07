package sistemachamados.utils;
import org.apache.commons.codec.digest.DigestUtils;

public class SenhaUtils {


    public String senhaHash(String senha){
        return DigestUtils.md5Hex(senha);
    }

}
