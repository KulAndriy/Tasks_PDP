package task_9;

import main.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FiveNames {
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

        List<String> fiveNames = new ArrayList<>();
        for (Employee e:employeeList){
            if (!(fiveNames.size() ==5)) {
                fiveNames.add(e.getFirstName());
            }
        }
        System.out.println("The collection of Names:  size: " + fiveNames.size() + "\n" + fiveNames + "\n");

        //Stream API
        List<String> fiveNameStream = employeeList.stream()
                .map(s->s.getFirstName())
                .limit(5)
                .collect(Collectors.toList());
        System.out.println("The Stream collection of Names: " + fiveNameStream.size());
        fiveNameStream.forEach(System.out::println);
    }
}
