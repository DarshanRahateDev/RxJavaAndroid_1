package com.appdemo.rxjavaandroid1.example1

import com.appdemo.rxjavaandroid1.scheduler.TestSchedulerProvider
import io.reactivex.rxjava3.schedulers.TestScheduler
import org.junit.Test

class RxJavaEx2Test {

    @Test
    fun test1() {
        val rxJavaEx2 = RxJavaEx2(TestSchedulerProvider(TestScheduler()))

        rxJavaEx2.callRxFunctionality()

        rxJavaEx2.observable.test()
            .assertResult(rxJavaEx2.result)
            .assertValueAt(0, rxJavaEx2.result)
            .assertValue(rxJavaEx2.result)
            .assertComplete()
    }
}