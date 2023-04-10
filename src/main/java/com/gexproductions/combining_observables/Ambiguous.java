package com.gexproductions.combining_observables;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Ambiguous {
    public static void main(String[] args) throws InterruptedException {
        Observable<String> ob1 = Observable.interval(1, TimeUnit.SECONDS).take(11)
                .map(e -> "Observable 1: " + e);
        Observable<String> ob2 = Observable.interval(994, TimeUnit.MILLISECONDS).take(10)
                .map(e -> "Observable 2: " + e);

        Observable.amb(Arrays.asList(ob1, ob2))
                .subscribe(System.out::println);
        Thread.sleep(11000);

    }
}
