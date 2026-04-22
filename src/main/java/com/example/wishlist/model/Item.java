package com.example.wishlist.model;

public class Item {
    private String name;
    private double price;
    private String link;
    private int id;
    private int wishListId;
    private String image;

    public Item(){}

    public Item (String name, double price, String link, int id, int wishListId, String image ){
        this.name = name;
        this.link = link;
        this.id = id;
        this.price = price;
        this.wishListId = wishListId;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWishListId() {
        return wishListId;
    }

    public void setWishListId(int wishListId) {
        this.wishListId = wishListId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
