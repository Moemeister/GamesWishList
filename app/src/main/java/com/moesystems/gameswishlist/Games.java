package com.moesystems.gameswishlist;

/**
 * Created by gerar on 24/4/2018.
 */

public class Games {
    private String name;

    private int img;
    private String desc;

    private boolean wishgame;

    public Games(String name, int img, String desc) {
        this.name = name;
        this.img = img;
        this.desc = desc;
        wishgame = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void set(boolean wishgame ){
        this.wishgame = wishgame;
    }

    public boolean yesorno(){
        return wishgame;
    }
}
