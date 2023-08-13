package com.appdemo.rxjavaandroid1.example1

import com.appdemo.rxjavaandroid1.scheduler.TestSchedulerProvider
import io.reactivex.rxjava3.schedulers.TestScheduler
import org.junit.Test

class RxJavaEx6Test {

    @Test
    fun `test for create`() {
        val rxJavaEx6 = RxJavaEx6(TestSchedulerProvider(TestScheduler()))
        rxJavaEx6.callRxFunctionality()

        val observable = rxJavaEx6.observable.test()

        observable.assertValueAt(0, rxJavaEx6.getStudents().get(0))
        observable.assertValueAt(1, rxJavaEx6.getStudents().get(1))
        observable.assertValueAt(2, rxJavaEx6.getStudents().get(2))
        observable.assertValueAt(3, rxJavaEx6.getStudents().get(3))

        observable.assertComplete()
    }
}