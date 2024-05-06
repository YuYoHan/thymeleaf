package com.example.mvc.repository.item.v2;

import com.example.mvc.entity.v2.UploadFileEntityV2;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UploadFileRepositoryV2 extends JpaRepository<UploadFileEntityV2, Long> {
    List<UploadFileEntityV2> findByItemId(Long itemId);
}
