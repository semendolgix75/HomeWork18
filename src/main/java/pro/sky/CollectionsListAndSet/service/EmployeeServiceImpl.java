package pro.sky.CollectionsListAndSet.service;
//### Шаг 4
//
//Создать сервис EmployeeService, который хранит внутри поле с коллекцией сотрудников и
// константу хранящее максимальное возможное количество сотрудников в фирме.
import org.springframework.stereotype.Service;
import pro.sky.CollectionsListAndSet.doMain.Employee;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Sergey", "Sergeev"),
            new Employee("Petr", "Petrov"),
            new Employee("Ivan", "Ivanovv")

    ));
    private final static int LIMIT_NUMBER_EMPLOYEE = 10;


    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println(employees.toString());
    }
    public void removeEmployee(Employee employee)
    {
        employees.remove(employee);
    }
}

