package comparator;

import main.Employee;

import java.util.Comparator;

public class ComparatorProcessor {
    public Comparator<Employee> getComparator(ComparatorType comparatorType){
        Comparator<Employee> employeeComparator = null;
        switch (comparatorType){
            case ID_SORTED: employeeComparator = new IdSorted();
            break;
            case FIRST_NAME_SORTED: employeeComparator = new FirstNameSorted();
            break;
            case LAST_NAME_SORTED:employeeComparator = new LastNameSorted();
            break;
        }
        return employeeComparator;
    }
}
