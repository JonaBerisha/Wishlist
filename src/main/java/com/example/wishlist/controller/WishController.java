package com.example.wishlist.controller;

import com.example.wishlist.model.User;
import com.example.wishlist.model.WishList;
import com.example.wishlist.service.ItemService;
import com.example.wishlist.service.WishService;
import jakarta.servlet.http.HttpSession;
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
    public String getWishListPage(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if(user == null){
            return "redirect:/login";
        }
        model.addAttribute("wishlists", wishService.getWishLists(user.getId()));
        model.addAttribute("items", new ArrayList<>());

        return "wishlist";

    }
    @PostMapping
    public String createWishList(WishList wishList, HttpSession session) {
        User user = (User) session.getAttribute("user");
        wishList.setUserId(user.getId());
        wishService.createWishList(wishList);
        return "redirect:/wishlist";
    }

}
