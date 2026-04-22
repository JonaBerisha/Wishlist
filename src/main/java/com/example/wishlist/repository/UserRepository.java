package com.example.wishlist.repository;

import com.example.wishlist.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User findByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        return jdbcTemplate.query(sql, new Object[]{email}, rs -> {
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setBirthDate(rs.getDate("birth_date").toLocalDate());
                return user;

            }
            return null;
        });
    }

    public void save(User user) {
        String sql = "INSERT INTO users (email, name, password, birth_date) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql,
                user.getEmail(),
                user.getName(),
                user.getPassword(),
                user.getBirthDate());
    }
}
