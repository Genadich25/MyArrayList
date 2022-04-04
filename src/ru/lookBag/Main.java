package ru.lookBag;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StringListInt stringList = new StringList();

        System.out.println(stringList.add("Удивительно"));
        System.out.println(stringList.add("Чудесно"));
        System.out.println(stringList.size());

        System.out.println(stringList.add("Замечательно"));
        System.out.println(stringList.size());
        System.out.println();

        System.out.println(Arrays.toString(stringList.toArray()));
        System.out.println();

        stringList.add(1,"Ужас как");
        System.out.println(Arrays.toString(stringList.toArray()));
        System.out.println();

        stringList.set(2,"Восхитительно");
        System.out.println(Arrays.toString(stringList.toArray()));
        System.out.println();

        stringList.remove("Ужас как");
        System.out.println(Arrays.toString(stringList.toArray()));
        System.out.println();

        stringList.remove(0);
        System.out.println(Arrays.toString(stringList.toArray()));
        System.out.println();

        System.out.println(stringList.contains("Замечательно"));
        System.out.println(stringList.contains("Ужас как"));
        System.out.println();

        stringList.add("Восхитительно");
        System.out.println(Arrays.toString(stringList.toArray()));
        System.out.println();

        System.out.println(stringList.indexOf("Восхитительно"));
        System.out.println();

        System.out.println(stringList.lastIndexOf("Восхитительно"));
        System.out.println();

        System.out.println(stringList.get(1));
        System.out.println();

        StringList stringList2 = new StringList();
        stringList2.add("Восхитительно");
        stringList2.add("Замечательно");
        stringList2.add("Восхитительно");
        System.out.println(Arrays.toString(stringList2.toArray()));
        System.out.println();

        System.out.println(stringList.equals(stringList2));
        System.out.println();

        stringList2.remove("Восхитительно");
        System.out.println(stringList.equals(stringList2));
        System.out.println();

        stringList2.add(0, "Ужас как");
        System.out.println(stringList.equals(stringList2));
        System.out.println();

        for (int i = 0; i < stringList.size(); i++) {
            System.out.println(stringList.get(i));
        }
        System.out.println();

        System.out.println(stringList.isEmpty());
        System.out.println();

        stringList.clear();
        System.out.println(stringList.isEmpty());

    }
}