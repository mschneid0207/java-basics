package de.mschneid.javabasics;

import de.mschneid.javabasics.model.Employee;

import java.util.Arrays;
import java.util.List;

public class JavaBasicsLambda {

    public static void main (String[] args) {

        List<Employee> employees = Arrays.asList(new Employee("Max", 25),
                new Employee("Lukas", 30), new Employee("Nadine", 27));


        /*employees.sort((Employee e1, Employee e2) -> {
            return e1.getAge() - e2.getAge();
        });*/

        // shorter way
        employees.sort((e1, e2) -> e1.getAge() - e2.getAge());


        employees.forEach(x -> System.out.println(x.toString()));
    }

}
