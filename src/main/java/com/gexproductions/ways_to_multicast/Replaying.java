package com.gexproductions.ways_to_multicast;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

//        Replay can have more parametrization and can do bounded time/size replays but requires
//        the developer to specify when to start.

public class Replaying {
    public static void main(String[] args) throws InterruptedException {
        Observable<Long> src = Observable.interval(1, TimeUnit.SECONDS)
                .replay(2)
                .autoConnect();

        src.subscribe(e -> System.out.println("Observer 1: " + e));
        Thread.sleep(5000);

        src.subscribe(e -> System.out.println("Observer 2: " + e));
        Thread.sleep(3000);
    }
}
