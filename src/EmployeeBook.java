import java.sql.SQLOutput;
import java.util.Arrays;

public class EmployeeBook {
    private Employee[] EmployeesBook;

    public EmployeeBook(int numberEmployees) {
        EmployeesBook = new Employee[numberEmployees];
    }

    /////////////////////// first level of complexity - methods ////////////////////////
    public void printEmployeesData() {
        for (int i = 0; i < EmployeesBook.length; i++) {
            System.out.println(EmployeesBook[i]);
        }
    }

    public void printAllEmployeesList() {
        for (int i = 0; i < EmployeesBook.length; i++) {
            System.out.println(
                    EmployeesBook[i].getFirstName() + " " +
                            EmployeesBook[i].getMiddleName() + " " +
                            EmployeesBook[i].getSecondName());
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
            for (int j = 0; j < EmployeesBook.length; j++) {
                if (EmployeesBook[j] == null) continue;
                if (ArrayOfDepartments[i] == EmployeesBook[j].getDepartment()) {
                    System.out.println(EmployeesBook[j]);
                }
            }
        }
    }

    public double calcTotalSalaries() {
        double totalSalary = 0;
        for (int i = 0; i < EmployeesBook.length; i++) {
            totalSalary += EmployeesBook[i].getSalary();
        }
        return totalSalary;
    }

    public double calcTotalSalaries(String department) {
        double totalSalary = 0;
        for (int i = 0; i < EmployeesBook.length; i++) {
            if (EmployeesBook[i].getDepartment().equals(department)) {
                totalSalary += EmployeesBook[i].getSalary();
            }
        }
        return totalSalary;
    }

    public Employee findEmplWithMinSalary() {
        double minSalary = EmployeesBook[0].getSalary();
        int employeeId = 0;
        for (int i = 0; i < EmployeesBook.length; i++) {
            if (minSalary > EmployeesBook[i].getSalary()) {
                minSalary = EmployeesBook[i].getSalary();
                employeeId = i;
            }
        }
        return EmployeesBook[employeeId];
    }

    public Employee findEmplWithMinSalary(String department) {
        double minSalary = EmployeesBook[0].getSalary();
        int employeeId = 0;
        for (int i = 0; i < EmployeesBook.length; i++) {
            if (EmployeesBook[i].getDepartment().equals(department) && minSalary > EmployeesBook[i].getSalary()) {
                minSalary = EmployeesBook[i].getSalary();
                employeeId = i;
            }
        }
        return EmployeesBook[employeeId];
    }

    public Employee findEmplWithMaxSalary() {
        double maxSalary = EmployeesBook[0].getSalary();
        int employeeId = 0;
        for (int i = 0; i < EmployeesBook.length; i++) {
            if (maxSalary < EmployeesBook[i].getSalary()) {
                maxSalary = EmployeesBook[i].getSalary();
                employeeId = i;
            }
        }
        return EmployeesBook[employeeId];
    }

    public Employee findEmplWithMaxSalary(String department) {
        double maxSalary = EmployeesBook[0].getSalary();
        int employeeId = 0;
        for (int i = 0; i < EmployeesBook.length; i++) {
            if (EmployeesBook[i].getDepartment().equals(department) && maxSalary < EmployeesBook[i].getSalary()) {
                maxSalary = EmployeesBook[i].getSalary();
                employeeId = i;
            }
        }
        return EmployeesBook[employeeId];
    }

    public double calcAverageSalary() {
        double totalSalary = 0;
        for (int i = 0; i < EmployeesBook.length; i++) {
            totalSalary += EmployeesBook[i].getSalary();
        }
        return totalSalary / EmployeesBook.length;
    }

    public double calcAverageSalary(String department) {
        double totalSalary = 0;
        int numberEmployeesInDepartment = 0;
        for (int i = 0; i < EmployeesBook.length; i++) {
            if (EmployeesBook[i].getDepartment().equals(department)) {
                totalSalary += EmployeesBook[i].getSalary();
                numberEmployeesInDepartment++;
            }
        }
        return totalSalary / numberEmployeesInDepartment;
    }

