package stadheim.eirik.api.dto;

/**
 * Created by eirikstadheim on 25/03/2017.
 */
public class UserDto {
    private long id;
    private String username;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}