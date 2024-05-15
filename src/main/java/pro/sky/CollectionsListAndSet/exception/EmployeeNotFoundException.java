package pro.sky.CollectionsListAndSet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//### Шаг 6
//Написать собственное непроверяемое исключение EmployeeNotFoundException,
// которое выбрасывается, если сотрудник не найден.
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String message) {
        super(message);

            }
}
