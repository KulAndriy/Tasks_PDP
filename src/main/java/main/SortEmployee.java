package main;

import comparator.FirstNameSorted;
import comparator.IdSorted;
import comparator.LastNameSorted;

import java.util.*;
import java.util.stream.Collectors;

public class SortEmployee {

    /**
     * Посортувати колекцію за допомогою Collections класу
     * */
    public Set<Employee> sortUsingCollections(Set<Employee> employeeSet){
        List<Employee> sortedList = new ArrayList<>(employeeSet);
        Collections.sort(sortedList);
        Set<Employee> sortedSet = new LinkedHashSet<>(sortedList);
            return sortedSet;
    }

    /**
     * Посортувати колекцію за допомогою Collections класу та Comparator інтерфейсу
     * */
    public Set<Employee> sortUsingComparatorAndCollections(Set<Employee> employeeSet){
        List<Employee> sortedList = new ArrayList<>(employeeSet);
        Collections.sort(sortedList, new IdSorted().thenComparing(new FirstNameSorted()).thenComparing(new LastNameSorted()));
        Set<Employee> employeeSortedSet = new LinkedHashSet<>(sortedList);
        return employeeSortedSet;
    }

    /**
     * Посортувати колекцію за допомогою Stream API
     * */
    public Set<Employee> sortUsingStream(Set<Employee> employeeSet){
        Set<Employee> sortedSet =  employeeSet.stream()
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
        return sortedSet;
    }

    /**
     * Посортувати колекцію за допомогою Stream API та Collections
     * */
    public Set<Employee> sortUsingComparatorAndStream(Set<Employee> employeeSet){
        List <Employee> employeeSortedList = new ArrayList<>(employeeSet);
        Collections.sort(employeeSortedList, new IdSorted().thenComparing(new FirstNameSorted()).thenComparing(new LastNameSorted()));
        Set<Employee> employeeSortedSet = new LinkedHashSet<>(employeeSortedList);
        return employeeSortedSet;
    }

    /**
     * Конвертувати HashSet в TreeSet
     * */

    public Set<Employee> convertHashSetToTreeSet(Set<Employee> employeeSet){
        Set<Employee> employeeTreeSet = new TreeSet<>(new IdSorted().thenComparing(new FirstNameSorted()).thenComparing(new LastNameSorted()));
        employeeTreeSet.addAll(employeeSet);
        return employeeTreeSet;
    }

}
