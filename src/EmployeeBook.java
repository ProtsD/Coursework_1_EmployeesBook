import java.sql.SQLOutput;
import java.util.Arrays;

public class EmployeeBook {
    private Employee[] employeesBook;

    public EmployeeBook(int numberEmployees) {
        employeesBook = new Employee[numberEmployees];
    }

    /////////////////////// first level of complexity - methods ////////////////////////
    public void printEmployeesData() {
        for (int i = 0; i < employeesBook.length; i++) {
            System.out.println(employeesBook[i]);
        }
    }

    public void printAllEmployeesList() {
        for (int i = 0; i < employeesBook.length; i++) {
            System.out.println(
                    employeesBook[i].getFirstName() + " " +
                            employeesBook[i].getMiddleName() + " " +
                            employeesBook[i].getSecondName());
        }
    }

    public void printWithoutDepartment(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            System.out.println(
                    employees[i].getId() + " " +
                            employees[i].getFirstName() + " " +
                            employees[i].getMiddleName() + " " +
                            employees[i].getSecondName() + " " +
                            employees[i].getSalary());
        }
    }

    public void printByDepartmentGroup() {
        String[] ArrayOfDepartments = extractArrayOfDepartments();
        Arrays.sort(ArrayOfDepartments);
        ArrayOfDepartments = deleteDuplicates(ArrayOfDepartments);

        for (int i = 0; i < ArrayOfDepartments.length; i++) {
            System.out.println("Department: " + ArrayOfDepartments[i]);
            for (int j = 0; j < employeesBook.length; j++) {
                if (employeesBook[j] == null) continue;
                if (ArrayOfDepartments[i] == employeesBook[j].getDepartment()) {
                    System.out.println(employeesBook[j]);
                }
            }
        }
    }

    public double calcTotalSalaries() {
        double totalSalary = 0;
        for (int i = 0; i < employeesBook.length; i++) {
            totalSalary += employeesBook[i].getSalary();
        }
        return totalSalary;
    }

    public double calcTotalSalaries(String department) {
        double totalSalary = 0;
        for (int i = 0; i < employeesBook.length; i++) {
            if (employeesBook[i].getDepartment().equals(department)) {
                totalSalary += employeesBook[i].getSalary();
            }
        }
        return totalSalary;
    }

    public Employee findEmplWithMinSalary() {
        double minSalary = employeesBook[0].getSalary();
        int employeeId = 0;
        for (int i = 0; i < employeesBook.length; i++) {
            if (minSalary > employeesBook[i].getSalary()) {
                minSalary = employeesBook[i].getSalary();
                employeeId = i;
            }
        }
        return employeesBook[employeeId];
    }

    public Employee findEmplWithMinSalary(String department) {
        double minSalary = employeesBook[0].getSalary();
        int employeeId = 0;
        for (int i = 0; i < employeesBook.length; i++) {
            if (employeesBook[i].getDepartment().equals(department) && minSalary > employeesBook[i].getSalary()) {
                minSalary = employeesBook[i].getSalary();
                employeeId = i;
            }
        }
        return employeesBook[employeeId];
    }

    public Employee findEmplWithMaxSalary() {
        double maxSalary = employeesBook[0].getSalary();
        int employeeId = 0;
        for (int i = 0; i < employeesBook.length; i++) {
            if (maxSalary < employeesBook[i].getSalary()) {
                maxSalary = employeesBook[i].getSalary();
                employeeId = i;
            }
        }
        return employeesBook[employeeId];
    }

    public Employee findEmplWithMaxSalary(String department) {
        double maxSalary = employeesBook[0].getSalary();
        int employeeId = 0;
        for (int i = 0; i < employeesBook.length; i++) {
            if (employeesBook[i].getDepartment().equals(department) && maxSalary < employeesBook[i].getSalary()) {
                maxSalary = employeesBook[i].getSalary();
                employeeId = i;
            }
        }
        return employeesBook[employeeId];
    }

    public double calcAverageSalary() {
        double totalSalary = 0;
        for (int i = 0; i < employeesBook.length; i++) {
            totalSalary += employeesBook[i].getSalary();
        }
        return totalSalary / employeesBook.length;
    }

    public double calcAverageSalary(String department) {
        double totalSalary = 0;
        int numberEmployeesInDepartment = 0;
        for (int i = 0; i < employeesBook.length; i++) {
            if (employeesBook[i].getDepartment().equals(department)) {
                totalSalary += employeesBook[i].getSalary();
                numberEmployeesInDepartment++;
            }
        }
        return totalSalary / numberEmployeesInDepartment;
    }

    public void increaseAllEmplSalaries(int factor) {
        for (int i = 0; i < employeesBook.length; i++) {
            employeesBook[i].setSalary(employeesBook[i].getSalary() * (factor + 100) / 100);
        }
    }

    public void increaseSalariesInDepartment(String department, int factor) {
        for (int i = 0; i < employeesBook.length; i++) {
            if (employeesBook[i].getDepartment().equals(department)) {
                employeesBook[i].setSalary(employeesBook[i].getSalary() * (factor + 100) / 100);
            }
        }
    }

    public Employee[] getEmployeesInDepartment(String department) {
        Employee[] Array = new Employee[employeesBook.length];
        int employeeNumber = 0;
        for (int i = 0; i < employeesBook.length; i++) {
            if (employeesBook[i] == null) continue;
            if (employeesBook[i].getDepartment().equals(department)) {
                Array[employeeNumber] = employeesBook[i];
                employeeNumber++;
            }
        }
        Array = Arrays.copyOf(Array, employeeNumber);
        return Array;
    }

    public Employee[] getEmployeesWithSalaryUnder(double salary) {
        Employee[] Array = new Employee[employeesBook.length];
        int employeeNumber = 0;
        for (int i = 0; i < employeesBook.length; i++) {
            if (employeesBook[i] == null) continue;
            if (employeesBook[i].getSalary() > salary) {
                Array[employeeNumber] = employeesBook[i];
                employeeNumber++;
            }
        }
        Array = Arrays.copyOf(Array, employeeNumber);
        return Array;
    }

    public Employee[] getEmployeesWithSalaryBelow(double salary) {
        Employee[] Array = new Employee[employeesBook.length];
        int employeeNumber = 0;
        for (int i = 0; i < employeesBook.length; i++) {
            if (employeesBook[i] == null) continue;
            if (employeesBook[i].getSalary() < salary) {
                Array[employeeNumber] = employeesBook[i];
                employeeNumber++;
            }
        }
        Array = Arrays.copyOf(Array, employeeNumber);
        return Array;
    }

    public void addEmployee(Employee employee) {
        for (int i = 0; i < employeesBook.length; i++) {
            if (employeesBook[i] == null) {
                employeesBook[i] = employee;
                return;
            }
        }
    }

    public void deleteEmployee(String firstName, String middleName, String secondName) {
        for (int i = 0; i < employeesBook.length; i++) {
            if (employeesBook[i] == null) {
                continue;
            }
            if (employeesBook[i].getFirstName() == firstName &&
                    employeesBook[i].getMiddleName() == middleName &&
                    employeesBook[i].getSecondName() == secondName) {
                employeesBook[i] = null;
            }
        }
    }

    public void deleteEmployee(int employeeId) {
        for (int i = 0; i < employeesBook.length; i++) {
            if (employeesBook[i] == null) {
                continue;
            }
            if (employeesBook[i].getId() == employeeId) {
                employeesBook[i] = null;
            }
        }
    }

    public Employee getEmployee(String firstName, String middleName, String secondName) {
        for (int i = 0; i < employeesBook.length; i++) {
            if (employeesBook[i] == null) {
                continue;
            }
            if (employeesBook[i].getFirstName() == firstName &&
                    employeesBook[i].getMiddleName() == middleName &&
                    employeesBook[i].getSecondName() == secondName) {
                return employeesBook[i];
            }
        }
        return null;
    }

    public void changeSalaryOrDepartment(Employee employee, double salary, String department) {
        if (salary != 0) {
            employee.setSalary(salary);
        }
        if (department != null) {
            employee.setDepartment(department);
        }
    }

    private String[] extractArrayOfDepartments() {
        String[] ArrayOfDepartments = new String[employeesBook.length];
        int employeeNumber = 0;
        for (int i = 0; i < employeesBook.length; i++) {
            if (employeesBook[i] == null) continue;
            ArrayOfDepartments[employeeNumber] = employeesBook[i].getDepartment();
            employeeNumber++;
        }
        ArrayOfDepartments = Arrays.copyOf(ArrayOfDepartments, employeeNumber);
        Arrays.sort(ArrayOfDepartments);
        return ArrayOfDepartments;
    }

    private String[] deleteDuplicates(String[] Array) {
        int j = 0;
        for (int i = 1; i < Array.length; i++) {
            if (Array[i] != Array[i - 1]) {
                j++;
                Array[j] = Array[i];
            }
        }
        return Array = Arrays.copyOf(Array, j + 1);
    }
}