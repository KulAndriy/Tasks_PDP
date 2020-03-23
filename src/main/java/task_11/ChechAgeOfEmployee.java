package task_11;

import com.sun.org.apache.xpath.internal.functions.FuncSum;
import main.Employee;

import java.util.ArrayList;
import java.util.List;

public class ChechAgeOfEmployee {
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
        employeeList.add(new Employee(11, "Borys", "Var", "Odesa", 78));

        boolean check;
        int countAge = 0;
        List<Integer> ageList = new ArrayList<>();
        for (Employee e:employeeList){
            ageList.add(e.getAge());
            if (e.getAge()>18){
                countAge++;
            }
        }


        if (countAge == employeeList.size())  {
            check = true;
        }else check = false;

        System.out.println("Are all employees oldest 18?    " + "\n" + check + "\n");
        System.out.println("The list of age: " + "\n" + ageList + "\n");

        //Stream API
        Boolean allOldest = employeeList.stream()
                .map(s->s.getAge())
                .allMatch(num->num>18);

        System.out.println("Are all employees oldest 18? " +"\n" + allOldest);
    }
}
