package sistemachamados.usuariosDB;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class HashSenhas {

    private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private  String generateSalt(){
        return BCrypt.gensalt();
    }

    public  String hashPassword(String password){
        String salt = generateSalt();
        return passwordEncoder.encode(password+salt);
    }

    public  boolean checkPassword(String password , String hashedPassword){
        return passwordEncoder.matches(password,hashedPassword);
    }




}
