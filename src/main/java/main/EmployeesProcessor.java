package main;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeesProcessor {
    /**
     * TASK #1
     * Витягнути ліст імен, Видалити всіх Олегів з ліста (відповідно, щоб у лісті було їх хоча б кілька)
     */
    public List<String> removeEmployee(List<Employee> employeeList, ExecutionType executionType) {
        List<String> removeEmployeeName =null;
        switch (executionType) {
            case FOREACH: {
                removeEmployeeName = new ArrayList<>();
                for (Employee e : employeeList) {
                    String name = e.getFirstName();
                    if (!name.equals("Oleg"))
                        removeEmployeeName.add(name);
                }
                break;
            }
            case ITERATOR: {
                removeEmployeeName = new ArrayList<>();
                for (Employee e : employeeList) {
                    String name = e.getFirstName();
                    removeEmployeeName.add(name);
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
                        .map(a -> a.getFirstName())
                        .filter(s -> !s.equals("Oleg"))
                        .collect(Collectors.toList());
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
        List<String> listOfChangedEmployeesName = null;
        switch (executionType){
            case FOREACH:{
                listOfChangedEmployeesName  = new ArrayList<>();
                for (int i=0; i<employeeList.size(); i++){
                    String name = employeeList.get(i).getFirstName();
                    listOfChangedEmployeesName.add(name);
                    if (listOfChangedEmployeesName.get(i).equals(targetName)){
                        listOfChangedEmployeesName.set(i, replacementName);
                    }
                }
            }
            case ITERATOR:{
                listOfChangedEmployeesName = new ArrayList<>();
                for (Employee employee : employeeList) {
                    listOfChangedEmployeesName.add(employee.getFirstName());
                }
                ListIterator<String> nameIterator = listOfChangedEmployeesName.listIterator();
                while (nameIterator.hasNext()){
                    String name = nameIterator.next();
                    if (name.equals(targetName))
                        nameIterator.set(replacementName);
                }
            }
            case STREAM:{
                listOfChangedEmployeesName = employeeList.stream()
                        .map(s->s.getFirstName().replaceAll(targetName,replacementName))
                        .collect(Collectors.toList());
            }
        }
        return listOfChangedEmployeesName;
    }

    /**
     * TASK #3
     * Витягнути колекцію працівників віком > 25 років
     */
    public List<Employee> getEmployeesMoreTwentyFiveAge(List<Employee> employeeList, ExecutionType executionType){
        List<Employee> employeesMoreTwentyFiveAge = null;
        switch (executionType){
            case FOREACH:{
                employeesMoreTwentyFiveAge = new ArrayList<>();
                for (Employee e:employeeList){
                    if (e.getAge()>25){
                        employeesMoreTwentyFiveAge.add(e);
                    }
                }
            }
            case ITERATOR:{
                employeesMoreTwentyFiveAge = new ArrayList<>(employeeList);
                Iterator<Employee> ageIterator = employeesMoreTwentyFiveAge.iterator();
                while (ageIterator.hasNext()){
                    if (ageIterator.next().getAge()<25){
                        ageIterator.remove();
                    }
                }
            }
            case STREAM:{
                employeesMoreTwentyFiveAge = employeeList.stream()
                        .filter(s->s.getAge()>25)
                        .collect(Collectors.toList());
            }
        }
        return employeesMoreTwentyFiveAge;
    }

    /**
     * TASK #4
     * Знайти будь-якого працівника, якій живе у Львові
     */
    public List<Employee> getEmployeesAddress(List<Employee> employeeList, ExecutionType executionType, String employeeAddress){
        List<Employee> addressOfEmployees = null;
        switch (executionType) {
            case FOREACH: {
                addressOfEmployees = new ArrayList<>();
                for (Employee e : employeeList) {
                    if (e.getAddress().equals(employeeAddress)) {
                        addressOfEmployees.add(e);
                        break;
                    }
                }
                break;
            }
            case ITERATOR:{
                addressOfEmployees = new ArrayList<>();
                Iterator<Employee> ageIterator = employeeList.iterator();
                while (ageIterator.hasNext()){
                    Employee e = ageIterator.next();
                    if (e.getAddress() == employeeAddress){
                        addressOfEmployees.add(e);
                        break;
                    }
                }
                break;
            }
            case STREAM: {
                Optional<Employee> employeesAddressOptional = employeeList.stream()
                        .filter(s -> s.getAddress().equals(employeeAddress))
                        .findAny();
                System.out.println("Employee who lives in Lviv:  size: ");
                employeesAddressOptional.ifPresent(System.out::println);
                }
                break;
            }
        return addressOfEmployees;
    }

    /**
     * TASK #5
     * Знайти чи є серед працівників хтось, хто живе у Києві
     */
    public boolean getAddressOfEmployee(List<Employee> employeeList, ExecutionType executionType, String address){
        boolean addressOfEmployees = false;
        switch (executionType){
            case FOREACH:{
                for (Employee e:employeeList){
                    if (e.getAddress().equals(address)) {
                        addressOfEmployees = true;
                        break;
                    }
                }
                break;
            }
            case ITERATOR:{
                Iterator<Employee> employeeIterator = employeeList.iterator();
                while (employeeIterator.hasNext()){
                    if (employeeIterator.next().getAddress() == address){
                        addressOfEmployees = true;
                    }
                }
                break;
            }
            case STREAM:{
                addressOfEmployees = employeeList.stream()
                        .anyMatch(s->s.getAddress().equals(address));
            }
        }
        return addressOfEmployees;
    }

    /**
     * TASK #6
     * Знайти всіх працівників віком більше = 70 років і повернути нову колекцію з прізвищами цих працівників, добавивши до кожного "Stariy Perdun"
     */
    public List<Employee> getEmployeesWithAgeMoreThanSeventy(List<Employee> employeeList, ExecutionType executionType){
        List<Employee> ageOfEmployeesWithConcatenation = null;
        switch (executionType){
            case FOREACH:{
                ageOfEmployeesWithConcatenation = new ArrayList<>();
                for (Employee e:employeeList){
                    if (e.getAge()>70){
                        ageOfEmployeesWithConcatenation.add(new Employee(e.getId(),e.getFirstName().concat(" Staryy Perdun"),
                                e.getLastName(),e.getAddress(),e.getAge()));
                    }
                }
                break;
            }
            case ITERATOR:{
                ageOfEmployeesWithConcatenation = new ArrayList<>();
                Iterator<Employee> ageIterator = employeeList.iterator();
                while (ageIterator.hasNext()){
                    Employee employee = ageIterator.next();
                    if (employee.getAge()>70){
                        ageOfEmployeesWithConcatenation.add(new Employee(employee.getId(),employee.getFirstName().concat(" Staryy Perdun"),
                                employee.getLastName(),employee.getAddress(),employee.getAge()));
                    }
                }
                break;
            }
            case STREAM:{
                ageOfEmployeesWithConcatenation = employeeList.stream()
                        .filter(s->s.getAge()>70)
                        .map(s->new Employee(s.getId(),s.getFirstName(),s.getLastName(),s.getAddress(),s.getAge()))
                        .peek(s->s.setFirstName(s.getFirstName().concat(" Staryy Perdun")))
                        .collect(Collectors.toList());
            }
        }
        return ageOfEmployeesWithConcatenation;
    }

    /**
     * TASK #7
     * Знайти всіх працівників, хто живе у києві та повернути колекцію унікальних їх імен
     */
    public Set<String> getEmployeesByAddress(List<Employee> employeeList, ExecutionType executionType, String address){
        Set<String> employeesByAddress = null;
        switch (executionType){
            case FOREACH:{
                employeesByAddress = new HashSet<>();
                for (Employee e:employeeList){
                    if (e.getAddress().equals(address)){
                        employeesByAddress.add(e.getFirstName());
                    }
                }
                break;
            }
            case ITERATOR:{
                employeesByAddress = new HashSet<>();
                Iterator<Employee> employeeIterator = employeeList.iterator();
                while (employeeIterator.hasNext()){
                    Employee employee = employeeIterator.next();
                    if (employee.getAddress().equals(address)){
                        employeesByAddress.add(employee.getFirstName());
                    }
                }
                break;
            }
            case STREAM:{
                employeesByAddress = employeeList.stream()
                        .filter(s->s.getAddress().equals(address))
                        .map(s->s.getFirstName())
                        .collect(Collectors.toSet());
                break;
            }
        }
        return employeesByAddress;
    }

    /**
     * TASK #8
     * Вивести дані просто кожного працівника в консоль і витягнути колекцію адрес
     */
    public Set<String> getAddressOfEmployees(List<Employee> employeeList, ExecutionType executionType){
        Set<String> distinctAddressesOfEmployees = null;
        switch (executionType){
            case FOREACH:{
                distinctAddressesOfEmployees = new HashSet<>();
                for (Employee e:employeeList){
                    distinctAddressesOfEmployees.add(e.getAddress());
                }
                break;
            }
            case ITERATOR:{
                distinctAddressesOfEmployees = new HashSet<>();
                Iterator<Employee> employeeIterator = employeeList.iterator();
                while (employeeIterator.hasNext()){
                    distinctAddressesOfEmployees.add(employeeIterator.next().getAddress());
                }
                break;
            }
            case STREAM:{
                distinctAddressesOfEmployees = employeeList.stream()
                        .map(s->s.getAddress())
                        .collect(Collectors.toSet());
                break;
            }
        }
        return distinctAddressesOfEmployees;
    }

    /**
     * TASK #9
     * Витягнути колекцію імен працівників так, щоб нова колекція включала в себе 5 імен
     */
    public List<String> getFiveEmployeesName(List<Employee> employeeList, ExecutionType executionType){
        List<String> fiveEmployeesName = null;
        switch (executionType){
            case FOREACH:{
                fiveEmployeesName = new ArrayList<>();
                for (Employee e:employeeList){
                    if (!(fiveEmployeesName.size() == 5)) {
                        fiveEmployeesName.add(e.getFirstName());
                    }
                }
                break;
            }
            case ITERATOR:{
                fiveEmployeesName = new ArrayList<>();
                Iterator<Employee> employeeIterator = employeeList.iterator();
                while (employeeIterator.hasNext()){
                    String name = employeeIterator.next().getFirstName();
                    if (!(fiveEmployeesName.size() == 5)) {
                        fiveEmployeesName.add(name);
                    }
                }
                break;
            }
            case STREAM:{
                fiveEmployeesName = employeeList.stream()
                        .map(s->s.getFirstName())
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
                        .map(s->s.getAge())
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
    public boolean checkIfAllEmployeesOldestEighteen(List<Employee> employeeList, ExecutionType executionType){
        boolean allEmployeesOldest = false;
        switch (executionType){
            case FOREACH:{
                int countAge = 0;
                for (Employee e:employeeList){
                    if (e.getAge()>18){
                        countAge++;
                    }
                }
                if (countAge == employeeList.size())  {
                    allEmployeesOldest = true;
                }else allEmployeesOldest = false;
                break;
            }
            case ITERATOR:{
                Iterator<Employee> employeeIterator = employeeList.iterator();
                int countAge = 0;
                while (employeeIterator.hasNext()){
                    if (employeeIterator.next().getAge() > 18){
                        countAge++;
                    }
                    if (countAge == employeeList.size()){
                        allEmployeesOldest = true;
                    }else allEmployeesOldest = false;
                }
                break;
            }
            case STREAM:{
                allEmployeesOldest= employeeList.stream()
                        .map(s->s.getAge())
                        .allMatch(num->num>18);
            }
        }
        return allEmployeesOldest;
    }
}
