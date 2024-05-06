package com.example.mvc.domain.v2;

import com.example.mvc.entity.v2.UploadFileEntityV2;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class UploadFileDTOV2 {
    private String uploadFileName;
    // 서버 내부에서 관리하는 파일명
    private String storeFileName;

    @Builder
    public UploadFileDTOV2(String uploadFileName, String storeFileName) {
        this.uploadFileName = uploadFileName;
        this.storeFileName = storeFileName;
    }

    public static UploadFileDTOV2 changeDTO(UploadFileEntityV2 image) {
        return UploadFileDTOV2.builder()
                .uploadFileName(image.getUploadFileName())
                .storeFileName(image.getStoreFileName())
                .build();
    }
}
