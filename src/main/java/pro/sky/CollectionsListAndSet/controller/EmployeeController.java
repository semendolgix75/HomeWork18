package pro.sky.CollectionsListAndSet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.CollectionsListAndSet.doMain.Employee;
import pro.sky.CollectionsListAndSet.service.EmployeeService;

@RestController
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/employee/add")
    public String addEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName
    ) {
        Employee employee = new Employee(
                firstName,
                lastName);
        employeeService.addEmployee(employee);

        return employee.toString();

    }

    @GetMapping(path = "/employee/remove")
    public String removeEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName
    ) {
        Employee employee = new Employee(
                firstName,
                lastName);
        employeeService.removeEmployee(employee);
        return "Удален";

    }

}


