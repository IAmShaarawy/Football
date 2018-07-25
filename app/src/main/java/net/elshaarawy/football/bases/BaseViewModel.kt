package net.elshaarawy.football.bases

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject

/**
 * Created by elshaarawy on 7/25/18.
 */
abstract class BaseViewModel<T> : ViewModel() {
    val listData: LiveData<List<T>> by lazy { MutableLiveData<List<T>>() }
    val loadingSubject: PublishSubject<Boolean> by lazy { PublishSubject.create<Boolean>() }
    protected val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    abstract fun loadData(): LiveData<List<T>>

    override fun onCleared() {
        super.onCleared()
        loadingSubject.onComplete()
        compositeDisposable.clear()
    }
}