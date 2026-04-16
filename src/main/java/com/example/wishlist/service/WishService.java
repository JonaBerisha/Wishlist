package com.example.wishlist.service;

import com.example.wishlist.model.WishList;
import com.example.wishlist.repository.WishRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishService {
    private final WishRepository wishRepository;


    public WishService(WishRepository wishRepository) {
        this.wishRepository = wishRepository;
    }
    public void createWishList(WishList wishList) {
        wishRepository.save(wishList);
    }
    public List<WishList>getWishLists(int userId){
        return wishRepository.findByUserId(userId);
    }
}
