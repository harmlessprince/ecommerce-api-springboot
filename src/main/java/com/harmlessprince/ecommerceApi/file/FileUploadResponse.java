package com.harmlessprince.ecommerceApi.file;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Service
public class FileUploadResponse {
    private String fileName;
    private String FilePath;
    private String fileId;

    public FileUploadResponse(boolean uploaded) {
        this.fileName = null;
        this.FilePath = null;
    }

    public FileUploadResponse(String fileId, String filePath) {
        this.fileId = fileId;
        this.FilePath = filePath;
    }

}
