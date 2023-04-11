package com.gexproductions.buffering_throttling_switching;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Switching {
    public static void main(String[] args) throws InterruptedException {
        Observable<String> source = Observable.just("Bella", "Bo2loz", "Folla", "Bo2loz jr.", "Basbosa")
                .concatMap(e -> Observable.just(e).delay(
                        ThreadLocalRandom.current().nextInt(1000), TimeUnit.MILLISECONDS)
                );

        Observable.interval(3, TimeUnit.SECONDS)
                .switchMap(s -> source.doOnDispose(
                        () -> System.out.println("Disposing and restarting!"))
                )
                .subscribe(System.out::println);

        Thread.sleep(10000);
    }
}
