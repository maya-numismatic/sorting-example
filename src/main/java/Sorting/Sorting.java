package Sorting;

import java.util.LinkedList;

/**
 * @author: Maya Verma
 * Date: 18/04/20
 * Time: 10:03 AM
 */
public interface Sorting<T extends Comparable<T>> {
    public void insertionSort(LinkedList<T> list, int lowindex, int highindex, boolean reversed);

    public void quicksort(LinkedList<T> list, int lowindex, int highindex, boolean reversed);

    public void mergeSortLL(LinkedList<T> list, boolean reversed);
}
