package com.example.hotelmanagement;


public class hoteli {
    public int id;
    private String name;
    private String rate;
    private String description;
    private  int thumbnail;


    public hoteli(int id,String name, String rate, String description,int thumbnail) {
        this.id=id;
        this.name = name;
        this.rate = rate;
        this.description = description;
        this.thumbnail=thumbnail;
    }

    public String getName() {
        return name;
    }

    public float getRate() {
        return Float.parseFloat(rate);
    }

    public String getDescription() {
        return description;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
    public float get_bill(int qty)
    {
        return qty*getRate();
    }
}

