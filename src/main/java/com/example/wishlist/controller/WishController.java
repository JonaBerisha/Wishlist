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

@Controller
@RequestMapping("/wishList")
public class WishController {
    private final WishService wishService;
    private final ItemService itemService;

    public WishController(WishService wishService, ItemService itemService) {
        this.wishService = wishService;
        this.itemService = itemService;
    }

    @GetMapping("/wishList")
    public String getWishListPage(@RequestParam(required = false) Integer wishListId, Model model) {
        model.addAttribute("wishLists", wishService.getWishLists(1));
        if(wishListId != null){
            model.addAttribute("items", itemService.getItems(wishListId));
        }
        model.addAttribute("wishListId", wishListId);
        return "wishList";
    }
    @PostMapping("/wishList")
    public String createWishList(WishList wishList) {
        wishService.createWishList(wishList);
        return "redirect:/wishList";
    }

}
