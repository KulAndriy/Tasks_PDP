package exception;

import main.Employee;
import main.ExecutionType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class TestExc {
    /**
     * TASK #1
     * Витягнути ліст імен, Видалити всіх Олегів з ліста (відповідно, щоб у лісті було їх хоча б кілька)
     */
    public List<String> removeEmployee(List<Employee> employeeList, ExecutionType executionType, String targetName) throws RemoveEmployeeException {
        List<String> removeEmployeeName = new ArrayList<>();
        switch (executionType) {
            case ITERATOR: {
                for (Employee e : employeeList) {
                    removeEmployeeName.add(e.getFirstName());
                }
                if (!removeEmployeeName.contains(targetName))
                    throw new RemoveEmployeeException("This exception was thrown because the name " + targetName + " is absent in the List.");
                Iterator<String> iterator = removeEmployeeName.iterator();
                while (iterator.hasNext()) {
                    if (iterator.next().equals(targetName)) {
                        iterator.remove();
                    }
                }
                break;
            }
            case STREAM: {
                removeEmployeeName = employeeList.stream()
                        .map(Employee::getFirstName)
                        .collect(Collectors.toList());
                if (!removeEmployeeName.contains(targetName))
                    throw new RemoveEmployeeException("This exception was thrown because the name " + targetName + " is absent in the List.");
                removeEmployeeName.removeIf(s -> s.equals(targetName));
                break;
            }
        }
        return removeEmployeeName;
    }

    /**
     * TASK #6
     * Знайти всіх працівників віком більше = 70 років і повернути нову колекцію з прізвищами цих працівників, добавивши до кожного "Stariy Perdun"
     */
    public List<String> getEmployeesWithAgeMoreThanSeventy(List<Employee> employeeList, ExecutionType executionType, String concatedStringToLastName, int age) throws EmployeeCollectionIsEmptyException {
        List<String> lastNameOfEmployeesWithConcatenation = new ArrayList<>();
        String exceptionMessage = "The collection does not have eny elements with age ";
        switch (executionType){
            case FOREACH:{
                for (Employee e:employeeList){
                    if (e.getAge()>age){
                        lastNameOfEmployeesWithConcatenation.add(e.getLastName().concat(concatedStringToLastName));
                    }
                }
                if (lastNameOfEmployeesWithConcatenation.isEmpty()) throw new EmployeeCollectionIsEmptyException(exceptionMessage + age);
                break;
            }
            case ITERATOR:{
                Iterator<Employee> ageIterator = employeeList.iterator();
                while (ageIterator.hasNext()){
                    Employee employee = ageIterator.next();
                    if (employee.getAge()>age){
                        lastNameOfEmployeesWithConcatenation.add(employee.getLastName().concat(concatedStringToLastName));
                    }
                }
                if (lastNameOfEmployeesWithConcatenation.isEmpty()) throw new EmployeeCollectionIsEmptyException(exceptionMessage + age);
                break;
            }
            case STREAM:{
                lastNameOfEmployeesWithConcatenation = employeeList.stream()
                        .filter(s->s.getAge()>age)
                        .map(s->s.getLastName().concat(concatedStringToLastName))
                        .collect(Collectors.toList());
            }
            if (lastNameOfEmployeesWithConcatenation.isEmpty()) throw new EmployeeCollectionIsEmptyException(exceptionMessage + age);
        }
        return lastNameOfEmployeesWithConcatenation;
    }
}
