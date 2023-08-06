package com.appdemo.rxjavaandroid1.example1

import com.appdemo.rxjavaandroid1.scheduler.TestSchedulerProvider
import io.reactivex.rxjava3.schedulers.TestScheduler
import org.junit.Test

class RxJavaEx3Test {

    @Test
    fun callFunctionality() {
        val rxJavaEx3 = RxJavaEx3(TestSchedulerProvider(TestScheduler()))
        rxJavaEx3.callRxFunctionality()

        rxJavaEx3.observable.test()
            .assertResult(rxJavaEx3.result)
            .assertValueAt(0, rxJavaEx3.result)
            .assertValue(rxJavaEx3.result)
            .assertComplete()
    }
}