import java.sql.SQLOutput;
import java.util.Arrays;

public class EmployeeBook {
    private Employee[] EmployeesBook;

    public EmployeeBook(int numberEmployees) {
        EmployeesBook = new Employee[numberEmployees];
    }

    /////////////////////// first level of complexity - methods ////////////////////////
    public void printEmployeesData() {
        for (int id = 0; id < EmployeesBook.length; id++) {
            System.out.println(EmployeesBook[id]);
        }
    }

    public double calcTotalSalaries() {
        double totalSalary = 0;
        for (int id = 0; id < EmployeesBook.length; id++) {
            totalSalary += EmployeesBook[id].getSalary();
        }
        return totalSalary;
    }

    public Employee findEmplWithMinSalary() {
        double minSalary = EmployeesBook[0].getSalary();
        int employeeId = 0;
        for (int id = 0; id < EmployeesBook.length; id++) {
            if (minSalary > EmployeesBook[id].getSalary()) {
                minSalary = EmployeesBook[id].getSalary();
                employeeId = id;
            }
        }
        return EmployeesBook[employeeId];
    }

    public Employee findEmplWithMaxSalary() {
        double maxSalary = EmployeesBook[0].getSalary();
        int employeeId = 0;
        for (int id = 0; id < EmployeesBook.length; id++) {
            if (maxSalary < EmployeesBook[id].getSalary()) {
                maxSalary = EmployeesBook[id].getSalary();
                employeeId = id;
            }
        }
        return EmployeesBook[employeeId];
    }

    public double calcAverageSalary() {
        double totalSalary = 0;
        for (int id = 0; id < EmployeesBook.length; id++) {
            totalSalary += EmployeesBook[id].getSalary();
        }
        return totalSalary / EmployeesBook.length;
    }

    public void printAllEmployeesList() {
        for (int id = 0; id < EmployeesBook.length; id++) {
            System.out.println(
                    EmployeesBook[id].getFirstName() + " " +
                            EmployeesBook[id].getMiddleName() + " " +
                            EmployeesBook[id].getSecondName());
        }
    }

    /////////////////////// second level of complexity - methods ////////////////////////
    public void increaseAllEmplSalaries(int factor) {
        for (int id = 0; id < EmployeesBook.length; id++) {
            EmployeesBook[id].setSalary(EmployeesBook[id].getSalary() * (factor + 100) / 100);
        }
    }

    public Employee findEmplWithMinSalary(String department) {
        double minSalary = EmployeesBook[0].getSalary();
        int employeeId = 0;
        for (int id = 0; id < EmployeesBook.length; id++) {
            if (EmployeesBook[id].getDepartment().equals(department) && minSalary > EmployeesBook[id].getSalary()) {
                minSalary = EmployeesBook[id].getSalary();
                employeeId = id;
            }
        }
        return EmployeesBook[employeeId];
    }

    public Employee findEmplWithMaxSalary(String department) {
        double maxSalary = EmployeesBook[0].getSalary();
        int employeeId = 0;
        for (int id = 0; id < EmployeesBook.length; id++) {
            if (EmployeesBook[id].getDepartment().equals(department) && maxSalary < EmployeesBook[id].getSalary()) {
                maxSalary = EmployeesBook[id].getSalary();
                employeeId = id;
            }
        }
        return EmployeesBook[employeeId];
    }

    public double calcTotalSalaries(String department) {
        double totalSalary = 0;
        for (int id = 0; id < EmployeesBook.length; id++) {
            if (EmployeesBook[id].getDepartment().equals(department)) {
                totalSalary += EmployeesBook[id].getSalary();
            }
        }
        return totalSalary;
    }

    public double calcAverageSalary(String department) {
        double totalSalary = 0;
        int numberEmployeesInDepartment = 0;
        for (int id = 0; id < EmployeesBook.length; id++) {
            if (EmployeesBook[id].getDepartment().equals(department)) {
                totalSalary += EmployeesBook[id].getSalary();
                numberEmployeesInDepartment++;
            }
        }
        return totalSalary / numberEmployeesInDepartment;
    }

