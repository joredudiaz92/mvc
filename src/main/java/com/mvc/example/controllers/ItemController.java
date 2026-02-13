package com.mvc.example.controllers;

import com.mvc.example.models.Item;
import com.mvc.example.models.ItemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
@RequestMapping("/items")
public class ItemController {

    private final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public Object getAll(
            @RequestParam(name = "format", required = false, defaultValue = "html") String format,
            Model model
    ) {
        var items = itemRepository.findAll();

        if ("json".equalsIgnoreCase(format)) {
            return ResponseEntity.ok(items);
        }

        model.addAttribute("items", items);
        return "items";
    }
}
