import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        EmployeeBook employeesBook = new EmployeeBook(10);
        employeesBook.addEmployee(new Employee("Иван0", "Иванович", "Иванов", "1", 400009));
        employeesBook.addEmployee(new Employee("Иван1", "Иванович", "Иванов", "1", 400008));
        employeesBook.addEmployee(new Employee("Иван2", "Иванович", "Иванов", "2", 400007));
        employeesBook.addEmployee(new Employee("Иван3", "Иванович", "Иванов", "2", 400011));
        employeesBook.addEmployee(new Employee("Иван4", "Иванович", "Иванов", "1", 400012));
        employeesBook.addEmployee(new Employee("Иван5", "Иванович", "Иванов", "1", 400013));
        employeesBook.addEmployee(new Employee("Иван6", "Иванович", "Иванов", "1", 400001));
        employeesBook.addEmployee(new Employee("Иван7", "Иванович", "Иванов", "1", 400022));
        employeesBook.addEmployee(new Employee("Иван8", "Иванович", "Иванов", "1", 400023));
        employeesBook.addEmployee(new Employee("Иван9", "Иванович", "Иванов", "1", 400024));

        //////////////////////// first level of complexity ////////////////////////
        System.out.println("Complete data of employees:");
        employeesBook.printEmployeesData();
        System.out.println();

        System.out.println("Total salaries: " + employeesBook.calcTotalSalaries());
        System.out.println("Minimum salary: " + employeesBook.findEmplWithMinSalary());
        System.out.println("Maximum salary: " + employeesBook.findEmplWithMaxSalary());
        System.out.println("Average salary: " + employeesBook.calcAverageSalary());
        System.out.println();

        System.out.println("List of employees:");
        employeesBook.printAllEmployeesList();
        System.out.println();

        //////////////////////// second level of complexity ////////////////////////
        employeesBook.increaseAllEmplSalaries(10);
        System.out.println("Complete data of employees after salary increasing:");
        employeesBook.printEmployeesData();
        System.out.println();

        System.out.println("Minimum salary in department: " + employeesBook.findEmplWithMinSalary("2"));
        System.out.println("Maximum salary in department: " + employeesBook.findEmplWithMaxSalary("2"));
        System.out.println("Total salaries: " + employeesBook.calcTotalSalaries("2"));
        System.out.println("Average salary: " + employeesBook.calcAverageSalary("2"));
        System.out.println();

        Employee[] employeesList;
        employeesBook.increaseSalariesInDepartment("2", 10);
        System.out.println("Department 2. Data of employees after salary increasing:");
        employeesList = employeesBook.returnInDepartment("2");
        employeesBook.printWithoutDepartment(employeesList);
        System.out.println();

        System.out.println("Employees with salary under 450000:");
        employeesList = employeesBook.returnWithSalaryUnder(450000);
        employeesBook.printWithoutDepartment(employeesList);
        System.out.println();

        System.out.println("Employees with salary below 450000:");
        employeesList = employeesBook.returnWithSalaryBelow(450000);
        employeesBook.printWithoutDepartment(employeesList);
        System.out.println();


        //////////////////////// third level of complexity ////////////////////////
        System.out.println("Delete employee: Иван4 Иванович Иванов");
        employeesBook.deleteEmployee("Иван4", "Иванович", "Иванов");
        employeesBook.printEmployeesData();
        System.out.println();

        System.out.println("Delete employee: ID 8");
        employeesBook.deleteEmployee(8);
        employeesBook.printEmployeesData();
        System.out.println();

        System.out.println("Add employee: Иван10 Иванович Иванов");
        employeesBook.addEmployee(new Employee("Иван10", "Иванович", "Иванов", "1", 400024));
        employeesBook.printEmployeesData();
        System.out.println();

        System.out.println("Change employee account data\n" +
                "ID5 salary: 440014.3 to 111111.0 \n" +
                "ID6 department: 1 to 3 \n" +
                "ID7 salary and department: 440024.2 to 222222.0 and 1 to 5");
        Employee employee = employeesBook.returnEmployee("Иван5", "Иванович", "Иванов");
        employeesBook.changeEmployeeSalaryOrDepartment(employee, 111111, null);

        employee = employeesBook.returnEmployee("Иван6", "Иванович", "Иванов");
        employeesBook.changeEmployeeSalaryOrDepartment(employee, 0, "3");

        employee = employeesBook.returnEmployee("Иван7", "Иванович", "Иванов");
        employeesBook.changeEmployeeSalaryOrDepartment(employee, 222222, "5");
        employeesBook.printEmployeesData();
        System.out.println();

        System.out.println("Complete data of employees by department:");
        employeesBook.printSortedEmployees();
    }
}