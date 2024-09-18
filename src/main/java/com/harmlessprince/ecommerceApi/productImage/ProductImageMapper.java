package com.harmlessprince.ecommerceApi.productImage;

import com.harmlessprince.ecommerceApi.contracts.IMapper;
import com.harmlessprince.ecommerceApi.file.File;
import com.harmlessprince.ecommerceApi.product.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Component
public class ProductImageMapper implements IMapper<ProductImage, ProductImageResponse, ProductImageRequest> {
    @Override
    public ProductImageResponse fromEntity(ProductImage entity) {
        return new ProductImageResponse(
                entity.getId(),
                entity.getFile().getUrl()
        );
    }
    @Override
    public List<ProductImageResponse> fromEntityList(List<ProductImage> entities) {
        return entities.stream().map(this::fromEntity).toList();
    }

    @Override
    public ProductImage toEntity(ProductImageRequest request) {
        return ProductImage
                .builder()
                .id(request.id())
                .product(request.product())
                .file(request.file())
                .build();
    }


    public List<ProductImageRequest> fromFileList(List<File> fileList, Product product) {
        List<ProductImageRequest> productImageRequests = new ArrayList<>();
        fileList.forEach(file -> {
            ProductImageRequest productImageRequest = new ProductImageRequest(
                    null,
                    file.getId(),
                    product.getId(),
                    product,
                    file
            );
            productImageRequests.add(productImageRequest);
        });
        return productImageRequests;
    }
}
