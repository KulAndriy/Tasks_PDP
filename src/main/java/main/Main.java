package main;

import comparator.ComparatorProcessor;
import comparator.ComparatorType;
import exception.AgeOfEmployeeLessZeroException;
import exception.EmployeeCollectionIsEmptyException;
import exception.NoSuchEmployeeException;
import org.apache.log4j.Logger;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EmployeeCollection employeeCollection = new EmployeeCollection();
        SortEmployee sortEmployee = new SortEmployee();
        EmployeesProcessor employeesProcessor = new EmployeesProcessor();
        ComparatorProcessor comparatorProcessor = new ComparatorProcessor();
        final Logger infoLogger = Logger.getLogger("infoAppender");
        final Logger errorLogger = Logger.getLogger("errorAppender");

        String sectionSeparator = "*************************************************************************************************************************" + "\n";

        /**
         * Create a HashSet collection
         */
        Set<Employee> employeeSet = employeeCollection.getEmployeesSet();
        infoLogger.info("Original created HashSet: " + " size " + employeeSet.size());
        employeeSet.forEach(infoLogger::info);
        infoLogger.info("\n");

        /**
         * Sorting HashSet using Collections class
         */
        Set<Employee> sortingUsingCollectionsClass = sortEmployee.sortUsingCollections(employeeSet);
        infoLogger.info("Sorting HashSet using Collections class: " + " size " + sortingUsingCollectionsClass.size());
        sortingUsingCollectionsClass.forEach(infoLogger::info);
        infoLogger.info("\n");

        /**
         * Sorting HashSet using Collections class with Comparator
         */
        Set<Employee> sortingUsingCollectionsWithComparator = sortEmployee.sortUsingComparatorAndCollections(employeeSet, comparatorProcessor.getComparator(ComparatorType.LAST_NAME_SORTED));
        infoLogger.info("Sorting HashSet using Collections class with Comparator: " + " size " + sortingUsingCollectionsWithComparator.size());
        sortingUsingCollectionsWithComparator.forEach(infoLogger::info);
        infoLogger.info("\n");

        /**
         * Sorting HashSet using StreamAPI
         */
        Set<Employee> sortingUsingStreamAPI = sortEmployee.sortUsingStream(employeeSet);
        infoLogger.info("Sorting HashSet using Stream API: " + " size " + sortingUsingStreamAPI.size());
        sortingUsingStreamAPI.forEach(infoLogger::info);
        infoLogger.info("\n");

        /**
         * Sorting HashSet using StreamAPI and Comparator
         */
        Set<Employee> sortingUsingStreamWithComparator = sortEmployee.sortUsingComparatorAndStream(employeeSet, comparatorProcessor.getComparator(ComparatorType.LAST_NAME_SORTED));
        infoLogger.info("Sorting HashSet using Stream API and Comparator: " + " size " + sortingUsingStreamWithComparator.size());
        sortingUsingStreamWithComparator.forEach(infoLogger::info);
        infoLogger.info("\n");

        /**
         * Конвертувати HashSet в TreeSet
         * */
        Set<Employee> convertingHashSetToTreeSet = sortEmployee.convertHashSetToTreeSet(employeeSet, comparatorProcessor.getComparator(ComparatorType.ID_SORTED));
        infoLogger.info("Converting HashSet to TreeSet: " + " size " + convertingHashSetToTreeSet.size());
        convertingHashSetToTreeSet.forEach(infoLogger::info);
        infoLogger.info("\n");

        /**
         * TASK #1
         * Витягнути ліст імен, Видалити всіх Олегів з ліста (відповідно, щоб у лісті було їх хоча б кілька)
         */
        try {
            List<String> removeNameWithIterator = employeesProcessor.removeEmployee(employeeCollection.getEmployeesList(), ExecutionType.ITERATOR, "Oleg");
            infoLogger.info("List of names without name Oleg by Iterator:  size: " + removeNameWithIterator.size() + "\n" + removeNameWithIterator + "\n");
        } catch (NoSuchEmployeeException e) {
            errorLogger.error(e.getMessage(),e);
        }

        try {
            List<String> removeNameWithStream = employeesProcessor.removeEmployee(employeeCollection.getEmployeesList(), ExecutionType.STREAM, "Ole");
            infoLogger.info("List of names without name Oleg by Stream API:  size: " + removeNameWithStream.size() + "\n" + removeNameWithStream + "\n");
        } catch (NoSuchEmployeeException e) {
            errorLogger.error(e.getMessage(), e);
        }
        infoLogger.info(sectionSeparator);
        errorLogger.error(sectionSeparator);

        /**
         * TASK #2
         * Витягнути ліст імен,Змінити всіх Андріїв на Василів (2-3 Андрія щоб була у лісті)
         */

        List<String> changeNameWithForeach = employeesProcessor.getChangedNameOfEmployee(employeeCollection.getEmployeesList(),
                ExecutionType.FOREACH, "Andriy", "Vasyli");
        infoLogger.info("List of names wit replacement name Andriy to Vasyl by foreach:  size: " + changeNameWithForeach.size() + "\n" + changeNameWithForeach + "\n");

        List<String> changeNameWithIterator = employeesProcessor.getChangedNameOfEmployee(employeeCollection.getEmployeesList(),
                ExecutionType.ITERATOR,"Andriy","Vasylaa");
        infoLogger.info("List of names wit replacement name Andriy to Vasyl by Iterator:  size: " + changeNameWithIterator.size() + "\n" + changeNameWithIterator + "\n");

        List<String> changeNameWithStream = employeesProcessor.getChangedNameOfEmployee(employeeCollection.getEmployeesList(),
                ExecutionType.STREAM, "Andriy", "Vasylaaa");
        infoLogger.info("List of names wit replacement name Andriy to Vasyl by Stream API:  size: " + changeNameWithStream.size() + "\n" + changeNameWithStream + "\n");
        infoLogger.info(sectionSeparator);

        /**
         * TASK #3
         * Витягнути колекцію працівників віком > 25 років
         */
        List<Employee> employeesMoreTwentyFiveAgeForeach = employeesProcessor.getEmployeesMoreTwentyFiveAge(employeeCollection.getEmployeesList(), ExecutionType.FOREACH);
        infoLogger.info("The List where age of Employees more than 25 by Foreach:  size " + employeesMoreTwentyFiveAgeForeach.size());
        employeesMoreTwentyFiveAgeForeach.forEach(infoLogger::info);
        infoLogger.info("\n");

        List<Employee> employeesMoreTwentyFiveAgeIterator = employeesProcessor.getEmployeesMoreTwentyFiveAge(employeeCollection.getEmployeesList(), ExecutionType.ITERATOR);
        infoLogger.info("The List where age of Employees more than 25 by Iterator:  size " + employeesMoreTwentyFiveAgeIterator.size());
        employeesMoreTwentyFiveAgeIterator.forEach(infoLogger::info);
        infoLogger.info("\n");

        List<Employee> employeesMoreTwentyFiveAgeStreamAPI = employeesProcessor.getEmployeesMoreTwentyFiveAge(employeeCollection.getEmployeesList(), ExecutionType.STREAM);
        infoLogger.info("The List where age of Employees more than 25 by Stream API:  size " + employeesMoreTwentyFiveAgeStreamAPI.size());
        employeesMoreTwentyFiveAgeStreamAPI.forEach(infoLogger::info);
        infoLogger.info("\n");
        infoLogger.info(sectionSeparator);

        /**
         * TASK #4
         * Знайти будь-якого працівника, якій живе у Львові
         */
        Employee findEmployeesAddressWithForeach = employeesProcessor.getEmployeeByAddress(employeeCollection.getEmployeesList(),
                ExecutionType.FOREACH, "Kyiv");
        infoLogger.info("Employee who lives in Kyiv:  size: " + findEmployeesAddressWithForeach + "\n");

        Employee findEmployeesAddressWithIterator = employeesProcessor.getEmployeeByAddress(employeeCollection.getEmployeesList(),
                ExecutionType.ITERATOR,"New York");
        infoLogger.info("Employee who lives in New York:  size: " + findEmployeesAddressWithIterator + "\n");

        Employee findEmployeesAddressWithStream= employeesProcessor.getEmployeeByAddress(employeeCollection.getEmployeesList(),
                ExecutionType.STREAM,"Lviv");
        infoLogger.info("Employee who lives in Lviv:  size: " + findEmployeesAddressWithStream + "\n");
        infoLogger.info(sectionSeparator);

        /**
         * TASK #5
         * Знайти чи є серед працівників хтось, хто живе у Києві
         */
        boolean addressOfEmployeesWithForeach = employeesProcessor.isEmployeeLivesByAddress(employeeCollection.getEmployeesList(),
                ExecutionType.FOREACH, "Kyiv");
        infoLogger.info("Is here employee who lives in Kyiv? - Foreach: " + addressOfEmployeesWithForeach + "\n");

        boolean addressOfEmployeesWithIterator = employeesProcessor.isEmployeeLivesByAddress(employeeCollection.getEmployeesList(),
                ExecutionType.ITERATOR, "Kyiv");
        infoLogger.info("Is here employee who lives in Kyiv? - Iterator: " + addressOfEmployeesWithIterator + "\n");

       boolean addressOfEmployeesWithStreamAPI = employeesProcessor.isEmployeeLivesByAddress(employeeCollection.getEmployeesList(),
                ExecutionType.STREAM, "Kyiv");
        infoLogger.info("Is here employee who lives in Kyiv? Stream API: " + addressOfEmployeesWithStreamAPI + "\n");
        infoLogger.info(sectionSeparator);

        /**
         * TASK #6
         * Знайти всіх працівників віком більше = 70 років і повернути нову колекцію з прізвищами цих працівників, добавивши до кожного "Stariy Perdun"
         */
        try {
            List<String> employeesWithAgeMoreThanSeventyForeach = employeesProcessor.getEmployeesWithAgeMoreThanSeventy(employeeCollection.getEmployeesList(), ExecutionType.FOREACH,
                    " Staryy Perdun",100);
            infoLogger.info("The List of Employees Last names where age more than 70 with concatenation by Foreach:  size " + employeesWithAgeMoreThanSeventyForeach.size());
            employeesWithAgeMoreThanSeventyForeach.forEach(infoLogger::info);
            infoLogger.info("\n");
        } catch (EmployeeCollectionIsEmptyException e) {
            errorLogger.error(e.getMessage(),e);
        }

        try {
            List<String> employeesWithAgeMoreThanSeventyIterator = employeesProcessor.getEmployeesWithAgeMoreThanSeventy(employeeCollection.getEmployeesList(), ExecutionType.ITERATOR,
                    " Staryy Perdun", 100);
            infoLogger.info("The List of Employees Last names where age more than 70 with concatenation by Iterator:  size " + employeesWithAgeMoreThanSeventyIterator.size());
            employeesWithAgeMoreThanSeventyIterator.forEach(infoLogger::info);
            infoLogger.info("\n");
        } catch (EmployeeCollectionIsEmptyException e) {
            errorLogger.error(e.getMessage(),e);
        }

        try {
            List<String> employeesWithAgeMoreThanSeventyStreamAPI = employeesProcessor.getEmployeesWithAgeMoreThanSeventy(employeeCollection.getEmployeesList(), ExecutionType.STREAM,
                    " Staryy Perdun", 100);
            infoLogger.info("The List of Employees Last names where age more than 70 with concatenation by Stream API:  size " + employeesWithAgeMoreThanSeventyStreamAPI.size());
            employeesWithAgeMoreThanSeventyStreamAPI.forEach(infoLogger::info);
            infoLogger.info("\n");
        } catch (EmployeeCollectionIsEmptyException e) {
            errorLogger.error(e.getMessage(),e);
        }
        infoLogger.info(sectionSeparator);
        errorLogger.error(sectionSeparator);

        /**
         * TASK #7
         * Знайти всіх працівників, хто живе у києві та повернути колекцію унікальних їх імен
         */
        Set<String> employeesByAddressWithForeach = employeesProcessor.getDistinctEmployeesNameByAddress(employeeCollection.getEmployeesList(),
                ExecutionType.FOREACH, "Kyiv");
        infoLogger.info("Set with unique fistName who lives in Kyiv by foreach:  size: " + employeesByAddressWithForeach.size() + "\n" + employeesByAddressWithForeach + "\n");

        Set<String> employeesByAddressWithIterator = employeesProcessor.getDistinctEmployeesNameByAddress(employeeCollection.getEmployeesList(),
                ExecutionType.ITERATOR,"Kyiv");
        infoLogger.info("Set with unique fistName who lives in Kyiv by Iterator:  size: " + employeesByAddressWithIterator.size() + "\n" + employeesByAddressWithIterator + "\n");

        Set<String> employeesByAddressWithStream = employeesProcessor.getDistinctEmployeesNameByAddress(employeeCollection.getEmployeesList(),
                ExecutionType.STREAM, "Kyiv");
        infoLogger.info("Set with unique fistName who lives in Kyiv by Stream API:  size: " + employeesByAddressWithStream.size() + "\n" + employeesByAddressWithStream + "\n");
        infoLogger.info(sectionSeparator);

        /**
         * TASK #8
         * Вивести дані просто кожного працівника в консоль і витягнути колекцію адрес
         */
        Set<String> addressesOfEmployeesWithForeach = employeesProcessor.getToStringAndAddressOfEmployees(employeeCollection.getEmployeesList(),
                ExecutionType.FOREACH);
        infoLogger.info("\n" + "The Set with unique addresses by foreach:  size: " + addressesOfEmployeesWithForeach.size() + "\n" + addressesOfEmployeesWithForeach + "\n");

        Set<String> addressesOfEmployeesWithIterator = employeesProcessor.getToStringAndAddressOfEmployees(employeeCollection.getEmployeesList(),
                ExecutionType.ITERATOR);
        infoLogger.info("\n" + "The Set with unique addresses by Iterator:  size: " + addressesOfEmployeesWithIterator.size() + "\n" + addressesOfEmployeesWithIterator + "\n");

        Set<String> addressesOfEmployeesWithStream = employeesProcessor.getToStringAndAddressOfEmployees(employeeCollection.getEmployeesList(),
                ExecutionType.STREAM);
        infoLogger.info("\n" + "The Set with unique addresses by Stream API:  size: " + addressesOfEmployeesWithStream.size() + "\n" + addressesOfEmployeesWithStream + "\n");
        infoLogger.info(sectionSeparator);

        /**
         * TASK #9
         * Витягнути колекцію імен працівників так, щоб нова колекція включала в себе 5 імен
         */
        List<String> fiveEmployeesNameWithForeach = employeesProcessor.getFiveEmployeesName(employeeCollection.getEmployeesList(), ExecutionType.FOREACH);
        infoLogger.info("List of names by foreach:  size: " + fiveEmployeesNameWithForeach.size() + "\n" + fiveEmployeesNameWithForeach + "\n");

        List<String> fiveEmployeesNameWithIterator = employeesProcessor.getFiveEmployeesName(employeeCollection.getEmployeesList(), ExecutionType.ITERATOR);
        infoLogger.info("List of names by Iterator:  size: " + fiveEmployeesNameWithIterator.size() + "\n" + fiveEmployeesNameWithIterator + "\n");

        List<String> fiveEmployeesNameWithStream = employeesProcessor.getFiveEmployeesName(employeeCollection.getEmployeesList(), ExecutionType.STREAM);
        infoLogger.info("List of name by Stream API:  size: " + fiveEmployeesNameWithStream.size() + "\n" + fiveEmployeesNameWithStream + "\n");
        infoLogger.info(sectionSeparator);

        /**
         * TASK #10
         * Порахувати суму віку всіх працівників
         */
        Integer sumOfAgeWithForeach = employeesProcessor.getSumOfAge(employeeCollection.getEmployeesList(),
                ExecutionType.FOREACH);
        infoLogger.info("The sum of employees age by Foreach is: " + sumOfAgeWithForeach + "\n");

        Integer sumOfAgeWithIterator = employeesProcessor.getSumOfAge(employeeCollection.getEmployeesList(),
                ExecutionType.ITERATOR);
        infoLogger.info("The sum of employees age by Iterator is: " + sumOfAgeWithIterator + "\n");

        Integer sumOfAgeWithStreamAPI = employeesProcessor.getSumOfAge(employeeCollection.getEmployeesList(),
                ExecutionType.STREAM);
        System.out.println("The sum of employees age by Stream API is: " + sumOfAgeWithStreamAPI + "\n");
        infoLogger.info(sectionSeparator);

        /**
         * TASK #11
         * Перевірити, чи всі працівники старше 18ти
         */
        try {
            boolean allEmployeesOldestEighteenWithForeach = employeesProcessor.isAllEmployeesOlderEighteen(employeeCollection.getEmployeesList(),
                    ExecutionType.FOREACH);
            infoLogger.info("Are all employees oldest 18? - Foreach: " + allEmployeesOldestEighteenWithForeach + "\n");
        } catch (AgeOfEmployeeLessZeroException e) {
            errorLogger.error(e.getMessage(),e);
        }

        try {
            boolean  allEmployeesOldestEighteenWithIterator = employeesProcessor.isAllEmployeesOlderEighteen(employeeCollection.getEmployeesList(),
                    ExecutionType.ITERATOR);
            infoLogger.info("Are all employees oldest 18? - Iterator: " + allEmployeesOldestEighteenWithIterator + "\n");
        } catch (AgeOfEmployeeLessZeroException e) {
            errorLogger.error(e.getMessage(),e);
        }

        try {
            boolean allEmployeesOldestEighteenWithStreamAPI = employeesProcessor.isAllEmployeesOlderEighteen(employeeCollection.getEmployeesList(),
                    ExecutionType.STREAM);
            infoLogger.info("Are all employees oldest 18? - Stream API: " + allEmployeesOldestEighteenWithStreamAPI + "\n");
        } catch (AgeOfEmployeeLessZeroException e) {
            errorLogger.error(e.getMessage(),e);
        }

    }




}
