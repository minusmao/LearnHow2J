package com.example.dao;

public class Hero {
    String name;
    int hp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public String toString() {
        return "[" + this.name + ", " + this.hp + "]";
    }
}
