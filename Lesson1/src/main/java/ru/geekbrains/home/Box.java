package ru.geekbrains.home;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruits;

    public float getWeight() {
        float sum = 0;
        for (T fruit : fruits) {
            sum += fruit.getWeight();
        }
        return sum;
    }

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public boolean compare(ru.geekbrains.home.Box box) {
        return this.getWeight() == box.getWeight();
    }

    public void intersperseIn(ru.geekbrains.home.Box<T> box){
        for (T fruit : fruits) {
            box.add(fruit);
        }
        fruits = new ArrayList<>();
    }
}

