package task_3;

import main.Employee;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeAge {
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

        //3. Витягнути колекцію працівників віком > 25 років

        //The First method
        List<Employee> ageList = new ArrayList<>(employeeList);
        Iterator<Employee> ageIterator = ageList.iterator();

        while (ageIterator.hasNext()){
            if (ageIterator.next().getAge()<25){
                ageIterator.remove();
            }
        }
        //Print collection List
        System.out.println("The First method where age >25:  size: " + ageList.size());
        for (Employee e:ageList){
            System.out.println(e);
        }
        System.out.println();


        //The second method
        List<Employee> ageAddToNew = new ArrayList<>();
        for (Employee e:employeeList){
            if (e.getAge()>25){
                ageAddToNew.add(e);
            }
        }
        //Print collection List
        System.out.println("The second method where age >25:  size: " + ageAddToNew.size());
        for (Employee e:ageAddToNew){
            System.out.println(e);
        }
        System.out.println();

        //Stream API
        List<Employee> ageStream = employeeList.stream()
                .filter(s->s.getAge()>25)
                .collect(Collectors.toList());
        System.out.println("Stream collection where age >25:  size: " + ageStream.size());
        ageStream.forEach(System.out::println);
        System.out.println();
    }
}
