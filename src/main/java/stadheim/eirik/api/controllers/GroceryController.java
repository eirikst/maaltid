package stadheim.eirik.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stadheim.eirik.api.dto.GroceryDto;
import stadheim.eirik.api.dto.ProductDto;
import stadheim.eirik.persistence.model.Grocery;
import stadheim.eirik.persistence.model.Product;
import stadheim.eirik.persistence.service.IGroceryService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by eirikstadheim on 22/03/2017.
 */
@RestController
@RequestMapping("/grocery")
public class GroceryController {

    @Autowired
    private IGroceryService groceryService;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Grocery> findGrocery(@PathVariable(value = "id") long id) {

        Grocery grocery = groceryService.findOne(id);

        return new ResponseEntity(GroceryDto.toGroceryDto(grocery), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public HttpStatus createGrocery(@RequestBody GroceryDto grocery) {
        groceryService.create(grocery.toModel());

        return HttpStatus.CREATED;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Set<ProductDto>> findAllGroceries() {

        List<Grocery> groceries = groceryService.findAll();
        Set<GroceryDto> groceryDtos = new HashSet<>();

        for(Grocery grocery: groceries) {
            groceryDtos.add(GroceryDto.toGroceryDto(grocery));
        }

        return new ResponseEntity(groceryDtos, HttpStatus.OK);
    }
}