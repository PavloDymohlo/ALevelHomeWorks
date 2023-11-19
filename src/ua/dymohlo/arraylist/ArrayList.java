package ua.dymohlo.arraylist;
/*
Implement ArrayList
*/

import java.util.Arrays;
import java.util.Objects;

public class ArrayList<T> {
    private Object[] array;
    private int size;
    private int count = 0;

    public ArrayList(int size) {
        this.size = size;
        this.array = new Object[size];
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }

    void add(T element) {
        reserveArray();
        array[count++] = element;
    }

    private void reserveArray() {
        if(count >= size){
            Object[] newArray = new Object[array.length+1];
            System.arraycopy(array,0,newArray,0,size);
            array = newArray;
        }
    }

    void add(T element, int index) {
        Objects.checkIndex(index,size+1);
        reserveArray();
        System.arraycopy(array, index, array, index+1, size-index);
         array[index] = element;
        size++;
    }

    int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (element == array[i]) {
                return i;
            }
        }
        return -1;
    }

    boolean isContains(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    T get(int index) {
        Objects.checkIndex(index, size);
        return (T) array[index];
    }

    T remove(int index) {
        Objects.checkIndex(index, size);
        T removedElement = (T) array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return removedElement;
    }
}