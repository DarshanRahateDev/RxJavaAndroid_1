package com.appdemo.rxjavaandroid1.example1

import com.appdemo.rxjavaandroid1.scheduler.SchedulerProvider
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observers.DisposableObserver

class RxJavaEx3(private val scheduler: SchedulerProvider) {
    val result = "Hello RxJava"
    lateinit var observable: Observable<String>
    private lateinit var disposableObserver: DisposableObserver<String>

    fun callRxFunctionality() {
        observable = Observable.just(result)
        observable.subscribeOn(scheduler.io())
        observable.observeOn(scheduler.ui())

        disposableObserver = object : DisposableObserver<String>() {
            override fun onNext(t: String) {
                println(":::== onNext : " + t)
            }

            override fun onError(e: Throwable) {
                println(":::== onError : " + e.message)
            }

            override fun onComplete() {
                println(":::== onComplete() : ")
            }
        }
        observable.subscribe(disposableObserver)
    }

    fun dispose() {
        disposableObserver.dispose()
    }
}