package com.tarkalabs.core.base

interface BasePresenter<in V : BaseView> {

  fun attachView(view: V)

  fun detachView()
}