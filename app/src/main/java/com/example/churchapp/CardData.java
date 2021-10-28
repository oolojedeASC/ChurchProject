package com.example.churchapp;

public class CardData {

    String name;
    int images;
//create contractor

    public CardData(String name, int images) {
        this.name = name;
        this.images = images;
    }
    //getter and setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }
}