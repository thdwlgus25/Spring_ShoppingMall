package inhatc.spring.shop.controller;

import inhatc.spring.shop.dto.ItemDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.awt.*;

@Controller
public class ThymeleafController {

    @GetMapping("/thymeleaf/ex1")
    public String ex1(Model model) {

        ItemDto itemDto = ItemDto.builder()
                .itemName("최신 스프링")
                .itemDetail("스프링 부트 3.1.4")
                .itemSellStatus("SELL")
                .price(20000)
                .build();

        model.addAttribute("itemDto", itemDto);
        return "thymeleaf/ex1";
    }

    @GetMapping("/thymeleaf/ex2")
    public String ex2() {
        return "thymeleaf/ex2";
    }
}
