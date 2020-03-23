package task_6;

import main.Employee;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class AgeWithConcatenation {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Andriy", "Barabanov", "Lviv", 23));
        employeeList.add(new Employee(2, "Oleg", "Kostyshyn", "New York", 40));
        employeeList.add(new Employee(2, "Oleg", "Kostyuk", "Kyiv", 21));
        employeeList.add(new Employee(3, "Vasyl", "Borovych", "Lviv", 71));
        employeeList.add(new Employee(4, "Dmytro", "Vanish", "Kyiv", 28));
        employeeList.add(new Employee(5, "Taras", "Baras", "New York", 75));
        employeeList.add(new Employee(1, "Andriy", "Barabanov", "Lviv", 23));
        employeeList.add(new Employee(12, "Vitaliy", "Fava", "Dnipro", 19));
        employeeList.add(new Employee(8, "Dmytro", "Orlyk", "Kyiv", 30));
        employeeList.add(new Employee(1, "Oleg", "Barabanov", "Lviv", 23));
        employeeList.add(new Employee(1, "Oleg", "Serhiyshuk", "Kyiv", 76));
        employeeList.add(new Employee(2, "Oleg", "Kostyshyn", "New York", 40));
        employeeList.add(new Employee(8, "Dmytro", "Baran", "Kyiv", 48));
        employeeList.add(new Employee(5, "Vasyl", "Костин", "Dnipro", 70));
        employeeList.add(new Employee(1, "Andriy", "Barabanov", "Lviv", 23));
        employeeList.add(new Employee(10, "Taras", "Galyk", "Kyiv", 34));
        employeeList.add(new Employee(1, "Andriy", "Barabanov", "Lviv", 23));
        employeeList.add(new Employee(7, "Anatoloi", "Fabra", "Odesa", 30));
        employeeList.add(new Employee(11, "Borys", "Var", "Odesa", 28));


        //Знайти всіх працівників віком більше = 70 років і повернути нову колекцію з прізвищами цих працівників, добавивши до кожного "Stariy Perdun"
        List<Employee> ageConcatenation = new ArrayList<>();
        for (Employee e:employeeList){
            if (e.getAge()>70){
                ageConcatenation.add(new Employee(e.getId(),e.getFirstName(),e.getLastName(),e.getAddress(),e.getAge()));
            }
        }
        for (Employee employee:ageConcatenation){
            employee.setFirstName(employee.getFirstName().concat(" Staryy Perdun"));
        }

        //Print collection List
        System.out.println("New collection with age >70 and concatenated fistName:  size: " + ageConcatenation.size());
        for (Employee emp : ageConcatenation) {
            System.out.println(emp);
        }
        System.out.println();
//Stream API
        List<Employee> ageConcatStream = employeeList.stream()
                .filter(s->s.getAge()>70)
                .map(s->new Employee(s.getId(),s.getFirstName(),s.getLastName(),s.getAddress(),s.getAge()))
                .peek(s->s.setFirstName(s.getFirstName().concat(" Staryy Perdun")))
                .collect(Collectors.toList());
        System.out.println("New Stream collection with age >70 and concatenated fistName:  size: " + ageConcatStream.size());
        ageConcatStream.forEach(System.out::println);
        System.out.println();

        employeeList.forEach(System.out::println);


//
//
//
//        //2. Changing all objects with first name "Andriy" to "Vasyl"
//        List<Employee> changeList = new ArrayList<>();
//
//        for (Employee e : employeeList) {
//            changeList.add(new Employee(e.getId(), e.getFirstName(), e.getLastName(), e.getAddress(), e.getAge()));
//        }
//        Iterator<Employee> employeeIterator = changeList.iterator();
//        for (int i = 0; i < changeList.size(); i++) {
//
//            if (changeList.get(i).getFirstName().equals("Andriy")) {
//                changeList.get(i).setFirstName("Vasyl");
//                employeeIterator.next().setFirstName("Vasyla");
//
//            }
//        }
//        System.out.println();
//        //Print collection List
//        System.out.println("Modified List after updating first name 'Andriy' to 'Vasyl':  size: " + changeList.size());
//        for (Employee emp : changeList) {
//            System.out.println(emp);
//        }
//
//        //First example
//        List<String> changedName = new ArrayList<>();
//
//        for (int i = 0; i < employeeList.size(); i++) {
//            String name = employeeList.get(i).getFirstName();
//            changedName.add(name);
//            if (changedName.get(i).equals("Andriy")) {
//                changedName.set(i, "Oleg");
//            }
//        }
//        System.out.println("First modified List of names :  size: " + changedName.size() + "\n" + changedName + "\n");
//
//        //Stream API
//        List<String> changedStream = employeeList.stream()
////                .peek(changeL->changeL.setFirstName(changeL.getFirstName().replace("Andriy","Vasya")))
//                .map(s -> s.getFirstName().replaceAll("Andriy", "Oleg"))
//                .collect(Collectors.toList());
//        System.out.println("Modified List after updating first name 'Andriy' to 'Vasyl':  size: " + changedStream.size() + "\n" + changedStream + "\n");
//
    }
}
