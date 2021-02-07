package com.fx._01_线性表.abstractClass;

import com.fx._01_线性表.Inrterface.List;

public abstract class AbstractList<E> implements List<E> {

    // 抽象出来公共有的属性
    // protected修饰的可以被子类访问到
    protected int size;

    /**
     *
     * @return 数组中元素的个数
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     *
     * @return 数组是否为空
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 判断是否包含传入的参数
     * @param element
     * @return
     */
    @Override
    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    @Override
    public void add(E element) {
        add(size , element);
    }

    @Override
    public abstract E get(int index);

    @Override
    public abstract E set(int index, E element);

    @Override
    public abstract void add(int index, E element);

    @Override
    public abstract E remove(int index);

    @Override
    public abstract int indexOf(E element);

    @Override
    public abstract void clear();

    // 子类可以复用的方法
    /**
     * 判断传入add方法中的index参数是否合法
     */
    protected void rangeCheckForAdd(int index) {
        if (index < 0 || index > this.size) {
            throw new IllegalArgumentException("传入的参数有误");
        }
    }

    /**
     * 判断传入的index是否合法
     * @param index
     */
    protected void rangeCheck(int index) {
        if (index < 0 || index > this.size - 1) {
            throw new IllegalArgumentException("传入的参数有误");
        }
    }
}