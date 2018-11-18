package de.mschneid.javabasics;

import de.mschneid.javabasics.model.Employee;

import java.util.Optional;

public class JavaBasicsOptional {

    public static void main (String[] args) throws Exception {

        // create an empty optional
        Optional<Employee> employee = Optional.empty();

        // create an optional employee
        Optional<Employee> employeeOptional = Optional.of(new Employee("Max", 30));

        // create an optional with a value which may or may not be null
        Optional<Employee> employeeOptional1 = Optional.ofNullable(new Employee("Max", 20));

        if (employeeOptional.isPresent()) {
            System.out.println(employeeOptional.get().toString());
        }

        // returning default value using orElse()
        Employee employee1 = employeeOptional.orElse(null);
        System.out.println(employee1);

        // returning default value using orElseGet()
        Employee employee2 = employeeOptional.orElseGet(() -> {
            return new Employee("Max", 30);
        });

        // throw an exception on absence of a value
        employeeOptional.orElseThrow(() -> new Exception("message"));

        employeeOptional.filter(e -> e.getAge() > 25).ifPresent((e) -> {
            System.out.println("ifPresent: " + e.toString());
        });

        employeeOptional.map(Employee::getAge)
                .filter(age -> age > 25)
                .ifPresent(e -> {
                    System.out.println("Employee is " + e + " years old!");
                });

        // for cascading optionals use .flatMap()


    }
}
