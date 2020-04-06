package main;

import comparator.*;

import java.util.*;
import java.util.stream.Collectors;

public class SortEmployee {

    /**
     * Посортувати колекцію за допомогою Collections класу
     * */
    public Set<Employee> sortUsingCollections(Set<Employee> employeeSet){
        List<Employee> sortedList = new ArrayList<>(employeeSet);
        Collections.sort(sortedList);
        return new LinkedHashSet<>(sortedList);
    }

    /**
     * Посортувати колекцію за допомогою Collections класу та Comparator інтерфейсу
     * */
    public Set<Employee> sortUsingComparatorAndCollections(Set<Employee> employeeSet, Comparator<Employee> employeeComparator){
        List<Employee> sortedList = new ArrayList<>(employeeSet);
        Collections.sort(sortedList, employeeComparator);
        return new LinkedHashSet<>(sortedList);
    }

    /**
     * Посортувати колекцію за допомогою Stream API
     * */
    public Set<Employee> sortUsingStream(Set<Employee> employeeSet){
        return  employeeSet.stream()
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    /**
     * Посортувати колекцію за допомогою Stream API та Collections
     * */
    public Set<Employee> sortUsingComparatorAndStream(Set<Employee> employeeSet, Comparator<Employee> employeeComparator){
        return  employeeSet.stream()
                .sorted(employeeComparator)
                .collect(Collectors.toCollection(LinkedHashSet::new));
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
