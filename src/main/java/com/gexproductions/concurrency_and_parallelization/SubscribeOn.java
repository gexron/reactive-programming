package com.gexproductions.concurrency_and_parallelization;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SubscribeOn {
    public static void main(String[] args) throws InterruptedException {

        Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
                .doOnNext(e -> System.out.println(e + ", " + Thread.currentThread().getName()))
                .subscribeOn(Schedulers.computation())
                .map(e -> e.toUpperCase())
                .subscribeOn(Schedulers.io())
                .doOnNext(e -> System.out.println(e + ", " + Thread.currentThread().getName()))
                .observeOn(Schedulers.newThread())
                .doOnNext(e -> System.out.println(e + ", " + Thread.currentThread().getName()))
                .doOnNext(e -> System.out.println("----"))
                .filter(e -> e.startsWith("P"))
                .observeOn(Schedulers.io())
                .subscribe(e -> print(e));

        Thread.sleep(20000);
    }

    public static void print(String element) throws InterruptedException {
        System.out.println( element + " Printed By: " + Thread.currentThread().getName());
        Thread.sleep(1000);
    }
}
