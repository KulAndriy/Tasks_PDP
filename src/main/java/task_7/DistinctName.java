package task_7;

import main.Employee;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DistinctName {
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
        employeeList.add(new Employee(1, "Oleg", "Serhiyshuk", "Kyiv", 76));
        employeeList.add(new Employee(2, "Oleg", "Kostyshyn", "New York", 40));
        employeeList.add(new Employee(8, "Dmytro", "Baran", "Kyiv", 48));
        employeeList.add(new Employee(5, "Vasyl", "Костин", "Dnipro", 70));
        employeeList.add(new Employee(1, "Andriy", "Barabanov", "Lviv", 23));
        employeeList.add(new Employee(10, "Taras", "Galyk", "Kyiv", 34));
        employeeList.add(new Employee(1, "Andriy", "Barabanov", "Lviv", 23));
        employeeList.add(new Employee(7, "Anatoloi", "Fabra", "Odesa", 30));
        employeeList.add(new Employee(11, "Borys", "Var", "Odesa", 28));

        Set<String> employeesNames = new HashSet<>();
        for (Employee e:employeeList){
            if (e.getAddress().equals("Kyiv")){
                employeesNames.add(e.getFirstName());
            }
        }
        //Print collection List
        System.out.println("New collection with unique fistName who lives in Kyiv :  size: " + employeesNames.size() + "\n" + employeesNames + "\n");

        //Stream API
        Set<String> newNamesSet = employeeList.stream()
                .filter(s->s.getAddress().equals("Kyiv"))
                .map(s->s.getFirstName())
                .collect(Collectors.toSet());
        System.out.println("Stream API with unique firstName who lives in Kyiv :  size: " + newNamesSet.size() + "\n" + newNamesSet);
    }
}
