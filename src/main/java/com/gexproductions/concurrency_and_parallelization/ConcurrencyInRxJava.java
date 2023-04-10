package com.gexproductions.concurrency_and_parallelization;

import io.reactivex.rxjava3.core.Observable;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ConcurrencyInRxJava {
    public static void main(String[] args) {
        LocalDateTime time1 = LocalDateTime.now();

        Observable<String> source = Observable.create(e -> new Thread( () -> {
            e.onNext("Hello");
            e.onNext("RxJava!");
        }).start());
        source.subscribe(e -> System.out.println("Observer 1: " + e + ", Thread: " +Thread.currentThread().getName()));
        source.subscribe(e -> System.out.println("Observer 2: " + e + ", Thread: " +Thread.currentThread().getName()));

        LocalDateTime time2 = LocalDateTime.now();
        double diff = (double) ChronoUnit.NANOS.between(time1, time2) / 1_000_000_000;
        System.out.println("Execution time: " + diff + " seconds");
    }
}