    public void increaseSalariesInDepartment(String department, int factor) {
        for (int id = 0; id < EmployeesBook.length; id++) {
            if (EmployeesBook[id].getDepartment().equals(department)) {
                EmployeesBook[id].setSalary(EmployeesBook[id].getSalary() * (factor + 100) / 100);
            }
        }
    }

    public Employee[] returnInDepartment(String department) {
        Employee[] Array = new Employee[EmployeesBook.length];
        int employeeNumber = 0;
        for (int i = 0; i < EmployeesBook.length; i++) {
            if (EmployeesBook[i] == null) continue;
            if (EmployeesBook[i].getDepartment().equals(department)){
                Array[employeeNumber] = EmployeesBook[i];
                employeeNumber++;
            }
        }
        Array = Arrays.copyOf(Array, employeeNumber);
        return Array;
    }

    public Employee[] returnWithSalaryUnder(double salary) {
        Employee[] Array = new Employee[EmployeesBook.length];
        int employeeNumber = 0;
        for (int i = 0; i < EmployeesBook.length; i++) {
            if (EmployeesBook[i] == null) continue;
            if (EmployeesBook[i].getSalary() > salary){
            Array[employeeNumber] = EmployeesBook[i];
            employeeNumber++;
            }
        }
        Array = Arrays.copyOf(Array, employeeNumber);
        return Array;
    }

    public Employee[] returnWithSalaryBelow(double salary) {
        Employee[] Array = new Employee[EmployeesBook.length];
        int employeeNumber = 0;
        for (int i = 0; i < EmployeesBook.length; i++) {
            if (EmployeesBook[i] == null) continue;
            if (EmployeesBook[i].getSalary() < salary){
                Array[employeeNumber] = EmployeesBook[i];
                employeeNumber++;
            }
        }
        Array = Arrays.copyOf(Array, employeeNumber);
        return Array;
    }

    public void printWithoutDepartment(Employee[] employees) {
        for (int id = 0; id < employees.length; id++) {
            System.out.println(
                    employees[id].getId() + " " +
                            employees[id].getFirstName() + " " +
                            employees[id].getMiddleName() + " " +
                            employees[id].getSecondName() + " " +
                            employees[id].getSalary());
        }
    }
    /////////////////////// third level of complexity - methods ////////////////////////

    public void addEmployee(Employee employee) {
        for (int id = 0; id < EmployeesBook.length; id++) {
            if (EmployeesBook[id] == null) {
                EmployeesBook[id] = employee;
                return;
            }
        }
    }

    public void deleteEmployee(String firstName, String middleName, String secondName) {
        for (int id = 0; id < EmployeesBook.length; id++) {
            if (EmployeesBook[id] == null) {
                continue;
            }
            if (EmployeesBook[id].getFirstName() == firstName &&
                    EmployeesBook[id].getMiddleName() == middleName &&
                    EmployeesBook[id].getSecondName() == secondName) {
                EmployeesBook[id] = null;
            }
        }
    }

    public void deleteEmployee(int employeeId) {
        for (int id = 0; id < EmployeesBook.length; id++) {
            if (EmployeesBook[id] == null) {
                continue;
            }
            if (EmployeesBook[id].getId() == employeeId) {
                EmployeesBook[id] = null;
            }
        }
    }

    public Employee returnEmployee(String firstName, String middleName, String secondName) {
        for (int id = 0; id < EmployeesBook.length; id++) {
            if (EmployeesBook[id] == null) {
                continue;
            }
            if (EmployeesBook[id].getFirstName() == firstName &&
                    EmployeesBook[id].getMiddleName() == middleName &&
                    EmployeesBook[id].getSecondName() == secondName) {
                return EmployeesBook[id];
            }
        }
        return null;
    }

    public void changeEmployeeSalaryOrDepartment(Employee employee, double salary, String department) {
        if (salary != 0) {
            employee.setSalary(salary);
        }
        if (department != null) {
            employee.setDepartment(department);
        }
    }

    public void printSortedEmployees() {
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
