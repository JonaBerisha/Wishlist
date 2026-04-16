package com.example.wishlist.controller;

import com.example.wishlist.model.WishList;
import com.example.wishlist.service.WishService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("wishlist")
public class WishController {
    public final WishService wishService;

    public WishController(WishService wishService) {
        this.wishService = wishService;
    }

    @GetMapping("/wishlist")
    public String getWishListPage(){
        return "wishlist";
    }
    @PostMapping("/wishlist")
    public String createWishList(WishList wishList) {
        wishService.createWishList(wishList);
        return "redirect:/wishlist";
    }

}
