package Sorting;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: Maya Verma
 * Date: 18/04/20
 * Time: 10:34 AM
 */
public class MainClass {
    public static void main(String[] args) {

        Sorting sorting = new SortingTest();


        Scanner sc =new Scanner(System.in);
        while (true){
            int userSelection = takeUserSelection();
            switch (userSelection){
                case 1:
                    LinkedList<Integer> list = takeUserInput();
                    int order = getSortingOrder();
                    boolean reversed = order==1 ? true : false;
                    sorting.mergeSortLL(list,reversed);
                    System.out.println(list);
                    break;
                case 2:
                    list = takeUserInput();
                    order = getSortingOrder();
                    reversed = order==1 ? true : false;
                    sorting.quicksort(list,0,list.size(),reversed);
                    System.out.println(list);
                    break;
                case 3:
                    list = takeUserInput();
                    order = getSortingOrder();
                    reversed = order==1 ? true : false;
                    sorting.insertionSort(list,0,list.size(),reversed);
                    System.out.println(list);
                    break;
                case 4:
                    System.exit(0);
            }
        }

    }
    public static void displayMenu(){
        System.out.println("Press 1 for merge short");
        System.out.println("Press 2 for quick short");
        System.out.println("Press 3 for insertion short");
        System.out.println("Press 4 for exit");
    }

    public static Integer takeUserSelection(){
        displayMenu();
        Scanner sc =new Scanner(System.in);
        return sc.nextInt();
    }

    private static LinkedList takeUserInput(){
        System.out.println("Please inter data for short. Press -1 to finish your entry");
        Scanner sc =new Scanner(System.in);
        LinkedList<Integer> list =new LinkedList<Integer>();
        int n;
        while (((n = sc.nextInt()) != -1)){
            list.add(n);
        }
        return list;
    }

    private static int getSortingOrder(){
        System.out.println("Please enter sorting order. 0 for ascending 1 for descending");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

}
