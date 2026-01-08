package main.java.rpg.core;

import java.util.ArrayList;
import java.util.List;

public class Guild implements Character {
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private List<Character> components = new ArrayList<>();

    public Guild(String name) {
        this.name = name;
    }

    @Override
    public void getDescription() {
        System.out.println(this.name);
        System.out.println("Cette guilde comporte " + this.components.size() + " personnages");
        for(Character component: components) {
            component.getDescription();
        }
    }

    public void addComponent(Character component) {
        this.components.add(component);
    }
}
