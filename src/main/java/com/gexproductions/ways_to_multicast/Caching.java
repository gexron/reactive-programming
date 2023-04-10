package com.gexproductions.ways_to_multicast;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

//        Cache is an auto-connecting replay-everything container used typically for long-term replays.

public class Caching {
    public static void main(String[] args) throws InterruptedException {
        Observable<Long> src = Observable.interval(1, TimeUnit.SECONDS)
                        .cache();

        src.subscribe(e -> System.out.println("Observer 1: " + e));
        Thread.sleep(5000);

        src.subscribe(e -> System.out.println("Observer 2: " + e));
        Thread.sleep(3000);
    }
}
