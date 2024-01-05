package easedesk.model;

import javax.persistence.*;

@Entity
@Table(name ="users" )
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @Column(unique = true)
    private String email;
    private boolean isAdmin;
    public User(){
    }

    public User(String name, String email, boolean isAdmin){
        this.name = name;
        this.email = email;
        this.isAdmin = isAdmin;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }



    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }




}
