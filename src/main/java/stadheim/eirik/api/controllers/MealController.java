package stadheim.eirik.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stadheim.eirik.api.dto.MealDto;
import stadheim.eirik.api.dto.ProductDto;
import stadheim.eirik.persistence.model.Meal;
import stadheim.eirik.persistence.model.Product;
import stadheim.eirik.persistence.service.IMealService;


/**
 * Created by eirikstadheim on 22/03/2017.
 */
@RestController
@RequestMapping("/meal")
public class MealController {

    @Autowired
    private IMealService mealService;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Meal> findProduct(@PathVariable(value = "id") long id) {

        Meal meal = mealService.findOne(id);

        return new ResponseEntity(meal, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public HttpStatus createMeal(@RequestBody MealDto meal) {
        mealService.create(meal.toModel());

        return HttpStatus.CREATED;
    }
}