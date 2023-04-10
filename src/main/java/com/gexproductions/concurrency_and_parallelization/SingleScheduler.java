package com.gexproductions.concurrency_and_parallelization;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SingleScheduler {
    public static void main(String[] args) throws InterruptedException {
        Observable<String> src = Observable.just("Origi", "Wijnaldum", "Wijnaldum", "Origi")
                .subscribeOn(Schedulers.single());
        src.subscribe(e -> sensitiveTask());
        src.subscribe(e -> sensitiveTask());
        src.subscribe(e -> sensitiveTask());
        src.subscribe(e -> sensitiveTask());
        src.subscribe(e -> sensitiveTask());
        src.subscribe(e -> sensitiveTask());

        Thread.sleep(30000);
    }

    public static void sensitiveTask() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Computation done by: " + Thread.currentThread().getName());
    }
}
