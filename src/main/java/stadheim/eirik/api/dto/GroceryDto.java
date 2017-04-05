package stadheim.eirik.api.dto;

import stadheim.eirik.persistence.model.Grocery;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by eirikstadheim on 25/03/2017.
 */
public class GroceryDto {
    private long id;
    private String name;
    private Set<String> allergens = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getAllergens() {
        return allergens;
    }

    public void setAllergens(Set<String> allergens) {
        this.allergens = allergens;
    }

    public Grocery toModel() {
        Grocery grocery = new Grocery();
        grocery.setId(id);
        grocery.setName(name);
        grocery.setAllergens(allergens);
        return grocery;
    }

    public static GroceryDto toGroceryDto(Grocery grocery) {
        GroceryDto groceryDto = new GroceryDto();
        groceryDto.setId(grocery.getId());
        groceryDto.setName(grocery.getName());
        groceryDto.setAllergens(grocery.getAllergens());

        return groceryDto;
    }
}