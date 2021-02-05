package com.fx;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        FX_ArrayList<Person> list = new FX_ArrayList<>(2);
        list.add(new Person(1,"zs"));
        list.add(new Person(2,"ls"));
        list.add(new Person(3,"ww"));
        list.add(new Person(4,"ml"));
        System.out.println(list);
        System.out.println(list.size());
        list.add(2, new Person(23, "hhhh"));
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        System.out.println(list.get(1));
        System.out.println(list.isEmpty());
        System.out.println(list.contains(new Person(1, "zs")));
        System.out.println(list.indexOf(new Person(1, "zs")));
        System.out.println(list.set(3, new Person(50, "ddddd")));
        System.out.println(list);
        list.clear();
        System.out.println(list.isEmpty());
    }
}
