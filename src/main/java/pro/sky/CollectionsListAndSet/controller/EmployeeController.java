package pro.sky.CollectionsListAndSet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.CollectionsListAndSet.service.EmployeeService;
//### Шаг 10
//Реализовать EmployeeController, который имеет поле EmployeeService.
//Объявить конструктор с этим параметром, чтобы заинджектить EmployeeService в EmployeeController.
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
//Объявить в контроллере 3 метода:
//


//1. По адресу /employee/add?firstName=Ivan&lastName=Ivanov должен вернуться объект Employee в формате JSON,
// т.е. { "firstName": "Ivan", "lastName": "Ivanov" }, или исключение ArrayIsFull в случае переполнения коллекции или EmployeeAlreadyAdded в случае, когда сотрудник уже существует.
    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName
    ) {
        return  employeeService.addEmployee(firstName,lastName);
    }
//2. По адресу /employee/remove?firstName=Ivan&lastName=Ivanov должен вернуться объект Employee в формате JSON,
// т.е. { "firstName": "Ivan", "lastName": "Ivanov" }, или исключение со статусом EmployeeNotFound, если сотрудник отсутствует.
    @GetMapping(path = "/remove")
    public String removeEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName
    ) {

        return employeeService.removeEmployee(firstName,lastName);

    }
//3. По адресу /employee/find?firstName=Ivan&lastName=Ivanov должен вернуться объект Employee в формате JSON,
// т.е. { "firstName": "Ivan", "lastName": "Ivanov" }, или исключение со статусом EmployeeNotFound, если такой сотрудник отсутствует.
    @GetMapping(path = "/find")
    public String findEmployee(@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName
    ) {

        return employeeService.findEmployee(firstName,lastName);
    }
    //### Шаг 12
//Написать метод, который выводит в браузер список всех сотрудников в формате JSON (необходимо вернуть объект списка).

    @GetMapping(path = "/")
    public String printEmployee() {
    return  employeeService.printEmployee();
}
}


