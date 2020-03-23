package main;

import java.util.*;

public class SortEmployee {
    static EmployeeCollection employeeCollection = new EmployeeCollection();

    public static void main(String[] args) {

            //Sort using Collections
        System.out.println("HashSet elements in sorted order using List: " + " size " + sortUsingCollections().size());
        for (Employee emp : sortUsingCollections()) {
            System.out.println(emp);
        }
        System.out.println();

        //Sort using Collections and Comparator
        System.out.println("HashSet elements in sorted order using List: " + " size " + sortUsingComparatorAndCollections().size());
        for (Employee emp : sortUsingComparatorAndCollections()) {
            System.out.println(emp);
        }

    }

    /**
     * Посортувати колекцію за допомогою Collections класу
     * */
    private static Set<Employee> sortUsingCollections(){
        List<Employee> sortedList = employeeCollection.getEmployeesList();
        Collections.sort(sortedList);
        Set<Employee> sortedSet = employeeCollection.getEmployeesSet(sortedList);
            return sortedSet;
    }

    /**
     * Посортувати колекцію за допомогою Collections класу та Comparator інтерфейсу
     * */
    private static Set<Employee> sortUsingComparatorAndCollections(){
        List<Employee> sortedList = employeeCollection.getEmployeesList();
        Collections.sort(sortedList, new IdSorted().thenComparing(new FirstNameSorted()).thenComparing(new LastNameSorted()));
        Set<Employee> employeeSortedSet = new LinkedHashSet<>(sortedList);
        return employeeSortedSet;
    }
}
