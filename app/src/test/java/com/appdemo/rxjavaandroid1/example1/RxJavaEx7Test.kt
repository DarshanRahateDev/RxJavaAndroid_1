package com.appdemo.rxjavaandroid1.example1

import com.appdemo.rxjavaandroid1.scheduler.TestSchedulerProvider
import io.reactivex.rxjava3.schedulers.TestScheduler
import org.junit.Test

class RxJavaEx7Test {

    @Test
    fun `test for map operator`() {
        val rxJavaEx7 = RxJavaEx7(TestSchedulerProvider(TestScheduler()))

        val arryList = rxJavaEx7.getStudents()
        val student1 = arryList.get(0)
        student1.name = student1.name.uppercase()
        val student2 = arryList.get(1)
        student2.name = student2.name.uppercase()
        val student3 = arryList.get(2)
        student3.name = student3.name.uppercase()
        val student4 = arryList.get(3)
        student4.name = student4.name.uppercase()

        rxJavaEx7.callRxFunctionality()

        val observable = rxJavaEx7.observable.test()

        observable.values().forEach {
            println(":::== Student : " + it)
        }

        observable.assertValueAt(0, student1)
        observable.assertValueAt(1, student2)
        observable.assertValueAt(2, student3)
        observable.assertValueAt(3, student4)

        observable.assertValues(student1 , student2 , student3 , student4)
        observable.assertComplete()
    }
}