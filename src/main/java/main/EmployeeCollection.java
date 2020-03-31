package main;

import java.util.*;

public class EmployeeCollection {

    public List<Employee> getEmployeesList(){
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
        return new ArrayList<>(employeeList);
    }

    public Set<Employee> getEmployeesSet(){
        return new HashSet<>(getEmployeesList());
    }

    public Set<Employee> getEmployeesTreeSet(){
        return new TreeSet<>(getEmployeesList());
    }
}
