package com.fx._01_线性表._02_链表;

import com.fx._01_线性表.abstractClass.AbstractList;

import java.util.Objects;

public class FX_SingleLinkedList<E> extends AbstractList<E> {

    // LinkedList 的内部属性

    private Node<E> first;

    private class Node<E> {
        E element;
        Node<E> next;

        @Override
        public String toString() {
            return "element=" + element;
        }
    }

    /**
     * 通过index获得对应的元素
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        rangeCheck(index);
        return getNode(index).element;
    }

    /**
     * 在规定的index位置上设置element的值
     * @param index
     * @param element
     * @return
     */
    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        Node<E> old = getNode(index);
        old.element = element;
        return old.element;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if (index == 0) {
            first = new Node<>();
            first.element = element;
            this.first.next = null;
        }else {
            Node<E> indexPre =  getNode(index - 1);
            Node<E> newNode = new Node<>();
            newNode.element = element;
            indexPre.next = newNode;
            newNode.next = indexPre.next.next;
        }
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        if (index == 0) {
            first = first.next;
        } else {
            Node<E> preNode = getNode(index - 1);
            Node<E> removeNode = preNode.next;
            preNode.next = preNode.next.next;
            removeNode.next = null;
        }
        size--;
        return get(index);
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (element == get(i)) {
                    return i;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            if (element.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        first.next = null;
        first = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size:" + size).append("   LinkedList:[");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(getNode(i).element);
        }
        stringBuilder.append("];");
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FX_SingleLinkedList<?> that = (FX_SingleLinkedList<?>) o;
        return Objects.equals(first, that.first);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first);
    }

    // 私有方法

    /**
     * 通过index寻找对应位置上的Node
     * @param index
     * @return
     */
    private Node<E> getNode(int index) {
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
}
