package Sorting;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: Maya Verma
 * Date: 18/04/20
 * Time: 10:34 AM
 */
public class MainClass {
    public static void main(String[] args) {
        Sorting sorting = new SortingTest();
        while (true){
            int userSelection = takeUserSelection();
            switch (userSelection){
                case 1:
                    LinkedList<?> list = typeOfData();
                    int order = getSortingOrder();
                    boolean reversed = order==1 ? true : false;
                    sorting.mergeSortLL(list,reversed);
                    print(list);
                    break;
                case 2:
                    list = typeOfData();
                    order = getSortingOrder();
                    reversed = order==1 ? true : false;
                    sorting.quicksort(list,0,list.size()-1,reversed);
                    print(list);
                    break;
                case 3:
                    list = typeOfData();
                    order = getSortingOrder();
                    reversed = order==1 ? true : false;
                    sorting.insertionSort(list,0,list.size(),reversed);
                    print(list);
                    break;
                case 4:
                    System.exit(0);
            }
        }

    }

    private static void print(LinkedList list){
        System.out.print("\nSorter list:[ ");
        for (Object o : list) {
            System.out.print(o+" ");
        }
        System.out.println("]");
    }
    public static void displayMenu(){
        System.out.println("Press 1 for merge short");
        System.out.println("Press 2 for quick short");
        System.out.println("Press 3 for insertion short");
        System.out.println("Press 4 for exit");
    }


    public static LinkedList typeOfData(){
        System.out.println("Please select dataType.");
        System.out.println("Press 1 for Integer");
        System.out.println("Press 2 for Double");
        System.out.println("Press 3 for String");
        Scanner sc = new Scanner(System.in);

        while(true){
           int userSelection = sc.nextInt();
            switch (userSelection){
                case 1:
                    return takeUserInput(Integer.class);
                case 2:
                    return takeUserInput(Double.class);
                case 3:
                    return takeUserInput(String.class);
                default:
                    System.out.println("Please select right option");
                    break;
            }
        }

    }

    public static Integer takeUserSelection(){
        displayMenu();
        Scanner sc =new Scanner(System.in);
        return sc.nextInt();
    }

    private static<T> LinkedList<T> takeUserInput(Class<T> type){

        Scanner sc =new Scanner(System.in);
        LinkedList<T> list =new LinkedList();

        if(type == Integer.class){
            System.out.println("Please inter data. Enter -1 to finish your entry");
            Integer n;
            while (((n = sc.nextInt()) != -1)){
                list.add((T)n);
            }
        }
        if(type == Double.class){
            System.out.println("Please inter data. Enter -1 to finish your entry");
            Double n;
            while (((n = sc.nextDouble()) != -1)){
                list.add((T)n);
            }
        }
        if(type == String.class){
            System.out.println("Please inter data. Enter quit to finish your entry");
            String n;
            while (!((n = sc.next()).equalsIgnoreCase("quit"))){
                list.add((T)n);
            }
        }
        return list;
    }

    private static int getSortingOrder(){
        System.out.println("Please enter sorting order. 0 for ascending 1 for descending");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

}
