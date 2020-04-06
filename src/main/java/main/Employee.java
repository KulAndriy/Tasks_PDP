package main;

public class Employee implements Comparable <Employee>{
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private int age;

    public Employee(int id, String firstName, String lastName, String address, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", adress='" + address + '\'' +
                ", age=" + age +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return id == employee.getId()
                && age == employee.getAge()
                && (firstName == employee.getFirstName() || (firstName != null && firstName.equals(employee.getFirstName())))
                && (lastName == employee.getLastName() || (lastName != null && lastName.equals(employee.getLastName())))
                && (address == employee.getAddress() || (address != null && address.equals(employee.getAddress())));
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        return result;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() { return age; }

    @Override
    public int compareTo(Employee o) {
        return getFirstName().compareTo(o.firstName);
    }
}
