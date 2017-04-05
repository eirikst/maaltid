package stadheim.eirik.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stadheim.eirik.api.dto.ProductDto;
import stadheim.eirik.persistence.model.Product;
import stadheim.eirik.persistence.service.IProductService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by eirikstadheim on 22/03/2017.
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> findProduct(@PathVariable(value = "id") long id) {

        Product product = productService.findOne(id);

        return new ResponseEntity(ProductDto.toProductDto(product), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public HttpStatus createProduct(@RequestBody ProductDto product) {
        productService.create(product.toModel());

        return HttpStatus.CREATED;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Set<ProductDto>> findAllProducts() {

        List<Product> products = productService.findAll();
        Set<ProductDto> productDtos = new HashSet<>();

        for(Product product: products) {
            productDtos.add(ProductDto.toProductDto(product));
        }

        return new ResponseEntity(productDtos, HttpStatus.OK);
    }
}