package stadheim.eirik.persistence.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by eirikstadheim on 25/03/2017.
 */
@Entity
@Table(name = "meal")
public class Meal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;

    @Column(name = "time")
    private Date time;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "meal", cascade = {CascadeType.ALL})
    private Set<MealProduct> mealProducts = new HashSet<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Set<MealProduct> getMealProducts() {
        return mealProducts;
    }

    public void setMealProducts(Set<MealProduct> mealProducts) {
        this.mealProducts = mealProducts;
    }
}
