package com.gexproductions.combining_observables;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.List;

public class FlatMapConcatMap {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Hello", "Reactive", "Programming");

        Observable.fromIterable(list)
                .concatMap(e -> Observable.fromArray(e.split("")))
                .subscribe(System.out::println);
    }
}
