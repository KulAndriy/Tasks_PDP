package main;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeesProcessor {
    /**
     * TASK #1
     * Витягнути ліст імен, Видалити всіх Олегів з ліста (відповідно, щоб у лісті було їх хоча б кілька)
     */
    public List<String> removeEmployee(List<Employee> employeeList, ExecutionType executionType) {
        List<String> removeEmployeeName = new ArrayList<>();
        switch (executionType) {
            case ITERATOR: {
                for (Employee e : employeeList) {
                    removeEmployeeName.add(e.getFirstName());
                }
                Iterator<String> iterator = removeEmployeeName.iterator();
                while (iterator.hasNext()) {
                    if (iterator.next().equals("Oleg")) {
                        iterator.remove();
                    }
                }
                break;
            }
            case STREAM: {
                removeEmployeeName = employeeList.stream()
                        .map(Employee::getFirstName)
                        .collect(Collectors.toList());
                removeEmployeeName.removeIf(s -> s.equals("Oleg"));
                break;
            }
        }
        return removeEmployeeName;
    }

    /**
     * TASK #2
     * Витягнути ліст імен,Змінити всіх Андріїв на Василів (2-3 Андрія щоб була у лісті)
     */
    public List<String> getChangedNameOfEmployee(List<Employee> employeeList, ExecutionType executionType, String targetName, String replacementName){
        List<String> listOfChangedEmployeesName = new ArrayList<>();
        switch (executionType){
            case FOREACH:{
                    for (Employee employee : employeeList) {
                        listOfChangedEmployeesName.add(employee.getFirstName());
                        if (employee.getFirstName().equals(targetName)){
                            listOfChangedEmployeesName.set(employeeList.indexOf(employee), replacementName);
                        }
                }
                break;
            }
            case ITERATOR:{
                for (Employee employee : employeeList) {
                    listOfChangedEmployeesName.add(employee.getFirstName());
                }
                ListIterator<String> nameIterator = listOfChangedEmployeesName.listIterator();
                while (nameIterator.hasNext()){
                    String name = nameIterator.next();
                    if (name.equals(targetName))
                        nameIterator.set(replacementName);
                }
                break;
            }
            case STREAM:{
                listOfChangedEmployeesName = employeeList.stream()
                        .map(s->s.getFirstName().replaceAll(targetName,replacementName))
                        .collect(Collectors.toList());
            }
            break;
        }
        return listOfChangedEmployeesName;
    }

    /**
     * TASK #3
     * Витягнути колекцію працівників віком > 25 років
     */
    public List<Employee> getEmployeesMoreTwentyFiveAge(List<Employee> employeeList, ExecutionType executionType){
        List<Employee> employeesMoreTwentyFiveAge = new ArrayList<>();
        switch (executionType){
            case FOREACH:{
                for (Employee e:employeeList){
                    if (e.getAge()>25){
                        employeesMoreTwentyFiveAge.add(e);
                    }
                }
                break;
            }
            case ITERATOR:{
                employeesMoreTwentyFiveAge.addAll(employeeList);
                Iterator<Employee> ageIterator = employeesMoreTwentyFiveAge.iterator();
                while (ageIterator.hasNext()){
                    if (ageIterator.next().getAge()<25){
                        ageIterator.remove();
                    }
                }
                break;
            }
            case STREAM:{
                employeesMoreTwentyFiveAge = employeeList.stream()
                        .filter(s->s.getAge()>25)
                        .collect(Collectors.toList());
            }
            break;
        }
        return employeesMoreTwentyFiveAge;
    }

    /**
     * TASK #4
     * Знайти будь-якого працівника, якій живе у Львові
     */
    public Employee getEmployeeByAddress(List<Employee> employeeList, ExecutionType executionType, String employeeAddress){
        Employee employeeByAddress = null;
        switch (executionType) {
            case FOREACH: {
                for (Employee e : employeeList) {
                    if (e.getAddress().equals(employeeAddress)) {
                        employeeByAddress = e;
                        break;
                    }
                }
                break;
            }
            case ITERATOR:{
                Iterator<Employee> ageIterator = employeeList.iterator();
                while (ageIterator.hasNext()){
                    Employee e = ageIterator.next();
                    if (e.getAddress().equals(employeeAddress)){
                        employeeByAddress = e;
                        break;
                    }
                }
                break;
            }
            case STREAM: {
            Optional <Employee> employeeOptional = employeeList.stream()
                    .filter(s -> s.getAddress().equals(employeeAddress))
                    .findAny();
            if (employeeOptional.isPresent()) {
                employeeByAddress = employeeOptional.get();
            }
        }
        break;
    }
        return employeeByAddress;
    }

    /**
     * TASK #5
     * Знайти чи є серед працівників хтось, хто живе у Києві
     */
    public boolean isEmployeeLivesByAddress(List<Employee> employeeList, ExecutionType executionType, String address){
        boolean isLivesByAddress = false;
        switch (executionType){
            case FOREACH:{
                for (Employee e:employeeList){
                    if (e.getAddress().equals(address)) {
                        isLivesByAddress = true;
                        break;
                    }
                }
                break;
            }
            case ITERATOR:{
                Iterator<Employee> employeeIterator = employeeList.iterator();
                while (employeeIterator.hasNext()){
                    if (employeeIterator.next().getAddress().equals(address)){
                        isLivesByAddress = true;
                        break;
                    }
                }
                break;
            }
            case STREAM:{
                isLivesByAddress = employeeList.stream()
                        .anyMatch(s->s.getAddress().equals(address));
            }
        }
        return isLivesByAddress;
    }

    /**
     * TASK #6
     * Знайти всіх працівників віком більше = 70 років і повернути нову колекцію з прізвищами цих працівників, добавивши до кожного "Stariy Perdun"
     */
    public List<String> getEmployeesWithAgeMoreThanSeventy(List<Employee> employeeList, ExecutionType executionType, String concatedStringToLastName){
        List<String> lastNameOfEmployeesWithConcatenation = new ArrayList<>();
        switch (executionType){
            case FOREACH:{
                for (Employee e:employeeList){
                    if (e.getAge()>70){
                        lastNameOfEmployeesWithConcatenation.add(e.getLastName().concat(concatedStringToLastName));
                    }
                }
                break;
            }
            case ITERATOR:{
                Iterator<Employee> ageIterator = employeeList.iterator();
                while (ageIterator.hasNext()){
                    Employee employee = ageIterator.next();
                    if (employee.getAge()>70){
                        lastNameOfEmployeesWithConcatenation.add(employee.getLastName().concat(concatedStringToLastName));
                    }
                }
                break;
            }
            case STREAM:{
                lastNameOfEmployeesWithConcatenation = employeeList.stream()
                        .filter(s->s.getAge()>70)
                        .map(s->s.getLastName().concat(concatedStringToLastName))
                        .collect(Collectors.toList());
            }
        }
        return lastNameOfEmployeesWithConcatenation;
    }

    /**
     * TASK #7
     * Знайти всіх працівників, хто живе у києві та повернути колекцію унікальних їх імен
     */
    public Set<String> getDistinctEmployeesNameByAddress(List<Employee> employeeList, ExecutionType executionType, String address){
        Set<String> distinctEmployeesName = new HashSet<>();
        switch (executionType){
            case FOREACH:{
                for (Employee e:employeeList){
                    if (e.getAddress().equals(address)){
                        distinctEmployeesName.add(e.getFirstName());
                    }
                }
                break;
            }
            case ITERATOR:{
                Iterator<Employee> employeeIterator = employeeList.iterator();
                while (employeeIterator.hasNext()){
                    Employee employee = employeeIterator.next();
                    if (employee.getAddress().equals(address)){
                        distinctEmployeesName.add(employee.getFirstName());
                    }
                }
                break;
            }
            case STREAM:{
                distinctEmployeesName = employeeList.stream()
                        .filter(s->s.getAddress().equals(address))
                        .map(s->s.getFirstName())
                        .collect(Collectors.toSet());
                break;
            }
        }
        return distinctEmployeesName;
    }

    /**
     * TASK #8
     * Вивести дані просто кожного працівника в консоль і витягнути колекцію адрес
     */
    public Set<String> getToStringAndAddressOfEmployees(List<Employee> employeeList, ExecutionType executionType){
        Set<String> addressOfEmployees = new HashSet<>();
        switch (executionType){
            case FOREACH:{
                employeeList.forEach(s->System.out.println(s.toString()));
                for (Employee e:employeeList){
                    addressOfEmployees.add(e.getAddress());
                }
                break;
            }
            case ITERATOR:{
                employeeList.forEach(s->System.out.println(s.toString()));
                Iterator<Employee> employeeIterator = employeeList.iterator();
                while (employeeIterator.hasNext()){
                    addressOfEmployees.add(employeeIterator.next().getAddress());
                }
                break;
            }
            case STREAM:{
               employeeList
                       .forEach(System.out::println);
                addressOfEmployees = employeeList.stream()
                        .map(Employee::getAddress)
                        .collect(Collectors.toSet());
                break;
            }
        }
        return addressOfEmployees;
    }

    /**
     * TASK #9
     * Витягнути колекцію імен працівників так, щоб нова колекція включала в себе 5 імен
     */
    public List<String> getFiveEmployeesName(List<Employee> employeeList, ExecutionType executionType){
        List<String> fiveEmployeesName = new ArrayList<>();
        switch (executionType){
            case FOREACH:{
                for (Employee e:employeeList){
                    fiveEmployeesName.add(e.getFirstName());
                    if (fiveEmployeesName.size() == 5)
                        break;
                }
                break;
            }
            case ITERATOR:{
                Iterator<Employee> employeeIterator = employeeList.iterator();
                while (employeeIterator.hasNext()){
                    fiveEmployeesName.add(employeeIterator.next().getFirstName());
                    if (fiveEmployeesName.size() == 5)
                        break;
                }
                break;
            }
            case STREAM:{
                fiveEmployeesName = employeeList.stream()
                        .map(Employee::getFirstName)
                        .limit(5)
                        .collect(Collectors.toList());
            }
            break;
        }
        return fiveEmployeesName;
    }

    /**
     * TASK #10
     * Порахувати суму віку всіх працівників
     */
    public Integer getSumOfAge(List<Employee> employeeList, ExecutionType executionType){
        Integer sumOfAge = 0;
        switch (executionType){
            case FOREACH:{
                for (Employee e:employeeList){
                    sumOfAge += e.getAge();
                }
                break;
            }
            case ITERATOR:{
                Iterator<Employee> employeeIterator = employeeList.iterator();
                while (employeeIterator.hasNext()){
                    sumOfAge += employeeIterator.next().getAge();
                }
                break;
            }
            case STREAM:{
                sumOfAge = employeeList.stream()
                        .map(Employee::getAge)
                        .reduce(0,Integer::sum);
            }
            break;
        }
        return sumOfAge;
    }

    /**
     * TASK #11
     * Перевірити, чи всі працівники старше 18ти
     */
    public boolean isAllEmployeesOldestEighteen(List<Employee> employeeList, ExecutionType executionType){
        boolean isAllEmployeesOldest = false;
        switch (executionType){
            case FOREACH:{
                for (Employee e:employeeList){
                    if (e.getAge() <= 18){
                        isAllEmployeesOldest = false;
                        break;
                    }else isAllEmployeesOldest =true;
                }
                break;
            }
            case ITERATOR:{
                Iterator<Employee> employeeIterator = employeeList.iterator();
                while (employeeIterator.hasNext()) {
                    if (employeeIterator.next().getAge() <= 18) {
                        isAllEmployeesOldest = false;
                        break;
                    } else isAllEmployeesOldest = true;
                }
                break;
            }
            case STREAM:{
                isAllEmployeesOldest= employeeList.stream()
                        .map(Employee::getAge)
                        .allMatch(num->num>18);
            }
        }
        return isAllEmployeesOldest;
    }
}
