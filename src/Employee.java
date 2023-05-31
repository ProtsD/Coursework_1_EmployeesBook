import java.util.Objects;

public class Employee {
    private int id = 0;
    private String firstName;
    private String middleName;
    private String secondName;
    private String department;
    private double salary;

    private static int idCount = 0;

    public Employee(String firstName, String middleName, String secondName, String department, int salary) {
        id = idCount;
        this.firstName = firstName;
        this.middleName = middleName;
        this.secondName = secondName;
        this.department = department;
        this.salary = salary;
        idCount++;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + " " + firstName + " " + middleName + " " + secondName + " " + department + " " + salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) &&
                Objects.equals(middleName, employee.middleName) &&
                Objects.equals(secondName, employee.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, secondName);
    }
}
