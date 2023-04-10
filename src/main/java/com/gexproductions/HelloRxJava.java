package com.gexproductions;

import io.reactivex.rxjava3.core.Observable;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class HelloRxJava {
    public static void main(String[] args) {
        LocalDateTime time1 = LocalDateTime.now();

        Observable<String> source = Observable.create(e -> {
            e.onNext("Hello");
            e.onNext("RxJava!");
        });
        source.subscribe(e -> System.out.println("Observer 1: " + e + ", Thread: " +Thread.currentThread().getName()));
        source.subscribe(e -> System.out.println("Observer 2: " + e + ", Thread: " +Thread.currentThread().getName()));

        LocalDateTime time2 = LocalDateTime.now();
        double diff = (double) ChronoUnit.NANOS.between(time1, time2) / 1_000_000_000;
        System.out.println("Execution time: " + diff + " seconds");
    }
}