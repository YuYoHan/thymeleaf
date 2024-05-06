package com.example.mvc.entity.v2;

import com.example.mvc.domain.v2.UploadFileDTOV2;
import lombok.*;

import javax.persistence.*;

@Getter
@ToString(exclude = {"item"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class UploadFileEntityV2 {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 고객이 업로드 파일명
    private String uploadFileName;
    // 서버 내부에서 관리하는 파일명
    private String storeFileName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private ItemEntityV2 item;

    @Builder
    public UploadFileEntityV2(Long id,
                              String uploadFileName,
                              String storeFileName,
                              ItemEntityV2 item) {
        this.id = id;
        this.uploadFileName = uploadFileName;
        this.storeFileName = storeFileName;
        this.item = item;
    }

    public static UploadFileEntityV2 changeEntity(UploadFileDTOV2 image) {
        return UploadFileEntityV2.builder()
                .uploadFileName(image.getUploadFileName())
                .storeFileName(image.getStoreFileName())
                .build();
    }
}
