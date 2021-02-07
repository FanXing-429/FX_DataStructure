package com.fx._01_线性表;

import com.fx._01_线性表._01_动态数组.FX_ArrayList;
import com.fx._01_线性表._02_链表.FX_SingleLinkedList;
import com.fx._01_线性表.testClass.Person;

public class Main {
    public static void main(String[] args) {
//        arrayList_Test();
        linkedList_Test();
    }

    private static void arrayList_Test() {
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

    private static void linkedList_Test() {
        FX_SingleLinkedList linkedList = new FX_SingleLinkedList();
        linkedList.add(1);
        System.out.println(linkedList.get(0));
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        System.out.println(linkedList);
        linkedList.set(1, 5);
        System.out.println(linkedList);
        System.out.println(linkedList.get(3));
        System.out.println(linkedList.contains(0));
        System.out.println(linkedList.contains(5));
        System.out.println(linkedList.indexOf(1));
        linkedList.remove(1);
        System.out.println(linkedList);
        linkedList.clear();
        System.out.println(linkedList);
    }
}
