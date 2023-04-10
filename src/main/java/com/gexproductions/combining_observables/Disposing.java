package com.gexproductions.combining_observables;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class Disposing {
    public static void main(String[] args) throws InterruptedException {
        CompositeDisposable disp = new CompositeDisposable();
        Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS);
        Disposable d1 = source.subscribe(e -> System.out.println("Observer 1: " + e));
        Disposable d2 = source.subscribe(e -> System.out.println("Observer 2: " + e));
        Thread.sleep(5000);
        disp.addAll(d1,d2);
        disp.dispose();
        Thread.sleep(10000);
    }
}
