package com.harmlessprince.ecommerceApi.file;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

public record FileUploadRequest(
        MultipartFile file
) {
}
