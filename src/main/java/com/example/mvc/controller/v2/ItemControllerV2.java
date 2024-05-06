package com.example.mvc.controller.v2;

import com.example.mvc.domain.v2.RequestItemDTOV2;
import com.example.mvc.service.v2.ItemServiceV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Log4j2
@RequiredArgsConstructor
@RestController
public class ItemControllerV2 {
    private final ItemServiceV2 itemService;

    @PostMapping("/items")
    public ResponseEntity<?> saveItem(@RequestPart RequestItemDTOV2 item,
                                      @RequestPart(required = false) List<MultipartFile> images) throws IOException {
        return itemService.addItem(item, images);
    }

    @GetMapping("/items/{itemId}")
    public ResponseEntity<?> search(@PathVariable Long itemId) {
        return itemService.searchItem(itemId);
    }
}
