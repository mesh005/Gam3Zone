package com.example.gam3zone.games;

public class Game {
    private String name;
    private String id;
    private String background_image;

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

    public String getImg() { return background_image; }

    public void setImg(String background_image) { this.background_image = background_image; }
}
