package exception;

import main.EmployeeCollection;
import main.ExecutionType;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        TestExc testExc = new TestExc();
        EmployeeCollection employeeCollection= new EmployeeCollection();

        /**
         * TASK #1
         * Витягнути ліст імен, Видалити всіх Олегів з ліста (відповідно, щоб у лісті було їх хоча б кілька)
         */
        try {
            List<String> removeNameWithIterator = testExc.removeEmployee(employeeCollection.getEmployeesList(), ExecutionType.ITERATOR, "Ole");
            System.out.println("List of names without name Oleg by Iterator:  size: " + removeNameWithIterator.size() + "\n" + removeNameWithIterator + "\n");
        } catch (NoSuchEmployeeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


        try {
            List<String> removeNameWithStream = testExc.removeEmployee(employeeCollection.getEmployeesList(), ExecutionType.STREAM, "Ole");
            System.out.println("List of names without name Oleg by Stream API:  size: " + removeNameWithStream.size() + "\n" + removeNameWithStream + "\n");
        } catch (NoSuchEmployeeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        finally {
            System.out.println("*************************************************************************************************************************" + "\n");

        }

        /**
         * TASK #6
         * Знайти всіх працівників віком більше = 70 років і повернути нову колекцію з прізвищами цих працівників, добавивши до кожного "Stariy Perdun"
         */
        try {
            List<String> employeesWithAgeMoreThanSeventyForeach = testExc.getEmployeesWithAgeMoreThanSeventy(employeeCollection.getEmployeesList(), ExecutionType.FOREACH,
                    " Staryy Perdun",100);
            System.out.println("The List of Employees Last names where age more than 70 with concatenation by Foreach:  size " + employeesWithAgeMoreThanSeventyForeach.size());
            employeesWithAgeMoreThanSeventyForeach.forEach(System.out::println);
            System.out.println();
        } catch (EmployeeCollectionIsEmptyException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        try {
            List<String> employeesWithAgeMoreThanSeventyIterator = testExc.getEmployeesWithAgeMoreThanSeventy(employeeCollection.getEmployeesList(), ExecutionType.ITERATOR,
                    " Staryy Perdun", 100);
            System.out.println("The List of Employees Last names where age more than 70 with concatenation by Iterator:  size " + employeesWithAgeMoreThanSeventyIterator.size());
            employeesWithAgeMoreThanSeventyIterator.forEach(System.out::println);
            System.out.println();
        } catch (EmployeeCollectionIsEmptyException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        try {
            List<String> employeesWithAgeMoreThanSeventyStreamAPI = testExc.getEmployeesWithAgeMoreThanSeventy(employeeCollection.getEmployeesList(), ExecutionType.STREAM,
                    " Staryy Perdun", 100);
            System.out.println("The List of Employees Last names where age more than 70 with concatenation by Stream API:  size " + employeesWithAgeMoreThanSeventyStreamAPI.size());
            employeesWithAgeMoreThanSeventyStreamAPI.forEach(System.out::println);
            System.out.println();
        } catch (EmployeeCollectionIsEmptyException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }finally {
            System.out.println("*************************************************************************************************************************" + "\n");
        }
    }
}
