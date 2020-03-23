package task_1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import main.*;


public class RemoveFirstName {
    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Andriy", "Barabanov", "Lviv", 23));
        employeeList.add(new Employee(2, "Oleg", "Kostyshyn", "New York", 40));
        employeeList.add(new Employee(2, "Oleg", "Kostyuk", "Kyiv", 21));
        employeeList.add(new Employee(3, "Vasyl", "Borovych", "Lviv", 71));
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

        //1. Creating Iterator of List and removing all objects with first name "Oleg"
        List<Employee> removeList = new ArrayList<>(employeeList);
        Iterator<Employee> removeListIterator = removeList.iterator();

        while (removeListIterator.hasNext()){
            if (removeListIterator.next().getFirstName().equals("Oleg")){
                removeListIterator.remove();
            }
        }
        System.out.println("Modified List after removing first name 'Oleg':  size: " + removeList.size());
        for (Employee emp:removeList){          //Print
            System.out.println(emp);
        }
        System.out.println();

        //List with first name without Oleg

        //First example
        List<String> nameOnly  = new ArrayList<>();

        for (Employee e:employeeList){
            String name = e.getFirstName();
            if (!name.equals("Oleg"))
                nameOnly.add(name);
        }
        System.out.println("First modified List of names :  size: " + nameOnly.size() + "\n" + nameOnly + "\n");

        //Second example with iterator().remove()
        List<String> nameOnly_2  = new ArrayList<>();
        for (Employee e:employeeList){
            String name = e.getFirstName();
            nameOnly_2.add(name);
        }
        Iterator<String> nameOnlyIterator = nameOnly_2.iterator();
       while (nameOnlyIterator.hasNext()){
           if (nameOnlyIterator.next().equals("Oleg")){
               nameOnlyIterator.remove();
           }
       }
        System.out.println("Second modified List of names :  size: " + nameOnly_2.size() + "\n" + nameOnly_2 + "\n");

        //Stream API
        Stream<Employee> removeStream = employeeList.stream();
        List<String> newList = removeStream
                .map(a->a.getFirstName())
                .filter(s->!s.equals("Oleg"))
                .collect(Collectors.toList());
        System.out.println("Stream API modified List of names :  size: " + newList.size() + "\n" + newList);
    }
}
