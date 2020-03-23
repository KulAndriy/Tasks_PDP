package main;

public class Employee implements Comparable <Employee>{
    private int id;
    private String firstName;
    private String lastName;
    private String address;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (getId() != employee.getId()) return false;
        if (!getFirstName().equals(employee.getFirstName())) return false;
        return getLastName().equals(employee.getLastName());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        return result;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
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

    public Employee(int id, String firstName, String lastName, String address, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.age = age;
    }

    private int age;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

//    @Override
//    public int compareTo(main.Employee o) {
//        if (id == o.id) {
//            return 0;
//        }else if (id < o.id){
//            return -1;
//        }else {
//            return 1;
//        }

        @Override
        public int compareTo(Employee o) {
        return getFirstName().compareTo(o.firstName);
    }
}
