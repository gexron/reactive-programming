package com.gexproductions.combining_observables;

import io.reactivex.rxjava3.core.Observable;

class Employee {
    private final Integer id;
    private final String name;
    private final Integer salary;
    private final Double rating;

    public Employee(Integer id, String name, Integer salary, Double rating) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getSalary() {
        return salary;
    }

    public Double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", rating=" + rating +
                '}';
    }
}

public class Grouping {
    public static void main(String[] args) {
        Observable<Employee> obs = Observable.just(
                new Employee(101, "Alexa", 60000, 4.0),
                new Employee(123, "Dhwanit", 94008, 4.7),
                new Employee(236, "Mike", 65000, 4.0),
                new Employee(155, "Ella", 85000, 4.4),
                new Employee(443, "George", 50000, 3.6),
                new Employee(127, "Shreeja", 85000, 4.5),
                new Employee(589, "Daniel", 60000, 4.0),
                new Employee(344, "Lucy", 94000, 4.7),
                new Employee(509, "Harry", 75808, 4.3),
                new Employee(344, "Emma", 55080, 3.7)
        );

        obs.groupBy(e -> e.getRating())
                .flatMapSingle(e -> e.toMultimap(key -> e.getKey(), emp -> emp.getName()))
                .subscribe(System.out::println);
        System.out.println();
        obs.groupBy(e -> e.getRating())
                .flatMapSingle(e -> e.toList())
                .subscribe(System.out::println);
    }
}
