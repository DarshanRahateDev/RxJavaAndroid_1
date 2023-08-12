package com.appdemo.rxjavaandroid1.example1

import com.appdemo.rxjavaandroid1.scheduler.TestSchedulerProvider
import io.reactivex.rxjava3.schedulers.TestScheduler
import org.junit.Test

class RxJavaEx5Test {

    @Test
    fun test1() {
       val rxJavaEx5 = RxJavaEx5(TestSchedulerProvider(TestScheduler()))
        rxJavaEx5.callRxFunctionality()
        val observable = rxJavaEx5.observable.test()

        observable.assertValues("Hello 1", "Hello 2", "Hello 3")
        observable.assertValueAt(0, "Hello 1")
        observable.assertValueAt(1, "Hello 2")
        observable.assertValueAt(2, "Hello 3")
        observable.assertComplete()
    }
}