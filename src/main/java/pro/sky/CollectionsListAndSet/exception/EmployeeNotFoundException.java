package pro.sky.CollectionsListAndSet.exception;
//### Шаг 6
//Написать собственное непроверяемое исключение EmployeeNotFoundException,
// которое выбрасывается, если сотрудник не найден.

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String message) {
        super(message);
            }
}
