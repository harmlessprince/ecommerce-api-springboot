package com.harmlessprince.ecommerceApi.file;

import com.harmlessprince.ecommerceApi.contracts.IService;
import com.harmlessprince.ecommerceApi.exceptions.CustomResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Component
@AllArgsConstructor
public class FileService implements IService<File, FileRequest> {
    private final CloudinaryService cloudinaryService;
    private final FileRepository fileRepository;

    public FileUploadResponse upload(MultipartFile file, String folderName) {
        return cloudinaryService.uploadFile(file, folderName);
    }


    @Override
    public File findById(int id) {
        return fileRepository.findById(id).orElseThrow(() -> new CustomResourceNotFoundException(String.format("File with %d does not exists", id)));
    }

    @Override
    public File create(FileRequest data) {
        File file = File.builder()
                .name(data.getName())
                .type(data.getType())
                .url(data.getUrl())
                .provider(data.getProvider())
                .mimeType(data.getMimeType())
                .customId(data.getCustomId())
                .status(true)
                .build();
        return fileRepository.save(file);
    }

    @Override
    public File update(File model, FileRequest data) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<File> findAll() {
        return List.of();
    }


    public List<File> findAllByOwnerTypeOwnerIdAndIds(List<Integer> ids, String ownerType, Integer ownerId) {
        return fileRepository.findAllByIdInAndOwnerIdAndOwnerType(ids, ownerId, ownerType);
    }
    public List<File> findAllByIdInAndOwnerTypeIsNull(List<Integer> ids) {
        return fileRepository.findAllByIdInAndOwnerTypeIsNull(ids);
    }
}