    public void increaseAllEmplSalaries(int factor) {
        for (int i = 0; i < EmployeesBook.length; i++) {
            EmployeesBook[i].setSalary(EmployeesBook[i].getSalary() * (factor + 100) / 100);
        }
    }

    public void increaseSalariesInDepartment(String department, int factor) {
        for (int i = 0; i < EmployeesBook.length; i++) {
            if (EmployeesBook[i].getDepartment().equals(department)) {
                EmployeesBook[i].setSalary(EmployeesBook[i].getSalary() * (factor + 100) / 100);
            }
        }
    }

    public Employee[] getEmployeesInDepartment(String department) {
        Employee[] Array = new Employee[EmployeesBook.length];
        int employeeNumber = 0;
        for (int i = 0; i < EmployeesBook.length; i++) {
            if (EmployeesBook[i] == null) continue;
            if (EmployeesBook[i].getDepartment().equals(department)) {
                Array[employeeNumber] = EmployeesBook[i];
                employeeNumber++;
            }
        }
        Array = Arrays.copyOf(Array, employeeNumber);
        return Array;
    }

    public Employee[] getEmployeesWithSalaryUnder(double salary) {
        Employee[] Array = new Employee[EmployeesBook.length];
        int employeeNumber = 0;
        for (int i = 0; i < EmployeesBook.length; i++) {
            if (EmployeesBook[i] == null) continue;
            if (EmployeesBook[i].getSalary() > salary) {
                Array[employeeNumber] = EmployeesBook[i];
                employeeNumber++;
            }
        }
        Array = Arrays.copyOf(Array, employeeNumber);
        return Array;
    }

    public Employee[] getEmployeesWithSalaryBelow(double salary) {
        Employee[] Array = new Employee[EmployeesBook.length];
        int employeeNumber = 0;
        for (int i = 0; i < EmployeesBook.length; i++) {
            if (EmployeesBook[i] == null) continue;
            if (EmployeesBook[i].getSalary() < salary) {
                Array[employeeNumber] = EmployeesBook[i];
                employeeNumber++;
            }
        }
        Array = Arrays.copyOf(Array, employeeNumber);
        return Array;
    }

    public void addEmployee(Employee employee) {
        for (int i = 0; i < EmployeesBook.length; i++) {
            if (EmployeesBook[i] == null) {
                EmployeesBook[i] = employee;
                return;
            }
        }
    }

    public void deleteEmployee(String firstName, String middleName, String secondName) {
        for (int i = 0; i < EmployeesBook.length; i++) {
            if (EmployeesBook[i] == null) {
                continue;
            }
            if (EmployeesBook[i].getFirstName() == firstName &&
                    EmployeesBook[i].getMiddleName() == middleName &&
                    EmployeesBook[i].getSecondName() == secondName) {
                EmployeesBook[i] = null;
            }
        }
    }

    public void deleteEmployee(int employeeId) {
        for (int i = 0; i < EmployeesBook.length; i++) {
            if (EmployeesBook[i] == null) {
                continue;
            }
            if (EmployeesBook[i].getId() == employeeId) {
                EmployeesBook[i] = null;
            }
        }
    }

    public Employee getEmployee(String firstName, String middleName, String secondName) {
        for (int i = 0; i < EmployeesBook.length; i++) {
            if (EmployeesBook[i] == null) {
                continue;
            }
            if (EmployeesBook[i].getFirstName() == firstName &&
                    EmployeesBook[i].getMiddleName() == middleName &&
                    EmployeesBook[i].getSecondName() == secondName) {
                return EmployeesBook[i];
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
        String[] ArrayOfDepartments = new String[EmployeesBook.length];
        int employeeNumber = 0;
        for (int i = 0; i < EmployeesBook.length; i++) {
            if (EmployeesBook[i] == null) continue;
            ArrayOfDepartments[employeeNumber] = EmployeesBook[i].getDepartment();
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