package com.grayherring.kotlintest.ui.update

import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import com.grayherring.kotlintest.R
import com.grayherring.kotlintest.ui.base.BaseActivity
import com.grayherring.kotlintest.ui.base.throttleClick
import com.jakewharton.rxbinding.widget.textChanges
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.button
import org.jetbrains.anko.dip
import org.jetbrains.anko.editText
import org.jetbrains.anko.enabled
import org.jetbrains.anko.frameLayout
import org.jetbrains.anko.progressBar
import org.jetbrains.anko.verticalLayout

class UpdateUI(val updateVM: UpdateVM) : AnkoComponent<BaseActivity> {
  lateinit var title: EditText
    private set
  lateinit var auther: EditText
    private set
  lateinit var publisher: EditText
    private set
  lateinit var categories: EditText
    private set
  lateinit var submitButton: Button
    private set
  lateinit var copyButton: Button
    private set
  lateinit var progressBar: ProgressBar
    private set

  override fun createView(ui: AnkoContext<BaseActivity>): View {
    val view = with(ui) {
      frameLayout {
        verticalLayout {
          title = editText(updateVM.book.title) {
            textChanges().subscribe { updateVM.book.title = it.toString() }
          }
          auther = editText(updateVM.book.author) {
            textChanges().subscribe { updateVM.book.author = it.toString() }
          }
          publisher = editText(updateVM.book.publisher) {
            textChanges().subscribe { updateVM.book.publisher = it.toString() }
          }
          categories = editText(updateVM.book.categories) {
            textChanges().subscribe { updateVM.book.categories = it.toString() }
          }
          submitButton = button {
            text = resources.getText(R.string.submit)
            throttleClick().subscribe({ updateVM.updateBooks() }, { updateVM.logError(it) })
          }
          copyButton = button {
            text = resources.getText(R.string.copy_book)
            throttleClick().subscribe({ updateVM.copyBook() }, { updateVM.logError(it) })
          }

        }
        progressBar = progressBar {
          lparams(width = dip(32),
                  height = dip(32),
                  gravity = Gravity.CENTER)
        }
      }
    }
    notifyChanges()
    return view
  }

  fun notifyChanges() {
    notifyLoading()
  }

  fun notifyLoading() {
    progressBar.visibility = if (updateVM.loading) View.VISIBLE else View.GONE
  }

  fun notifyLock() {
    submitButton.enabled = !updateVM.lock
    copyButton.enabled = !updateVM.lock
  }
}