package com.gexproductions.observables_and_observers;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.List;

public class CreatingObservable {
    public static void main(String[] args) {
        //Observable using create
        Observable<Integer> source = Observable.create(e -> {
            e.onNext(10);
            e.onNext(11);
            e.onNext(12);
            e.onComplete();
        });
        source.subscribe(System.out::println);

        //Observable using just
        Observable<Integer> just = Observable.just(1,2,3);
        just.subscribe(System.out::print);

        //Observable using fromIterable
        List<String> list = Arrays.asList("Gerrard", "Smicer", "Alonso");
        Observable<String> fromIterable = Observable.fromIterable(list);
        fromIterable.subscribe(System.out::println);
    }
}
