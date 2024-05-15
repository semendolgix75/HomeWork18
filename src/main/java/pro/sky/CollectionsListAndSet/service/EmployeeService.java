package pro.sky.CollectionsListAndSet.service;

public interface EmployeeService {


    String addEmployee(String firstName, String lastName);

    String removeEmployee(String firstName, String lastName);

    String findEmployee(String firstName, String lastName);

    String printEmployee();
}
