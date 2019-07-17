package com.tarkalabs.core.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<in V : BaseView, T : BasePresenter<V>> : AppCompatActivity(),
    BaseView {

    protected abstract var presenter: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(view = this as V)
    }

    override fun showError(error: String) {

    }

    override fun showError(stringResId: Int) {

    }

    override fun showMessage(srtResId: Int) {

    }

    override fun showMessage(message: String) {

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}