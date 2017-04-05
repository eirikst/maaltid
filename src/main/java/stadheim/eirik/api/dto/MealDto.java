package stadheim.eirik.api.dto;

import stadheim.eirik.persistence.model.Meal;
import stadheim.eirik.persistence.model.MealProduct;
import stadheim.eirik.persistence.model.Product;

import java.util.Date;
import java.util.Set;

/**
 * Created by eirikstadheim on 25/03/2017.
 */
public class MealDto {
    private long id;
    private Date time;
    private Set<ProductUnitDto> productUnits;

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

    public Set<ProductUnitDto> getProductUnits() {
        return productUnits;
    }

    public void setProductUnits(Set<ProductUnitDto> productUnits) {
        this.productUnits = productUnits;
    }

    public Meal toModel() {
        Meal meal = new Meal();
        meal.setId(id);
        meal.setTime(time);

        for(ProductUnitDto productUnit: productUnits) {
            meal.getMealProducts().add(productUnit.toModel());//denne mangler meal, må settes i service
        }

        return meal;
    }
}