package com.gexproductions.concurrency_and_parallelization;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class NewThreadScheduler {
    public static void main(String[] args) throws InterruptedException {
        Observable<String> src = Observable.just("Origi", "Wijnaldum", "Wijnaldum", "Origi")
                .subscribeOn(Schedulers.newThread());
        src.subscribe(e -> task());

        Thread.sleep(5000);

        src.subscribe(e -> task());
        src.subscribe(e -> task());
        src.subscribe(e -> task());
        src.subscribe(e -> task());

        Thread.sleep(10000);
    }

    public static void task() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Computation done by: " + Thread.currentThread().getName());
    }
}
