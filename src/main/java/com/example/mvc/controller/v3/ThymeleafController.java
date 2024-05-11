package com.example.mvc.controller.v3;

import com.example.mvc.domain.v3.item.ItemDTOV3;
import com.example.mvc.entity.v3.item.ItemSellStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {


    @GetMapping("/ex01")
    public String ex01(Model model) {
        ItemDTOV3 item = ItemDTOV3.builder()
                .itemName("상품")
                .itemDetail("상품 설명")
                .price(10000)
                .stockNumber(10)
                .itemSellStatus(ItemSellStatus.SELL)
                .regTime(LocalDateTime.now())
                .build();

        model.addAttribute("item", item);
        return "thymeleaf/ex01";
    }

    @GetMapping("/ex02")
    public String ex02(Model model) {
        List<ItemDTOV3> items = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ItemDTOV3 item = ItemDTOV3.builder()
                    .itemName("상품" + i)
                    .itemDetail("상품 설명" + i)
                    .price(10000)
                    .stockNumber(10)
                    .itemSellStatus(ItemSellStatus.SELL)
                    .regTime(LocalDateTime.now())
                    .build();
            items.add(item);
        }

        model.addAttribute("items", items);
        return "thymeleaf/ex02";
    }

}
