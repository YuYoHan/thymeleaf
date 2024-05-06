package com.example.mvc.service.v2;

import com.example.mvc.config.file.FileStoreConfig;
import com.example.mvc.domain.v2.ItemDTOV2;
import com.example.mvc.domain.v2.RequestItemDTOV2;
import com.example.mvc.domain.v2.UploadFileDTOV2;
import com.example.mvc.entity.v2.ItemEntityV2;
import com.example.mvc.entity.v2.UploadFileEntityV2;
import com.example.mvc.repository.item.v2.ItemRepositoryV2;
import com.example.mvc.repository.item.v2.UploadFileRepositoryV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@RequiredArgsConstructor
@Transactional
@Service
public class ItemServiceV2 {
    private final ItemRepositoryV2 itemRepository;
    private final UploadFileRepositoryV2 uploadFileRepositoryV2;
    private final FileStoreConfig fileStoreConfig;

    public ResponseEntity<?> addItem(RequestItemDTOV2 item,
                                     List<MultipartFile> images) throws IOException {
        // 컨트롤러에서 받아온 이미지들을 
        // storeFile 메소드에 넣어준다. 그러면 UploadFile에
        // 사용자가 등록한 파일명과 서버에서 관리하는 파일명 두 개가 등록이 된다.
        List<UploadFileDTOV2> uploadImages = fileStoreConfig.storeFiles(images);
        List<UploadFileEntityV2> uploadImages2 = uploadImages.stream()
                .map(UploadFileEntityV2::changeEntity)
                .collect(Collectors.toList());

        // 데이터베이스 저장
        // 파일 이름(사용자가 등록할 때 적을 이름), 파일 등록할 때 이름, 이미지 파일들을 Item에 넣어줌
        ItemEntityV2 itemEntity = ItemEntityV2.builder()
                .itemName(item.getItemName())
                .images(uploadImages2)
                .build();
        ItemEntityV2 saveItem = itemRepository.save(itemEntity);
        ItemDTOV2 responseItem = ItemDTOV2.changeDTO(saveItem);
        return ResponseEntity.ok().body(responseItem);
    }

    public ResponseEntity<?> searchItem(Long id) {
        ItemEntityV2 findItem = itemRepository.findById(id)
                .orElseThrow();
        ItemDTOV2 itemDTOV2 = ItemDTOV2.changeDTO(findItem);
        return ResponseEntity.ok().body(itemDTOV2);
    }
}
