package stadheim.eirik.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stadheim.eirik.api.dto.GroceryDto;
import stadheim.eirik.api.dto.ProductDto;
import stadheim.eirik.persistence.model.Grocery;
import stadheim.eirik.persistence.service.IGroceryService;
import stadheim.eirik.persistence.service.impl.GroceryService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by eirikstadheim on 22/03/2017.
 */
@RestController
@RequestMapping("/code")
public class CodeController {


    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<Set<String>> findCodes(@PathVariable(value = "name") String name) {

        if(name.equals("allergens")) {
            return new ResponseEntity(GroceryService.allergens, HttpStatus.OK);
        }
        else return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
    }
}