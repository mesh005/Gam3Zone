package com.example.gam3zone.games;

public class GameModelClass {


    String id;
    String name;
    String img;

    public  GameModelClass(String id, String name, String img) {
        this.id = id;
        this.name = name;
        this.img = img;
    }

    public GameModelClass() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
