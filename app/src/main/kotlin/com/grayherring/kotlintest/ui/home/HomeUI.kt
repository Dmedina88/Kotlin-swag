package com.grayherring.kotlintest.ui.home

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.View.GONE
import android.view.View.OVER_SCROLL_NEVER
import android.view.View.VISIBLE
import android.widget.ProgressBar
import com.grayherring.kotlintest.R
import com.grayherring.kotlintest.util.ErrorHandler
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.design.floatingActionButton
import org.jetbrains.anko.dip
import org.jetbrains.anko.frameLayout
import org.jetbrains.anko.onClick
import org.jetbrains.anko.progressBar
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.verticalLayout
import rx.lang.kotlin.onError
import rx.lang.kotlin.toSingletonObservable


class HomeUI(val homeVM: HomeVM) : AnkoComponent<HomeActivity> {
  lateinit var recyclerView: RecyclerView
  lateinit var progressBar: ProgressBar
  lateinit private var adapter: BookAdapter

  override fun createView(ui: AnkoContext<HomeActivity>): View {
    val homeView = with(ui) {
      frameLayout {
        verticalLayout {
          recyclerView = recyclerView {
            val orientation = LinearLayoutManager.VERTICAL
            layoutManager = LinearLayoutManager(context, orientation, true)
            overScrollMode = OVER_SCROLL_NEVER
            this@HomeUI.adapter = BookAdapter(homeVM)
            adapter = BookAdapter(homeVM)
          }
          floatingActionButton(R.drawable.dd_ic_battery_unknown_white_24dp) {
            onClick { homeVM.newBook() }
          }
        }
        progressBar = progressBar {
          visibility = GONE
          lparams(width = dip(32),
                  height = dip(32),
                  gravity = Gravity.CENTER)
        }
      }
    }

    return homeView

  }

  fun update() {
    homeVM.loading.toSingletonObservable()
        .onError { ErrorHandler.logError(it) }
        .subscribe {
          progressBar.visibility = if (it) VISIBLE else GONE
        }
  }
}