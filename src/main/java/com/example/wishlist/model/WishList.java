package com.example.wishlist.model;

public class WishList {
    private String name;
    private int id;
    private int userId;


    public WishList() {}

    public WishList(String name, int id, int userId){
        this.name = name;
        this.id = id;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
