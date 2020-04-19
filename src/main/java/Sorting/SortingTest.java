package Sorting;

import java.util.LinkedList;

/**
 * @author: Maya Verma
 * Date: 18/04/20
 * Time: 10:03 AM
 */
public class SortingTest<T extends Comparable> implements Sorting {

    public void insertionSort(LinkedList list, int lowindex, int highindex, boolean reversed) {

        for(int i=lowindex;i<highindex;++i){

            int j = i;

            if(reversed){

                while(j > 0 && ((T)list.get(j-1)).compareTo(((T)list.get(j)))<= 0 ){

                    T key = (T)list.get(j);
                    list.set(j,list.get(j-1));
                    list.set(j-1,key);
                    j = j-1;

                }
            }else{
                while(j > 0 && ((T)list.get(j-1)).compareTo((T)list.get(j))>=0){

                    T key = (T)list.get(j);
                    list.set(j,list.get(j-1));
                    list.set(j-1,key);
                    j = j-1;

                }
            }

        }
    }

    public void quicksort(LinkedList list, int lowindex, int highindex, boolean reversed) {
        //check for empty or null array
        if (list == null || list.size() == 0){
            return;
        }

        if (lowindex >= highindex){
            return;
        }

        //Get the pivot element from the middle of the list
        int middle = lowindex + (highindex - lowindex) / 2;
        T pivot = (T)list.get(middle);

        // make left < pivot and right > pivot
        int i = lowindex, j = highindex;
        while (i <= j)
        {
            //Check until all values on left side array are lower than pivot
            if(reversed){
                while (((T)list.get(i)).compareTo(pivot) > 0)
                {
                    i++;
                }
            }else
            {
                while (((T)list.get(i)).compareTo(pivot) < 0)
                {
                    i++;
                }
            }
            //Check until all values on left side array are greater than pivot
            if(reversed){
                while (((T)list.get(j)).compareTo(pivot)< 0 && j>0)
                {
                    j--;
                }
            }else{
                while (((T)list.get(j)).compareTo(pivot)>0 && j>0)
                {
                    j--;
                }
            }

            //Now compare values from both side of lists to see if they need swapping
            //After swapping move the iterator on both lists
            if (i <= j)
            {
                swap (list, i, j);
                i++;
                j--;
            }
        }
        //Do same operation as above recursively to sort two sub arrays
        if (lowindex < j){
            quicksort(list, lowindex, j, reversed);
        }
        if (highindex > i){
            quicksort(list, i, highindex, reversed);
        }
    }

    public void mergeSortLL(LinkedList list, boolean reversed) {
        mergeRecursive(list, 0 , list.size()-1, reversed);
    }


   private void doMergeSort(LinkedList<T> list, int l, int m, int r, boolean reversed)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        LinkedList<T> left = new LinkedList();
        LinkedList<T> right = new LinkedList();

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            left.add(i,list.get(l+i));

        for (int j=0; j<n2; ++j)
            right.add(j,list.get(m + 1+ j));

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            boolean cond = reversed ? (((T)left.get(i)).compareTo(((T)right.get(j)))>=0) : (((T)left.get(i)).compareTo(((T)right.get(j)))<=0);
            if (cond)
            {
                list.set(k,left.get(i));
                i++;
            }
            else
            {
                list.set(k,right.get(j));
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            list.set(k, left.get(i));
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            list.set(k,right.get(j));
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    private void mergeRecursive(LinkedList list, int l, int r, boolean reversed)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            mergeRecursive(list, l, m, reversed);
            mergeRecursive(list , m+1, r, reversed);

            // Merge the sorted halves
            doMergeSort(list, l, m, r, reversed);
        }
    }

    private void swap (LinkedList list, int x, int y)
    {
        T temp = (T)list.get(x);
        list.set(x,list.get(y));
        list.set(y,temp);
    }
}
