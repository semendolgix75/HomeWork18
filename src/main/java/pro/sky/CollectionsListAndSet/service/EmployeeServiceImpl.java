package pro.sky.CollectionsListAndSet.service;
//### Шаг 4
//
//Создать сервис EmployeeService, который хранит внутри поле с коллекцией сотрудников и
// константу хранящее максимальное возможное количество сотрудников в фирме.

import org.springframework.stereotype.Service;
import pro.sky.CollectionsListAndSet.doMain.Employee;
import pro.sky.CollectionsListAndSet.exception.EmployeeAlreadyAddedException;
import pro.sky.CollectionsListAndSet.exception.EmployeeNotFoundException;
import pro.sky.CollectionsListAndSet.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Sergey", "Sergeev"),
            new Employee("Petr", "Petrov"),
            new Employee("Ivan", "Ivanov")

    ));
    private final static int LIMIT_NUMBER_EMPLOYEE = 5;
//### Шаг 5
//Реализовать в сервисе три метода, которые принимают в качестве параметров firstName и lastName:
//1. Добавить сотрудника.
//2. Удалить сотрудника.
//3. Найти сотрудника.

    public String addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        //В метод с добавлением сотрудника нужно добавить выброс исключения из шага 7 в ситуации,
        // когда коллекция переполнена.
        if (employees.size() >= LIMIT_NUMBER_EMPLOYEE) {
            throw new EmployeeStorageIsFullException("Превышен лимит количества сотрудников в фирме");

        }
        //В метод с добавлением сотрудника нужно добавить выброс исключения из шага 8 в ситуации,
        // когда добавляемый сотрудник уже имеется в коллекции.
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("В коллекции уже есть такой сотрудник");
        }

        employees.add(employee);
        return employee.toString();

    }

    public String removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        //В метод с удалением сотрудника нужно добавить выброс исключения из шага 6 в ситуации,
        // когда удаляемый сотрудник не найден.
        if (!employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("удаляемый сотрудник не найден");
        } else {
            employees.remove(employee);

        }

        return employee.toString();
    }

    public String findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
//    В метод с поиском сотрудника нужно добавить выброс исключения из шага 6 в ситуации, когда сотрудник не найден.
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("сотрудник не найден");
        }
        return employee.toString();
    }

    public String printEmployee() {
        return employees.toString();

    }

}

