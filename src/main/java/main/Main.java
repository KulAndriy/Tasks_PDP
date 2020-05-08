package main;

import annotation.EmployeeProcessorAnnotationLogic;
import annotation.EmployeeProcessorTypeAnnotation;
import comparator.ComparatorProcessor;
import comparator.ComparatorType;
import exception.AgeOfEmployeeLessZeroException;
import exception.EmployeeCollectionIsEmptyException;
import exception.NoSuchEmployeeException;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EmployeeCollection employeeCollection = new EmployeeCollection();
        SortEmployee sortEmployee = new SortEmployee();
        EmployeesProcessor employeesProcessor = new EmployeesProcessor();
        ComparatorProcessor comparatorProcessor = new ComparatorProcessor();
        EmployeeProcessorAnnotationLogic annotationLogic = new EmployeeProcessorAnnotationLogic();

        annotationLogic.annotationProcessing();

        /**
         * Create a HashSet collection
         */
        Set<Employee> employeeSet = employeeCollection.getEmployeesSet();
        System.out.println("Original created HashSet: " + " size " + employeeSet.size());
        employeeSet.forEach(System.out::println);
        System.out.println();

        /**
         * Sorting HashSet using Collections class
         */
        Set<Employee> sortingUsingCollectionsClass = sortEmployee.sortUsingCollections(employeeSet);
        System.out.println("Sorting HashSet using Collections class: " + " size " + sortingUsingCollectionsClass.size());
        sortingUsingCollectionsClass.forEach(System.out::println);
        System.out.println();

        /**
         * Sorting HashSet using Collections class with Comparator
         */
        Set<Employee> sortingUsingCollectionsWithComparator = sortEmployee.sortUsingComparatorAndCollections(employeeSet, comparatorProcessor.getComparator(ComparatorType.LAST_NAME_SORTED));
        System.out.println("Sorting HashSet using Collections class with Comparator: " + " size " + sortingUsingCollectionsWithComparator.size());
        sortingUsingCollectionsWithComparator.forEach(System.out::println);
        System.out.println();

        /**
         * Sorting HashSet using StreamAPI
         */
        Set<Employee> sortingUsingStreamAPI = sortEmployee.sortUsingStream(employeeSet);
        System.out.println("Sorting HashSet using Stream API: " + " size " + sortingUsingStreamAPI.size());
        sortingUsingStreamAPI.forEach(System.out::println);
        System.out.println();

        /**
         * Sorting HashSet using StreamAPI and Comparator
         */
        Set<Employee> sortingUsingStreamWithComparator = sortEmployee.sortUsingComparatorAndStream(employeeSet, comparatorProcessor.getComparator(ComparatorType.LAST_NAME_SORTED));
        System.out.println("Sorting HashSet using Stream API and Comparator: " + " size " + sortingUsingStreamWithComparator.size());
        sortingUsingStreamWithComparator.forEach(System.out::println);
        System.out.println();

        /**
         * Конвертувати HashSet в TreeSet
         * */
        Set<Employee> convertingHashSetToTreeSet = sortEmployee.convertHashSetToTreeSet(employeeSet, comparatorProcessor.getComparator(ComparatorType.ID_SORTED));
        System.out.println("Converting HashSet to TreeSet: " + " size " + convertingHashSetToTreeSet.size());
        convertingHashSetToTreeSet.forEach(System.out::println);
        System.out.println();



        /**
         * TASK #1
         * Витягнути ліст імен, Видалити всіх Олегів з ліста (відповідно, щоб у лісті було їх хоча б кілька)
         */
        try {
            List<String> removeNameWithIterator = employeesProcessor.removeEmployee(employeeCollection.getEmployeesList(), ExecutionType.ITERATOR, "Ole");
            System.out.println("List of names without name Oleg by Iterator:  size: " + removeNameWithIterator.size() + "\n" + removeNameWithIterator + "\n");
        } catch (NoSuchEmployeeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


        try {
            List<String> removeNameWithStream = employeesProcessor.removeEmployee(employeeCollection.getEmployeesList(), ExecutionType.STREAM, "Ole");
            System.out.println("List of names without name Oleg by Stream API:  size: " + removeNameWithStream.size() + "\n" + removeNameWithStream + "\n");
        } catch (NoSuchEmployeeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("*************************************************************************************************************************" + "\n");

        /**
         * TASK #2
         * Витягнути ліст імен,Змінити всіх Андріїв на Василів (2-3 Андрія щоб була у лісті)
         */

        List<String> changeNameWithForeach = employeesProcessor.getChangedNameOfEmployee(employeeCollection.getEmployeesList(),
                ExecutionType.FOREACH, "Andriy", "Vasyli");
        System.out.println("List of names wit replacement name Andriy to Vasyl by foreach:  size: " + changeNameWithForeach.size() + "\n" + changeNameWithForeach + "\n");

        List<String> changeNameWithIterator = employeesProcessor.getChangedNameOfEmployee(employeeCollection.getEmployeesList(),
                ExecutionType.ITERATOR,"Andriy","Vasylaa");
        System.out.println("List of names wit replacement name Andriy to Vasyl by Iterator:  size: " + changeNameWithIterator.size() + "\n" + changeNameWithIterator + "\n");

        List<String> changeNameWithStream = employeesProcessor.getChangedNameOfEmployee(employeeCollection.getEmployeesList(),
                ExecutionType.STREAM, "Andriy", "Vasylaaa");
        System.out.println("List of names wit replacement name Andriy to Vasyl by Stream API:  size: " + changeNameWithStream.size() + "\n" + changeNameWithStream + "\n");
        System.out.println("*************************************************************************************************************************" + "\n");

        /**
         * TASK #3
         * Витягнути колекцію працівників віком > 25 років
         */
        List<Employee> employeesMoreTwentyFiveAgeForeach = employeesProcessor.getEmployeesMoreTwentyFiveAge(employeeCollection.getEmployeesList(), ExecutionType.FOREACH);
        System.out.println("The List where age of Employees more than 25 by Foreach:  size " + employeesMoreTwentyFiveAgeForeach.size());
        employeesMoreTwentyFiveAgeForeach.forEach(System.out::println);
        System.out.println();

        List<Employee> employeesMoreTwentyFiveAgeIterator = employeesProcessor.getEmployeesMoreTwentyFiveAge(employeeCollection.getEmployeesList(), ExecutionType.ITERATOR);
        System.out.println("The List where age of Employees more than 25 by Iterator:  size " + employeesMoreTwentyFiveAgeIterator.size());
        employeesMoreTwentyFiveAgeIterator.forEach(System.out::println);
        System.out.println();

        List<Employee> employeesMoreTwentyFiveAgeStreamAPI = employeesProcessor.getEmployeesMoreTwentyFiveAge(employeeCollection.getEmployeesList(), ExecutionType.STREAM);
        System.out.println("The List where age of Employees more than 25 by Stream API:  size " + employeesMoreTwentyFiveAgeStreamAPI.size());
        employeesMoreTwentyFiveAgeStreamAPI.forEach(System.out::println);
        System.out.println();
        System.out.println("*************************************************************************************************************************" + "\n");

        /**
         * TASK #4
         * Знайти будь-якого працівника, якій живе у Львові
         */
        Employee findEmployeesAddressWithForeach = employeesProcessor.getEmployeeByAddress(employeeCollection.getEmployeesList(),
                ExecutionType.FOREACH, "Kyiv");
        System.out.println("Employee who lives in Kyiv:  size: " + findEmployeesAddressWithForeach + "\n");

        Employee findEmployeesAddressWithIterator = employeesProcessor.getEmployeeByAddress(employeeCollection.getEmployeesList(),
                ExecutionType.ITERATOR,"New York");
        System.out.println("Employee who lives in New York:  size: " + findEmployeesAddressWithIterator + "\n");

        Employee findEmployeesAddressWithStream= employeesProcessor.getEmployeeByAddress(employeeCollection.getEmployeesList(),
                ExecutionType.STREAM,"Lviv");
        System.out.println("Employee who lives in Lviv:  size: " + findEmployeesAddressWithStream + "\n");
        System.out.println("*************************************************************************************************************************" + "\n");

        /**
         * TASK #5
         * Знайти чи є серед працівників хтось, хто живе у Києві
         */
        boolean addressOfEmployeesWithForeach = employeesProcessor.isEmployeeLivesByAddress(employeeCollection.getEmployeesList(),
                ExecutionType.FOREACH, "Kyiv");
        System.out.println("Is here employee who lives in Kyiv? - Foreach: " + addressOfEmployeesWithForeach + "\n");

        boolean addressOfEmployeesWithIterator = employeesProcessor.isEmployeeLivesByAddress(employeeCollection.getEmployeesList(),
                ExecutionType.ITERATOR, "Kyiv");
        System.out.println("Is here employee who lives in Kyiv? - Iterator: " + addressOfEmployeesWithIterator + "\n");

       boolean addressOfEmployeesWithStreamAPI = employeesProcessor.isEmployeeLivesByAddress(employeeCollection.getEmployeesList(),
                ExecutionType.STREAM, "Kyiv");
        System.out.println("Is here employee who lives in Kyiv? Stream API: " + addressOfEmployeesWithStreamAPI + "\n");
        System.out.println("*************************************************************************************************************************" + "\n");

        /**
         * TASK #6
         * Знайти всіх працівників віком більше = 70 років і повернути нову колекцію з прізвищами цих працівників, добавивши до кожного "Stariy Perdun"
         */
        try {
            List<String> employeesWithAgeMoreThanSeventyForeach = employeesProcessor.getEmployeesWithAgeMoreThanSeventy(employeeCollection.getEmployeesList(), ExecutionType.FOREACH,
                    " Staryy Perdun",100);
            System.out.println("The List of Employees Last names where age more than 70 with concatenation by Foreach:  size " + employeesWithAgeMoreThanSeventyForeach.size());
            employeesWithAgeMoreThanSeventyForeach.forEach(System.out::println);
            System.out.println();
        } catch (EmployeeCollectionIsEmptyException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        try {
            List<String> employeesWithAgeMoreThanSeventyIterator = employeesProcessor.getEmployeesWithAgeMoreThanSeventy(employeeCollection.getEmployeesList(), ExecutionType.ITERATOR,
                    " Staryy Perdun", 100);
            System.out.println("The List of Employees Last names where age more than 70 with concatenation by Iterator:  size " + employeesWithAgeMoreThanSeventyIterator.size());
            employeesWithAgeMoreThanSeventyIterator.forEach(System.out::println);
            System.out.println();
        } catch (EmployeeCollectionIsEmptyException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        try {
            List<String> employeesWithAgeMoreThanSeventyStreamAPI = employeesProcessor.getEmployeesWithAgeMoreThanSeventy(employeeCollection.getEmployeesList(), ExecutionType.STREAM,
                    " Staryy Perdun", 100);
            System.out.println("The List of Employees Last names where age more than 70 with concatenation by Stream API:  size " + employeesWithAgeMoreThanSeventyStreamAPI.size());
            employeesWithAgeMoreThanSeventyStreamAPI.forEach(System.out::println);
            System.out.println();
        } catch (EmployeeCollectionIsEmptyException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("*************************************************************************************************************************" + "\n");

        /**
         * TASK #7
         * Знайти всіх працівників, хто живе у києві та повернути колекцію унікальних їх імен
         */
        Set<String> employeesByAddressWithForeach = employeesProcessor.getDistinctEmployeesNameByAddress(employeeCollection.getEmployeesList(),
                ExecutionType.FOREACH, "Kyiv");
        System.out.println("Set with unique fistName who lives in Kyiv by foreach:  size: " + employeesByAddressWithForeach.size() + "\n" + employeesByAddressWithForeach + "\n");

        Set<String> employeesByAddressWithIterator = employeesProcessor.getDistinctEmployeesNameByAddress(employeeCollection.getEmployeesList(),
                ExecutionType.ITERATOR,"Kyiv");
        System.out.println("Set with unique fistName who lives in Kyiv by Iterator:  size: " + employeesByAddressWithIterator.size() + "\n" + employeesByAddressWithIterator + "\n");

        Set<String> employeesByAddressWithStream = employeesProcessor.getDistinctEmployeesNameByAddress(employeeCollection.getEmployeesList(),
                ExecutionType.STREAM, "Kyiv");
        System.out.println("Set with unique fistName who lives in Kyiv by Stream API:  size: " + employeesByAddressWithStream.size() + "\n" + employeesByAddressWithStream + "\n");
        System.out.println("*************************************************************************************************************************" + "\n");

        /**
         * TASK #8
         * Вивести дані просто кожного працівника в консоль і витягнути колекцію адрес
         */
        Set<String> addressesOfEmployeesWithForeach = employeesProcessor.getToStringAndAddressOfEmployees(employeeCollection.getEmployeesList(),
                ExecutionType.FOREACH);
        System.out.println("\n" + "The Set with unique addresses by foreach:  size: " + addressesOfEmployeesWithForeach.size() + "\n" + addressesOfEmployeesWithForeach + "\n");

        Set<String> addressesOfEmployeesWithIterator = employeesProcessor.getToStringAndAddressOfEmployees(employeeCollection.getEmployeesList(),
                ExecutionType.ITERATOR);
        System.out.println("\n" + "The Set with unique addresses by Iterator:  size: " + addressesOfEmployeesWithIterator.size() + "\n" + addressesOfEmployeesWithIterator + "\n");

        Set<String> addressesOfEmployeesWithStream = employeesProcessor.getToStringAndAddressOfEmployees(employeeCollection.getEmployeesList(),
                ExecutionType.STREAM);
        System.out.println("\n" + "The Set with unique addresses by Stream API:  size: " + addressesOfEmployeesWithStream.size() + "\n" + addressesOfEmployeesWithStream + "\n");
        System.out.println("*************************************************************************************************************************" + "\n");

        /**
         * TASK #9
         * Витягнути колекцію імен працівників так, щоб нова колекція включала в себе 5 імен
         */
        List<String> fiveEmployeesNameWithForeach = employeesProcessor.getFiveEmployeesName(employeeCollection.getEmployeesList(), ExecutionType.FOREACH);
        System.out.println("List of names by foreach:  size: " + fiveEmployeesNameWithForeach.size() + "\n" + fiveEmployeesNameWithForeach + "\n");

        List<String> fiveEmployeesNameWithIterator = employeesProcessor.getFiveEmployeesName(employeeCollection.getEmployeesList(), ExecutionType.ITERATOR);
        System.out.println("List of names by Iterator:  size: " + fiveEmployeesNameWithIterator.size() + "\n" + fiveEmployeesNameWithIterator + "\n");

        List<String> fiveEmployeesNameWithStream = employeesProcessor.getFiveEmployeesName(employeeCollection.getEmployeesList(), ExecutionType.STREAM);
        System.out.println("List of name by Stream API:  size: " + fiveEmployeesNameWithStream.size() + "\n" + fiveEmployeesNameWithStream + "\n");
        System.out.println("*************************************************************************************************************************" + "\n");

        /**
         * TASK #10
         * Порахувати суму віку всіх працівників
         */
        Integer sumOfAgeWithForeach = employeesProcessor.getSumOfAge(employeeCollection.getEmployeesList(),
                ExecutionType.FOREACH);
        System.out.println("The sum of employees age by Foreach is: " + sumOfAgeWithForeach + "\n");

        Integer sumOfAgeWithIterator = employeesProcessor.getSumOfAge(employeeCollection.getEmployeesList(),
                ExecutionType.ITERATOR);
        System.out.println("The sum of employees age by Iterator is: " + sumOfAgeWithIterator + "\n");

        Integer sumOfAgeWithStreamAPI = employeesProcessor.getSumOfAge(employeeCollection.getEmployeesList(),
                ExecutionType.STREAM);
        System.out.println("The sum of employees age by Stream API is: " + sumOfAgeWithStreamAPI + "\n");
        System.out.println("*************************************************************************************************************************" + "\n");

        /**
         * TASK #11
         * Перевірити, чи всі працівники старше 18ти
         */
        try {
            boolean allEmployeesOldestEighteenWithForeach = employeesProcessor.isAllEmployeesOlderEighteen(employeeCollection.getEmployeesList(),
                    ExecutionType.FOREACH);
            System.out.println("Are all employees oldest 18? - Foreach: " + allEmployeesOldestEighteenWithForeach + "\n");
        } catch (AgeOfEmployeeLessZeroException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        try {
            boolean  allEmployeesOldestEighteenWithIterator = employeesProcessor.isAllEmployeesOlderEighteen(employeeCollection.getEmployeesList(),
                    ExecutionType.ITERATOR);
            System.out.println("Are all employees oldest 18? - Iterator: " + allEmployeesOldestEighteenWithIterator + "\n");
        } catch (AgeOfEmployeeLessZeroException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        try {
            boolean allEmployeesOldestEighteenWithStreamAPI = employeesProcessor.isAllEmployeesOlderEighteen(employeeCollection.getEmployeesList(),
                    ExecutionType.STREAM);
            System.out.println("Are all employees oldest 18? - Stream API: " + allEmployeesOldestEighteenWithStreamAPI + "\n");
        } catch (AgeOfEmployeeLessZeroException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }




}
