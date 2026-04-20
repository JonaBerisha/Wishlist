package com.example.wishlist.controller;

import com.example.wishlist.model.WishList;
import com.example.wishlist.service.ItemService;
import com.example.wishlist.service.WishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("/wishlist")
public class WishController {
    private final WishService wishService;
    private final ItemService itemService;

    public WishController(WishService wishService, ItemService itemService) {
        this.wishService = wishService;
        this.itemService = itemService;
    }

    @GetMapping
    public String getWishListPage(Model model) {
        model.addAttribute("wishlists", wishService.getWishLists(1));
        model.addAttribute("items",new ArrayList<>());
        return "wishlist";
    }
    @PostMapping
    public String createWishList(WishList wishList) {
        wishService.createWishList(wishList);
        return "redirect:/wishlist";
    }

}
