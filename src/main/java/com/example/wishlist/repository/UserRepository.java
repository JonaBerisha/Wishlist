package com.example.wishlist.repository;

import com.example.wishlist.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User findByEmail(String email) {
        String sql = "SELECT * FROM user WHERE email = ?";
        return jdbcTemplate.query(sql, new Object[]{email}, rs -> {
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setBirthDate(rs.getDate("birth date").toLocalDate());
                return user;

            }
            return null;
        });
    }

    public void save(User user) {
        String sql = "INSERT INTO user(email, password, name, birth date) ";
        jdbcTemplate.update(sql,
                user.getEmail(),
                user.getName(),
                user.getPassword(),
                user.getBirthDate());
    }
}
