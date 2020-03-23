package main;

import main.Employee;

import java.util.Comparator;

public class FirstNameSorted implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
