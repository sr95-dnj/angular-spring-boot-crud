package com.example.simplecurdsystem.basedangular.servises.serviceImpl;

import com.example.simplecurdsystem.basedangular.domain.Product;
import com.example.simplecurdsystem.basedangular.dto.request.ProductDtoRequest;
import com.example.simplecurdsystem.basedangular.dto.response.IdentificationResponse;
import com.example.simplecurdsystem.basedangular.dto.response.ProductDtoResponse;
import com.example.simplecurdsystem.basedangular.repository.ProductRepository;
import com.example.simplecurdsystem.basedangular.servises.ProductService;
import com.example.simplecurdsystem.basedangular.util.UuidUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final UuidUtil uuidUtil;

    @Override
    public IdentificationResponse createProduct(ProductDtoRequest productDtoRequest) {
        String id = uuidUtil.getUuidUtil();
        Product product = new Product();
        product.setId(id);
        BeanUtils.copyProperties(productDtoRequest, product);
        productRepository.saveAndFlush(product);
        return new IdentificationResponse(id);
    }

    @Override
    public List<ProductDtoResponse> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        List<ProductDtoResponse> list = new ArrayList<>();
        for(Product response : productList){
            ProductDtoResponse productDtoResponse = new ProductDtoResponse();
            BeanUtils.copyProperties(response, productDtoResponse);
            list.add(productDtoResponse);
        }
        return list;
    }

    @Override
    public ProductDtoResponse getProductById(String id) {
        Optional<Product> getProduct = productRepository.findAllById(id);
        if(!getProduct.isPresent()){
            throw new RuntimeException("Product Not Found");
        }
        Product product = getProduct.get();

        ProductDtoResponse response = new ProductDtoResponse();
        BeanUtils.copyProperties(product, response);

        return response;
    }

    @Override
    public void updateProduct(ProductDtoRequest productDtoRequest, String id) {

    }

    @Override
    public void deleteProduct(String id) {

    }
}
