package com.harmlessprince.ecommerceApi.productImage;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/products/images")
public class ProductImageController {


    public void UploadSingleImage(MultipartFile file) {

    }
}
