package stadheim.eirik.api.dto;

import stadheim.eirik.persistence.model.Grocery;
import stadheim.eirik.persistence.model.Product;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by eirikstadheim on 25/03/2017.
 */
public class ProductDto {
    private long id;
    private String name;
    private Set<GroceryDto> groceries = new HashSet<>();

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

    public Set<GroceryDto> getGroceries() {
        return groceries;
    }

    public void setGroceries(Set<GroceryDto> groceries) {
        this.groceries = groceries;
    }

    public Product toModel() {
        Product product = new Product();
        product.setId(id);
        product.setName(name);

        for(GroceryDto grocery: groceries) {
            product.getGroceries().add(grocery.toModel());
        }

        return product;
    }

    public static ProductDto toProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());

        for(Grocery grocery: product.getGroceries()) {
            productDto.groceries.add(GroceryDto.toGroceryDto(grocery));
        }
        return productDto;
    }
}