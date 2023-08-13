package com.appdemo.rxjavaandroid1.example1

import android.util.Log
import com.appdemo.rxjavaandroid1.scheduler.SchedulerProvider
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.functions.Function
import io.reactivex.rxjava3.observers.DisposableObserver

class RxJavaEx7(private val schedulerProvider: SchedulerProvider) {

    lateinit var observable: Observable<Student>
    val compositeDisposable = CompositeDisposable()

    fun callRxFunctionality() {
        observable = Observable.create { emit ->
            getStudents().forEach {
                emit.onNext(it)
            }
            emit.onComplete()
        }.map(object : Function<Student, Student> {
            override fun apply(student: Student): Student {
                student.name = student.name.uppercase()
                return student
            }
        })
        compositeDisposable.add(
            observable.subscribeOn(schedulerProvider.io()).observeOn(schedulerProvider.ui())
                .subscribeWith(getObserver())
        )
    }

    fun getObserver() : DisposableObserver<Student> {
        return object : DisposableObserver<Student>() {
            override fun onNext(t: Student) {
                Log.d("RxJavaEx6", ":::== onNext() : ${t.name},  ${t.age},  ${t.email}")
            }

            override fun onError(e: Throwable) {
                Log.d("RxJavaEx6", ":::== onError() : ${e.message}")
            }

            override fun onComplete() {
                Log.d("RxJavaEx6", ":::== onComplete() ")
            }
        }
    }

    fun getStudents() : ArrayList<Student> {
        val arrayList = ArrayList<Student>()
        arrayList.add(Student("Name 1", "name1@gmail.com", 21))
        arrayList.add(Student("Name 2", "name2@gmail.com", 22))
        arrayList.add(Student("Name 3", "name3@gmail.com", 23))
        arrayList.add(Student("Name 4", "name4@gmail.com", 24))

        return arrayList
    }

    fun dispose() {
        compositeDisposable.clear()
    }
}