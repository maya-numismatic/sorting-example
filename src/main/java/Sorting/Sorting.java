package Sorting;

import java.util.LinkedList;

/**
 * @author: Maya Verma
 * Date: 18/04/20
 * Time: 10:03 AM
 */
public interface Sorting {
    public void insertionSort(LinkedList<Integer> list, int lowindex, int highindex, boolean reversed);

    public void quicksort(LinkedList<Integer> list, int lowindex, int highindex, boolean reversed);

    public void mergeSortLL(LinkedList<Integer> list, boolean reversed);
}
