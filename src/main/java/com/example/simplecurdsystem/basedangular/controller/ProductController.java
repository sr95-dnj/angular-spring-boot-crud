package com.example.simplecurdsystem.basedangular.controller;

import com.example.simplecurdsystem.basedangular.dto.request.ProductDtoRequest;
import com.example.simplecurdsystem.basedangular.dto.response.ProductDtoResponse;
import com.example.simplecurdsystem.basedangular.dto.response.IdentificationResponse;
import com.example.simplecurdsystem.basedangular.servises.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<IdentificationResponse> createProduct(

            @RequestBody @Valid ProductDtoRequest productDtoRequest, BindingResult bindingResult,
            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

        return new ResponseEntity(productService.createProduct(productDtoRequest), HttpStatus.CREATED);
    }



    @GetMapping("/get-all-product")
    public ResponseEntity<ProductDtoResponse> getAllProduct() {

        return new ResponseEntity(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/get-product-by-id/{id}")
    public ResponseEntity<ProductDtoResponse> getAllProductById(@PathVariable String id) {

        return new ResponseEntity(productService.getProductById(id), HttpStatus.OK);
    }

    @PutMapping("/update-product/{id}")
    public void updateProductList(@RequestBody ProductDtoRequest productDtoRequest,@PathVariable String id) {
        productService.updateProduct(productDtoRequest,id);
    }

    @DeleteMapping("/delete/productList/by/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
    }
}
