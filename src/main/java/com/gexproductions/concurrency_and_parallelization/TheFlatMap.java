package com.gexproductions.concurrency_and_parallelization;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.time.LocalDateTime;

public class TheFlatMap {
    public static void main(String[] args) throws InterruptedException {
        Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
                .flatMap(e -> Observable.just(e))
                .subscribeOn(Schedulers.computation())
                .map(e -> compute(e))
                .subscribe(System.out::println);

        Thread.sleep(4000);
    }

    public static String compute(String element) throws InterruptedException {
        return element + ": Printed By: " + Thread.currentThread().getName() + " at : " + LocalDateTime.now();
    }
}
