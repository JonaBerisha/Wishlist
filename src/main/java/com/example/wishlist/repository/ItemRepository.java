package com.example.wishlist.repository;

import com.example.wishlist.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepository {
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public ItemRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Item item) {
        String sql = "INSERT INTO items (name, price, wishlist_id) VALUES (?, ?, ?)";

        jdbcTemplate.update(sql,
                item.getName(),
                item.getPrice(),
                item.getWishListId());
    }

    public List<Item> findByWishListId(int wishlistId) {
        String sql = "SELECT * FROM items WHERE wishlist_id = ?";

        return jdbcTemplate.query(sql, new Object[]{wishlistId}, (rs, rowNum) -> {
            Item item = new Item();
            item.setId(rs.getInt("id"));
            item.setName(rs.getString("name"));
            item.setPrice(rs.getDouble("price"));
            item.setWishListId(rs.getInt("wishlist_id"));
            return item;
        });
    }

    public void delete(int id) {
        String sql = "DELETE FROM items WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
    public List<Item> search(String keyword, int wishListId) {
        String sql = "SELECT * FROM items WHERE wishList_id = ? AND name LIKE ?";

        return jdbcTemplate.query(sql,
                new Object[]{wishListId, "%" + keyword + "%"},
                (rs, rowNum) -> {
                    Item item = new Item();
                    item.setId(rs.getInt("id"));
                    item.setName(rs.getString("name"));
                    item.setPrice(rs.getDouble("price"));
                    item.setWishListId(rs.getInt("wishList_id"));
                    return item;
                });
    }
    public List<Item> sortByPrice(int wishListId) {
        String sql = "SELECT * FROM items WHERE wishList_id = ? ORDER BY price ASC";

        return jdbcTemplate.query(sql,
                new Object[]{wishListId},
                (rs, rowNum) -> {
                    Item item = new Item();
                    item.setId(rs.getInt("id"));
                    item.setName(rs.getString("name"));
                    item.setPrice(rs.getDouble("price"));
                    item.setWishListId(rs.getInt("wishlist_id"));
                    return item;
                });
}
}
