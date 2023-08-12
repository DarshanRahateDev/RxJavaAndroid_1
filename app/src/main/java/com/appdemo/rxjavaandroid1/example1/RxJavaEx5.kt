package com.appdemo.rxjavaandroid1.example1

import com.appdemo.rxjavaandroid1.scheduler.SchedulerProvider
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableObserver

class RxJavaEx5(private val scheduler: SchedulerProvider) {
    lateinit var observable: Observable<String>
    private val compositeDisposable = CompositeDisposable()

    fun callRxFunctionality() {
        observable = Observable.just("Hello 1", "Hello 2", "Hello 3")

        compositeDisposable.add(
            observable
                .subscribeOn(scheduler.ui())
                .observeOn(scheduler.io())
                .subscribeWith(getObserver())
        )
    }

    private fun getObserver(): DisposableObserver<String> {
        return object : DisposableObserver<String>() {
            override fun onNext(t: String) {
                println(":::== onNext : " + t)
            }

            override fun onError(e: Throwable) {
                println(":::== onError : ")
            }

            override fun onComplete() {
                println(":::== onComplete : ")
            }
        }
    }

    fun dispose() {
        compositeDisposable.clear()
    }
}