package com.fx._01_线性表._01_动态数组;

import com.fx._01_线性表.Inrterface.List;
import com.fx._01_线性表.abstractClass.AbstractList;

import java.util.Arrays;
import java.util.Objects;

public class FX_ArrayList<E> extends AbstractList<E> {
    // 动态数组的属性
//    private int size; 在AbstractList中已经声明了
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    // 构造方法
    public FX_ArrayList(int capacity) {
        capacity  = capacity > DEFAULT_CAPACITY ? capacity : DEFAULT_CAPACITY;
        this.elements = (E[]) new Object[capacity];
    }

    /**
     * 默认一次有10个初始容量
     */
    public FX_ArrayList() {
        this(DEFAULT_CAPACITY);
    }


    // 动态数组所要实现的对外提供的方法

    /**
     * 在特定位置添加元素
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        // 判断传入的index是否合法
        rangeCheckForAdd(index);
        // 先判断是否需要扩展数组容量
        ensureCapacity();
        // 添加时，后面的元素先要一一移动
        for (int i = index; i < size; i++) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        size++;
    }


    /**
     * 通过索引获得数组中相应位置上的元素
     * @param index
     * @return 元素
     */
    @Override
    public E get(int index) {
        rangeCheck(index);
        return this.elements[index];
    }

    /**
     *
     * @param index
     * @param element
     * @return 返回被替换的元素
     */
    @Override
    public E set(int index, E element) {
        E oldElement = get(index);
        elements[index] = element;
        return oldElement;
    }


    /**
     *
     * @param index
     * @return 删除对应位置的元素
     */
    @Override
    public E remove(int index) {
        E oldElement = get(index);
        // 让后面的元素前移
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        size--;
        elements[size] = null;
        return oldElement;
    }

    /**
     *
     * @param element
     * @return 返回传入元素的index
     */
    @Override
    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 清理掉动态数组中的元素
     */
    @Override
    public void clear() {
//        elements = null; 这种方法不利于重复利用内存空间，加大了开辟内存的次数
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FX_ArrayList<?> that = (FX_ArrayList<?>) o;
        return size == that.size && Arrays.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(elements);
        return result;
    }

    // 封装的一些内部使用的方法
    /**
     * 判断是否需要进行扩容
     */
    private void ensureCapacity() {
        if (this.size + 1  > elements.length) {
            this.elements = copyAndAdd(elements);
        }
    }

    /**
     * 进行扩容操作
     * @param elements
     * @return
     */
    private E[] copyAndAdd(Object[] elements) {
        Object[] newElements = new Object[elements.length + (elements.length >> 1)];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        System.out.println("从" + elements.length + "扩容到" + newElements.length);
        return (E[])newElements;
    }

//    @Override
//    public String toString() {
//        return "FX_ArrayList{" +
//                "size=" + size +
//                ", elements=" + Arrays.toString(elements) +
//                '}';
//    }

    // 改进版的toString
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size="+ size).append(",[");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(elements[i]);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
