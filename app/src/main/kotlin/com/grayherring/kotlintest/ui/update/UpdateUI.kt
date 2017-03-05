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
import org.jetbrains.anko.design.textInputLayout
import org.jetbrains.anko.dip
import org.jetbrains.anko.editText
import org.jetbrains.anko.enabled
import org.jetbrains.anko.frameLayout
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.padding
import org.jetbrains.anko.progressBar
import org.jetbrains.anko.verticalLayout
import org.jetbrains.anko.wrapContent

interface IUpdateUI {
  fun
      notifyChanges(){
    notifyLoading()
    notifyLock()
  }
  fun notifyLoading()
  fun notifyLock()
}

class UpdateUI(val updateVM: UpdateVM) : AnkoComponent<BaseActivity>, IUpdateUI {
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
        lparams(width = matchParent, height = matchParent) {
          padding = resources.getDimensionPixelSize(R.dimen.spacing_small)
        }
        verticalLayout {
          lparams(width = matchParent, height = matchParent)
          textInputLayout {
            title = editText(updateVM.book.title) {
              lparams(width = matchParent, height = wrapContent)
              textChanges().subscribe { updateVM.book.title = it.toString() }
            }
            hint = "title"
          }
          auther = editText(updateVM.book.author) {
            lparams(width = matchParent, height = wrapContent)
            textChanges().subscribe { updateVM.book.author = it.toString() }
          }
          publisher = editText(updateVM.book.publisher) {
            lparams(width = matchParent, height = wrapContent)
            textChanges().subscribe { updateVM.book.publisher = it.toString() }
          }
          categories = editText(updateVM.book.categories) {
            lparams(width = matchParent, height = wrapContent)
            textChanges().subscribe { updateVM.book.categories = it.toString() }
          }
          submitButton = button {
            lparams(width = matchParent, height = wrapContent)
            text = resources.getText(R.string.submit)
            throttleClick().subscribe({ updateVM.updateBooks() }, { updateVM.logError(it) })
          }
          copyButton = button {
            lparams(width = matchParent, height = wrapContent)
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


  override fun notifyLoading() {
    progressBar.visibility = if (updateVM.loading) View.VISIBLE else View.GONE
  }

  override fun notifyLock() {
    submitButton.enabled = !updateVM.lock
    copyButton.enabled = !updateVM.lock
  }
}
