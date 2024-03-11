package com.swaraj.functionality1.controller;

import com.swaraj.functionality1.model.Product;
import com.swaraj.functionality1.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/products")
//@CrossOrigin(originPatterns = {"*"})
public class ProductsController {

    final private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    /*
    * content negotiation is enabled, i.e. result can be in xml format
    * */
    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml"})
    public ResponseEntity<Product> singleProduct(@PathVariable String id) {
        log.info("request:{} received", id);
        return ResponseEntity.ok(productService.getAllProducts()
                .get(Integer.parseInt(id)));
    }

    ///GET http://localhost:8080/products/search/hola
    @GetMapping(value = "/search/{productType}")
    public ResponseEntity<List<Product>> doSomeOperation(@PathVariable String productType) {
        List<Product> productsByType = productService.getProductsByType(productType);
        return ResponseEntity.ok(productsByType);
    }

    ///GET http://localhost:8080/products/filter?productType=education
//    @GetMapping(value = "/filter")
//    public ResponseEntity<List<Product>> findProductTypeOptional(
//            @RequestParam(value = "productType", required = false) String productType) {
//        List<Product> products = StringUtils.isAllEmpty(productType)
//                ? productService.getAllProducts()
//                : productService.getProductsByType(productType);
//
//        return ResponseEntity.ok(products);
//    }

    @GetMapping(value = "/filter")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findProductTypeOptional(
            @RequestParam(value = "productType", required = false) String productType) {
        List<Product> products = StringUtils.isAllEmpty(productType)
                ? productService.getAllProducts()
                : productService.getProductsByType(productType);

        return products;
    }

    /*
    * POST verb is "not idempotent" by semantic nature
    * */
    @PostMapping(value = "/save", consumes = "application/json")
    @ResponseStatus(value = HttpStatus.CREATED)
    public String saveProduct(@RequestBody @Valid Product product) {
        productService.save(product);
        return "product saved";
    }

    /*
    * PUT verb is considered "idempotent" by semantic nature
    * */
    @PutMapping(value = "/{id}")
    public ResponseEntity<String> putOperation(@PathVariable String id, @RequestBody Product product) {
        productService.update(Integer.parseInt(id), product);
        return ResponseEntity.ok("product updated");
    }
}