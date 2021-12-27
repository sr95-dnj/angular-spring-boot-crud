package com.example.simplecurdsystem.basedangular.servises;
import com.example.simplecurdsystem.basedangular.dto.request.ProductDtoRequest;
import com.example.simplecurdsystem.basedangular.dto.response.IdentificationResponse;
import com.example.simplecurdsystem.basedangular.dto.response.ProductDtoResponse;

import java.util.List;

public interface ProductService {

    IdentificationResponse createProduct(ProductDtoRequest productDtoRequest);

    List<ProductDtoResponse> getAllProducts();

    ProductDtoResponse getProductById(String id);

    void updateProduct(ProductDtoRequest productDtoRequest, String id);

    void deleteProduct(String id);

}
