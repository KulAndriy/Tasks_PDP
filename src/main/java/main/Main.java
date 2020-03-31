package main;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EmployeeCollection employeeCollection = new EmployeeCollection();
        SortEmployee sortEmployee = new SortEmployee();
        EmployeesProcessor employeesProcessor = new EmployeesProcessor();

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
        Set<Employee> sortingUsingCollectionsWithComparator = sortEmployee.sortUsingComparatorAndCollections(employeeSet);
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
        Set<Employee> sortingUsingStreamWithComparator = sortEmployee.sortUsingComparatorAndStream(employeeSet);
        System.out.println("Sorting HashSet using Stream API and Comparator: " + " size " + sortingUsingStreamWithComparator.size());
        sortingUsingStreamWithComparator.forEach(System.out::println);
        System.out.println();

        /**
         * TASK #1
         * Витягнути ліст імен, Видалити всіх Олегів з ліста (відповідно, щоб у лісті було їх хоча б кілька)
         */

        List<String> removeNameWithForeach = employeesProcessor.removeEmployee(employeeCollection.getEmployeesList(),ExecutionType.FOREACH);
        System.out.println("List of names without name Oleg by foreach:  size: " + removeNameWithForeach.size() + "\n" + removeNameWithForeach + "\n");

        List<String> removeNameWithIterator = employeesProcessor.removeEmployee(employeeCollection.getEmployeesList(),ExecutionType.ITERATOR);
        System.out.println("List of names without name Oleg by Iterator:  size: " + removeNameWithIterator.size() + "\n" + removeNameWithIterator + "\n");

        List<String> removeNameWithStream = employeesProcessor.removeEmployee(employeeCollection.getEmployeesList(),ExecutionType.STREAM);
        System.out.println("List of names without name Oleg by Stream API:  size: " + removeNameWithStream.size() + "\n" + removeNameWithStream + "\n");

        /**
         * TASK #2
         * Витягнути ліст імен,Змінити всіх Андріїв на Василів (2-3 Андрія щоб була у лісті)
         */

        List<String> changeNameWithForeach = employeesProcessor.getChangedNameOfEmployee(employeeCollection.getEmployeesList(),
                ExecutionType.FOREACH, "Andriy", "Vasyla");
        System.out.println("List of names wit replacement name Andriy to Vasyl by foreach:  size: " + changeNameWithForeach.size() + "\n" + changeNameWithForeach + "\n");

        List<String> changeNameWithIterator = employeesProcessor.getChangedNameOfEmployee(employeeCollection.getEmployeesList(),
                ExecutionType.ITERATOR,"Andriy","Vasylaa");
        System.out.println("List of names wit replacement name Andriy to Vasyl by Iterator:  size: " + changeNameWithIterator.size() + "\n" + changeNameWithIterator + "\n");

        List<String> changeNameWithStream = employeesProcessor.getChangedNameOfEmployee(employeeCollection.getEmployeesList(),
                ExecutionType.STREAM, "Andriy", "Vasylaaa");
        System.out.println("List of names wit replacement name Andriy to Vasyl by Stream API:  size: " + changeNameWithStream.size() + "\n" + changeNameWithStream + "\n");

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

        /**
         * TASK #4
         * Знайти будь-якого працівника, якій живе у Львові
         */
        List<Employee> findEmployeesAddressWithForeach = employeesProcessor.getEmployeesAddress(employeeCollection.getEmployeesList(),
                ExecutionType.FOREACH, "Kyiv");
        System.out.println("Employee who lives in Kyiv:  size: " + findEmployeesAddressWithForeach.size() + "\n" + findEmployeesAddressWithForeach + "\n");

        List<Employee> findEmployeesAddressWithIterator = employeesProcessor.getEmployeesAddress(employeeCollection.getEmployeesList(),
                ExecutionType.ITERATOR,"New York");
        System.out.println("Employee who lives in New York:  size: " + findEmployeesAddressWithIterator.size() + "\n" + findEmployeesAddressWithIterator + "\n");

        employeesProcessor.getEmployeesAddress(employeeCollection.getEmployeesList(), ExecutionType.STREAM, "Lviv");    //?????????????????????????????????????????/

        /**
         * TASK #5
         * Знайти чи є серед працівників хтось, хто живе у Києві
         */
        boolean addressOfEmployeesWithForeach = employeesProcessor.getAddressOfEmployee(employeeCollection.getEmployeesList(),
                ExecutionType.FOREACH, "Kyiv");
        System.out.println("Is here employee who lives in Kyiv? - Foreach: " + addressOfEmployeesWithForeach + "\n");

        boolean addressOfEmployeesWithIterator = employeesProcessor.getAddressOfEmployee(employeeCollection.getEmployeesList(),
                ExecutionType.ITERATOR, "Kyiv");
        System.out.println("Is here employee who lives in Kyiv? - Iterator: " + addressOfEmployeesWithIterator + "\n");

       boolean addressOfEmployeesWithStreamAPI = employeesProcessor.getAddressOfEmployee(employeeCollection.getEmployeesList(),
                ExecutionType.STREAM, "Kyiv");
        System.out.println("Is here employee who lives in Kyiv? Stream API: " + addressOfEmployeesWithStreamAPI + "\n");

        /**
         * TASK #6
         * Знайти всіх працівників віком більше = 70 років і повернути нову колекцію з прізвищами цих працівників, добавивши до кожного "Stariy Perdun"
         */
        List<Employee> employeesWithAgeMoreThanSeventyForeach = employeesProcessor.getEmployeesWithAgeMoreThanSeventy(employeeCollection.getEmployeesList(), ExecutionType.FOREACH);
        System.out.println("The List of employees where age more than 70 with concatenation by Foreach:  size " + employeesWithAgeMoreThanSeventyForeach.size());
        employeesWithAgeMoreThanSeventyForeach.forEach(System.out::println);
        System.out.println();

        List<Employee> employeesWithAgeMoreThanSeventyIterator = employeesProcessor.getEmployeesWithAgeMoreThanSeventy(employeeCollection.getEmployeesList(), ExecutionType.ITERATOR);
        System.out.println("The List of employees where age more than 70 with concatenation by Iterator:  size " + employeesWithAgeMoreThanSeventyIterator.size());
        employeesWithAgeMoreThanSeventyIterator.forEach(System.out::println);
        System.out.println();

        List<Employee> employeesWithAgeMoreThanSeventyStreamAPI = employeesProcessor.getEmployeesWithAgeMoreThanSeventy(employeeCollection.getEmployeesList(), ExecutionType.STREAM);
        System.out.println("The List of employees where age more than 70 with concatenation by Stream API:  size " + employeesWithAgeMoreThanSeventyStreamAPI.size());
        employeesWithAgeMoreThanSeventyStreamAPI.forEach(System.out::println);
        System.out.println();

        /**
         * TASK #7
         * Знайти всіх працівників, хто живе у києві та повернути колекцію унікальних їх імен
         */
        Set<String> employeesByAddressWithForeach = employeesProcessor.getEmployeesByAddress(employeeCollection.getEmployeesList(),
                ExecutionType.FOREACH, "Kyiv");
        System.out.println("Set with unique fistName who lives in Kyiv by foreach:  size: " + employeesByAddressWithForeach.size() + "\n" + employeesByAddressWithForeach + "\n");

        Set<String> employeesByAddressWithIterator = employeesProcessor.getEmployeesByAddress(employeeCollection.getEmployeesList(),
                ExecutionType.ITERATOR,"Kyiv");
        System.out.println("Set with unique fistName who lives in Kyiv by Iterator:  size: " + employeesByAddressWithIterator.size() + "\n" + employeesByAddressWithIterator + "\n");

        Set<String> employeesByAddressWithStream = employeesProcessor.getEmployeesByAddress(employeeCollection.getEmployeesList(),
                ExecutionType.STREAM, "Kyiv");
        System.out.println("Set with unique fistName who lives in Kyiv by Stream API:  size: " + employeesByAddressWithStream.size() + "\n" + employeesByAddressWithStream + "\n");

        /**
         * TASK #8
         * Вивести дані просто кожного працівника в консоль і витягнути колекцію адрес
         */
        Set<String> addressesOfEmployeesWithForeach = employeesProcessor.getAddressOfEmployees(employeeCollection.getEmployeesList(),
                ExecutionType.FOREACH);
        System.out.println("The Set with unique addresses by foreach:  size: " + addressesOfEmployeesWithForeach.size() + "\n" + addressesOfEmployeesWithForeach + "\n");
        for (Employee e:employeeCollection.getEmployeesList()){
            System.out.println(e.getFirstName() + " " +e.getLastName() + " - Id " + e.getId() + ", live in " + e.getAddress()
                    + " and his/her age " + e.getAge());
        }
        System.out.println();

        Set<String> addressesOfEmployeesWithIterator = employeesProcessor.getAddressOfEmployees(employeeCollection.getEmployeesList(),
                ExecutionType.ITERATOR);
        System.out.println("The Set with unique addresses by Iterator:  size: " + addressesOfEmployeesWithIterator.size() + "\n" + addressesOfEmployeesWithIterator + "\n");
        for (Employee e:employeeCollection.getEmployeesList()){
            System.out.println(e.getFirstName() + " " +e.getLastName() + " - Id " + e.getId() + ", live in " + e.getAddress()
                    + " and his/her age " + e.getAge());
        }
        System.out.println();

        Set<String> addressesOfEmployeesWithStream = employeesProcessor.getAddressOfEmployees(employeeCollection.getEmployeesList(),
                ExecutionType.STREAM);
        System.out.println("The Set with unique addresses by Stream API:  size: " + addressesOfEmployeesWithStream.size() + "\n" + addressesOfEmployeesWithStream + "\n");
        for (Employee e:employeeCollection.getEmployeesList()){
            System.out.println(e.getFirstName() + " " +e.getLastName() + " - Id " + e.getId() + ", live in " + e.getAddress()
                    + " and his/her age " + e.getAge());
        }
        System.out.println();

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

        /**
         * TASK #11
         * Перевірити, чи всі працівники старше 18ти
         */
        boolean allEmployeesOldestEighteenWithForeach = employeesProcessor.checkIfAllEmployeesOldestEighteen(employeeCollection.getEmployeesList(),
                ExecutionType.FOREACH);
        System.out.println("Are all employees oldest 18? - Foreach: " + allEmployeesOldestEighteenWithForeach + "\n");

        boolean allEmployeesOldestEighteenWithIterator = employeesProcessor.checkIfAllEmployeesOldestEighteen(employeeCollection.getEmployeesList(),
                ExecutionType.ITERATOR);
        System.out.println("Are all employees oldest 18? - Iterator: " + allEmployeesOldestEighteenWithIterator + "\n");

        boolean allEmployeesOldestEighteenWithStreamAPI = employeesProcessor.checkIfAllEmployeesOldestEighteen(employeeCollection.getEmployeesList(),
                ExecutionType.STREAM);
        System.out.println("Are all employees oldest 18? - Stream API: " + allEmployeesOldestEighteenWithStreamAPI + "\n");
    }




}
