package com.harmlessprince.ecommerceApi.file;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface FileRepository extends JpaRepository<File, Integer> {
    List<File> findAllByIdIn(Set<Integer> ids);
    List<File> findAllByIdInAndOwnerIdAndOwnerType(Collection<Integer> id, Integer ownerId, String ownerType);
    List<File> findAllByIdInAndOwnerTypeIsNull(Collection<Integer> id);
}