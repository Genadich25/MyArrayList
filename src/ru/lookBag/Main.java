package ru.lookBag;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        IntList myList = new IntList(10);
        myList.add(65);     //1
        myList.add(1);      //2
        myList.add(95);     //3
        myList.add(102);    //4
        myList.add(25);     //5
        myList.add(36);     //6
        myList.add(75);     //7
        myList.add(60);     //8
        myList.add(14);     //9
        myList.add(6);      //10
        myList.add(55);     //11
        int[] ints = myList.toArray();
        System.out.println("Не отсортированный массив!");
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("Отсортированный массив!");
        IntList.quickSort(ints, 0, myList.size() - 1);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }
}