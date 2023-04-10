package com.gexproductions.buffering_throttling_switching;

import io.reactivex.rxjava3.core.Observable;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

public class Buffering {
    public static void main(String[] args) throws InterruptedException {
//        Observable.range(1,30)
//                .buffer(4, 7)
//                .subscribe(System.out::println);

//        Observable.interval(500, TimeUnit.MILLISECONDS)
//                .buffer(1, TimeUnit.SECONDS,2)
//                .subscribe(System.out::println);

        Observable<Long> interval = Observable.interval(1, TimeUnit.SECONDS);

        Observable.interval(500, TimeUnit.MILLISECONDS)
                        .window(interval)
                                .subscribe(System.out::println);

        Thread.sleep(8000);
    }
}
