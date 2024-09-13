package com.harmlessprince.ecommerceApi.file;


import com.harmlessprince.ecommerceApi.handler.CustomResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/files")
@Slf4j
public class FileController {
    private final FileService fileService;

    private static final long MAX_FILE_SIZE = 10 * 1024 * 1024;
    private static final List<String> ALLOWED_FILE_TYPES = Arrays.asList(MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE);
    @PostMapping(value = "/upload/single/image", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CustomResponse<FileResponse>> uploadSingleImage(
            @RequestParam("file") MultipartFile file
    ) {

        FileResponse fileResponse = new FileResponse();
        if(file.isEmpty()){
            return ResponseEntity.badRequest().body(CustomResponse.sendErrorResponse("File is empty"));
        }
        if (file.getSize() > MAX_FILE_SIZE) {
            return ResponseEntity.badRequest().body(CustomResponse.sendErrorResponse("File is too large"));
        }
        if (!ALLOWED_FILE_TYPES.contains(file.getContentType())) {
            return ResponseEntity.badRequest().body(CustomResponse.sendErrorResponse("Unsupported file type"));
        }
        try {
          FileUploadResponse fileUploadResponse = fileService.upload(file, "/product/images");

          FileRequest fileRequest = new FileRequest();
          fileRequest.setName(file.getOriginalFilename());
          fileRequest.setCustomId(fileUploadResponse.getFileId());
          fileRequest.setUrl(fileUploadResponse.getFilePath());
          fileRequest.setType("image");
          fileRequest.setMimeType(file.getContentType());
          File createdFile = fileService.create(fileRequest);
          fileResponse.setId(createdFile.getId());
          fileResponse.setName(createdFile.getName());
          fileResponse.setUrl(createdFile.getUrl());
          fileResponse.setType(fileRequest.getType());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(CustomResponse.sendErrorResponse(e.getMessage()));
        }

        return ResponseEntity.ok(CustomResponse.sendSuccessResponse(fileResponse, "File uploaded successfully"));
    }

    @PostMapping(value = "/upload/multiple/images", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CustomResponse<List<FileResponse>>> uploadMultipleImages(
            @RequestParam("files") MultipartFile[] files
    ) {

        List<FileResponse> fileResponses =  new ArrayList<>();
        List<File> createdFiles =  new ArrayList<>();
        List<FileRequest> fileRequests =  new ArrayList<>();
        int index = 1;
        for (MultipartFile file : files) {
            if(file.isEmpty()){
                return ResponseEntity.badRequest().body(CustomResponse.sendErrorResponse(String.format("File at index %d is empty", index)));
            }
            if (file.getSize() > MAX_FILE_SIZE) {
                return ResponseEntity.badRequest().body(CustomResponse.sendErrorResponse(String.format("File at index %d is too large", index)));
            }
            if (!ALLOWED_FILE_TYPES.contains(file.getContentType())) {
                return ResponseEntity.badRequest().body(CustomResponse.sendErrorResponse(String.format("File at index %d is not of supported type", index)));
            }
            index++;
        }

        try {
            for (MultipartFile file : files) {
                FileUploadResponse fileUploadResponse = fileService.upload(file, "product/images");
                FileRequest fileRequest = new FileRequest();
                fileRequest.setName(file.getOriginalFilename());
                fileRequest.setCustomId(fileUploadResponse.getFileId());
                fileRequest.setUrl(fileUploadResponse.getFilePath());
                fileRequest.setType("image");
                fileRequest.setMimeType(file.getContentType());
                fileRequests.add(fileRequest);
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().body(CustomResponse.sendErrorResponse(e.getMessage()));
        }

        return ResponseEntity.ok(CustomResponse.sendSuccessResponse(fileResponses, "File uploaded successfully"));
    }
}
