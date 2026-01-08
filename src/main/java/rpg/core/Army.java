package main.java.rpg.core;

import java.util.ArrayList;
import java.util.List;

public class Army implements Character {

    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private List<Character> components = new ArrayList<>();

    public Army(String name) {
        this.name = name;
    }

    @Override
    public void getDescription() {
        System.out.println(this.name);
        System.out.println("Cette armée comporte " + this.components.size() + " guildes");
        for(Character component: components) {
            component.getDescription();
        }
    }

    public void addComponent(Character component) {
        this.components.add(component);
    }
}
