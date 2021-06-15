package com.moveble.api;

import com.moveble.entity.ProductDescription;
import com.moveble.service.interfaces.IProductDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/productDescription")
public class ProductDescriptionController {

    private IProductDescriptionService productDescriptionService;

    @Autowired
    public ProductDescriptionController(IProductDescriptionService productDescriptionService) {
        this.productDescriptionService = productDescriptionService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "getAll")
    public ResponseEntity<List<ProductDescription>> getAll() {
        try {
            return ResponseEntity.ok(productDescriptionService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "create")
    public ResponseEntity<ProductDescription> create(@RequestBody ProductDescription productDescription) {
        try {
            return ResponseEntity.ok(productDescriptionService.create(productDescription));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "update")
    public ResponseEntity<ProductDescription> update(@RequestBody ProductDescription productDescription) {
        try {
            return ResponseEntity.ok(productDescriptionService.update(productDescription));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
