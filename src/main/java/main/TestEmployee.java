package main;

import main.Employee;
import main.FirstNameSorted;
import main.IdSorted;
import main.LastNameSorted;

import java.util.*;
import java.util.stream.Collectors;

public class TestEmployee {

    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Andriy", "Barabanov", "Lviv", 23));
        employeeList.add(new Employee(2, "Oleg", "Kostyshyn", "New York", 40));
        employeeList.add(new Employee(2, "Oleg", "Kostyuk", "Kyiv", 21));
        employeeList.add(new Employee(3, "Vasl", "Borovych", "Lviv", 71));
        employeeList.add(new Employee(4, "Dmytro", "Vanish", "Kyiv", 28));
        employeeList.add(new Employee(5, "Taras", "Baras", "New York", 75));
        employeeList.add(new Employee(1, "Andriy", "Barabanov", "Lviv", 23));
        employeeList.add(new Employee(12, "Vitaliy", "Fava", "Dnipro", 19));
        employeeList.add(new Employee(8, "Dmytro", "Orlyk", "Kyiv", 30));
        employeeList.add(new Employee(1, "Oleg", "Barabanov", "Lviv", 23));
        employeeList.add(new Employee(1, "Oleg", "Serhiyshuk", "Kyiv", 26));
        employeeList.add(new Employee(2, "Oleg", "Kostyshyn", "New York", 40));
        employeeList.add(new Employee(8, "Dmytro", "Baran", "Kyiv", 48));
        employeeList.add(new Employee(5, "Vasyl", "Костин", "Dnipro", 70));
        employeeList.add(new Employee(1, "Andriy", "Barabanov", "Lviv", 23));
        employeeList.add(new Employee(10, "Taras", "Galyk", "Kyiv", 34));
        employeeList.add(new Employee(1, "Andriy", "Barabanov", "Lviv", 23));
        employeeList.add(new Employee(7, "Anatoloi", "Fabra", "Odesa", 30));
        employeeList.add(new Employee(11, "Borys", "Var", "Odesa", 28));
        System.out.println(employeeList.size());

            //Set collection
        Set<Employee> employeeSet = new HashSet<>(employeeList);
        System.out.println("Original HashSet: " + " size " + employeeSet.size());
        for(Employee emp : employeeSet){
            System.out.println(emp);
        }
        System.out.println();

            //Sorting Set using sorted() method without parameters of Stream API
        System.out.println("Sorted HashSet using sorted() methods without parameters of Stream API: ");
        employeeSet.stream()
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new))
                .forEach(System.out::println);
        System.out.println();

            //Sorting Set using sorted() method with parameters of Stream API
        System.out.println("Sorted HashSet using sorted() methods with parameters of Stream API: ");
        employeeSet.stream()
                .sorted(Comparator.comparing(Employee::getId).thenComparing(Employee::getFirstName).thenComparing(Employee::getLastName))
                .collect(Collectors.toCollection(LinkedHashSet::new))
                .forEach(System.out::println);
        System.out.println();

            //Sorted Set collection from List
        List <Employee> employeeSortedList = new ArrayList<>(employeeSet);
        Collections.sort(employeeSortedList, new IdSorted().thenComparing(new FirstNameSorted()).thenComparing(new LastNameSorted()));
        Set<Employee> employeeSortedSet = new LinkedHashSet<>(employeeSortedList);
        System.out.println("HashSet elements in sorted order using List: " + " size " + employeeSortedSet.size());
        for (Employee emp : employeeSortedSet) {
            System.out.println(emp);
        }
        System.out.println();

            //Convert HashSet to TreeSet for sorting
        Set<Employee> employeeTreeSet = new TreeSet<>(new IdSorted().thenComparing(new FirstNameSorted()).thenComparing(new LastNameSorted()));
        employeeTreeSet.addAll(employeeList);
        System.out.println("TreeSet elements from List: " + " size " + employeeTreeSet.size());
        for (Employee emp : employeeSortedSet) {
            System.out.println(emp);
        }
        System.out.println();
    }

}
