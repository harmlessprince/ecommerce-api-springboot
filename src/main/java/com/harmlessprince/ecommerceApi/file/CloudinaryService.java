package com.harmlessprince.ecommerceApi.file;

import com.cloudinary.Cloudinary;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Component
@AllArgsConstructor
public class CloudinaryService {
    private final Cloudinary cloudinary;

    public FileUploadResponse uploadFile(MultipartFile file, String folderName) {
        try {
            HashMap<String, Object> options = new HashMap<>();
            options.put("folder", folderName);
            Map uploadedFile = cloudinary.uploader().upload(file.getBytes(), options);
            String publicId = uploadedFile.get("public_id").toString();
            return new FileUploadResponse(
                    publicId,
                    cloudinary.url().secure(true).generate(publicId)
            );
        }catch (Exception e) {
            e.printStackTrace();
            return new FileUploadResponse(
                    null,
                   null
            );
        }
    }
}
