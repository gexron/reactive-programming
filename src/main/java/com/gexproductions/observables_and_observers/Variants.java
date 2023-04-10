package com.gexproductions.observables_and_observers;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class Variants {
    public static void main(String[] args) {
        //Single
        Observable<String> source1 = Observable.just("Origi", "Wijnaldum");
        source1.first("Name").subscribe(System.out::println);
        Single.just("Origi").subscribe(System.out::println);

        //Maybe
        Observable<String> source2 = Observable.empty();
        source2.firstElement().subscribe(System.out::println, e -> e.printStackTrace(), () -> System.out.println("--Completed--"));

        //Completable
        Completable completable = Completable.complete();
        completable.subscribe(() -> System.out.println("--Completed--"));
        Completable.fromRunnable(() -> System.out.println("Some process executing..."))
                .subscribe(() -> System.out.println("The process executed successfully."));
    }
}
