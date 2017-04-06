package stadheim.eirik.persistence.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by eirikstadheim on 25/03/2017.
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;

    @Column(name = "name", unique = true)
    private String name;

    private String username;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "products")
    private Set<Grocery> groceries = new HashSet<Grocery>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = {CascadeType.ALL})
    private Set<MealProduct> mealProducts = new HashSet<>();


    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Grocery> getGroceries() {
        return groceries;
    }

    public void setGroceries(Set<Grocery> groceries) {
        this.groceries = groceries;
    }
}
