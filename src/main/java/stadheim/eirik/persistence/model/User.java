package stadheim.eirik.persistence.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by eirikstadheim on 22/03/2017.
 */

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;

    @Column(name = "username", unique = true)
    private String username;

    public User() {
        super();
    }

    public User(String username) {
        super();
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }
}