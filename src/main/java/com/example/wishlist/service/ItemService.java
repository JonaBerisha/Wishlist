package com.example.wishlist.service;

import com.example.wishlist.model.Item;
import com.example.wishlist.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void addItem(Item item) {
        itemRepository.save(item);
    }

    public List<Item> getItems(int wishListId) {
        return itemRepository.findByWishListId(wishListId);
    }

    public void deleteItem(int id) {
        itemRepository.delete(id);
    }

    public List<Item> sortByPrice(int wishListId) {
        return itemRepository.sortByPrice(wishListId);
    }

    public List<Item> searchItems(String keyword, int wishListId) {
        return itemRepository.search(keyword, wishListId);
    }
}
