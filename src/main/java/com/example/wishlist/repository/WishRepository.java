package com.example.wishlist.repository;

import com.example.wishlist.model.WishList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class WishRepository {
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public WishRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(WishList wishList) {
        String sql = "INSERT INTO wishList (name, user_id) VALUES (?, ?)";

        jdbcTemplate.update(sql,
                wishList.getName(),
                wishList.getUserId());
    }

    public List<WishList> findByUserId(int userId) {
        String sql = "SELECT * FROM wishlist WHERE user_id = ?";

        return jdbcTemplate.query(sql, new Object[]{userId}, (rs, rowNum) -> {
            WishList w = new WishList();
            w.setId(rs.getInt("id"));
            w.setName(rs.getString("name"));
            w.setUserId(rs.getInt("user_id"));
            return w;
        });
    }
}

