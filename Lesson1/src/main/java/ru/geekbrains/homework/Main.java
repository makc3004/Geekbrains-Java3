package ru.geekbrains.homework;

import java.util.ArrayList;
import java.util.Arrays;

/*
1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
2. Написать метод, который преобразует массив в ArrayList;
3. Большая задача:
a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку
 нельзя сложить и яблоки, и апельсины;
c. Для хранения фруктов внутри коробки можете использовать ArrayList;
d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес яблока
 - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут
 в compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем
  сравнивать с коробками с апельсинами);
f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку
 фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается,
  а в другую перекидываются объекты, которые были в этой коробке;
g. Не забываем про метод добавления фрукта в коробку.
 */

public class Main {

    private static class ArrayList2<E> extends ArrayList{
        public void add(E[] array){
            for (int i = 0; i < array.length; i++) {
                super.add(array[i]);
            }
        }
    }//task2

    public static void main(String[] args) {
        task2();
        task3();
        //Task1
        Integer arr1[] = {1, 2, 3, 4, 5, 6, 7};
        String arr2[] = {"A", "B", "C"} ;
        swap(arr1,1,4);
        swap(arr2,0,2);

    }
    public static void swap(Object[] arr, int n1, int n2){
        System.out.println("Task1: "+ Arrays.toString(arr));
        Object sw = arr[n1];
        arr[n1]=arr[n2];
        arr[n2]=sw;
        System.out.println("The result of the replacement: "+Arrays.toString(arr)+"\n================================");
    }
    private static void task2() {
        String[] strings = new String[10];
        Integer[] integers = new Integer[10];

        initStr(strings);
        initInt(integers);

        ArrayList2<String> stringsList = new ArrayList2<>();
        ArrayList2<Integer> integersList = new ArrayList2<>();

        stringsList.add(strings);
        integersList.add(integers);
        System.out.println("Task2");

        System.out.println(stringsList.toString());
        System.out.println(integersList.toString());
    }
    private static void initInt(Integer[] integers) {
        for (int i = 0; i < integers.length; i++) {
            integers[i] = i;
        }
    }

    private static void initStr(String[] str) {
        for (int i = 0; i < str.length; i++) {
            str[i] = String.valueOf((char)(i + 97));
        }
    }
    private static void task3() {
        System.out.println("Task3");
        Box<Apple> boxForApple1 = new Box<>();
        Box<Apple> boxForApple2 = new Box<>();
        Box<Orange> boxForOrange = new Box<>();

        for (int i = 0; i < 25; i++) {
            boxForApple1.add(new Apple());
        }

        System.out.println("Вес первой коробки с яблоками - " + boxForApple1.getWeight());

        for (int i = 0; i < 50; i++) {
            boxForApple2.add(new Apple());
        }

        System.out.println("Вес второй коробки с яблоками - " + boxForApple2.getWeight());
        System.out.println("Пересыпаем яблоки в одну коробку");
        boxForApple1.intersperseIn(boxForApple2);

        for (int i = 0; i < 50; i++) {
            boxForOrange.add(new Orange());
        }
        System.out.println("Вес коробки с апельсинами - " + boxForOrange.getWeight());

        System.out.println("Ящики имеют одинаковый вес - " + boxForApple2.compare(boxForOrange));
    }
}
//