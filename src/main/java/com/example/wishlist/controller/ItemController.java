package com.example.wishlist.controller;


import com.example.wishlist.model.Item;
import com.example.wishlist.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }
    @PostMapping("/item")
    public String addItem(Item item){
        itemService.addItem(item);
        return "redirect:/wishlist";
    }
    @GetMapping("/item/delete")
    public String deleteItem(@RequestParam int id) {
        itemService.deleteItem(id);
        return "redirect:/wishlist";
    }
    @GetMapping("/item/sort")
    public String sort(@RequestParam int wishListId, Model model) {

        model.addAttribute("items", itemService.sortByPrice(wishListId));
        return "wishList";
    }
    @GetMapping("/item/search")
    public String search(@RequestParam String keyword,
                         @RequestParam int wishListId,
                         Model model) {

        model.addAttribute("items", itemService.searchItems(keyword, wishListId));
        return "wishList";
    }


}
