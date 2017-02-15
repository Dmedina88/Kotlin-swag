package com.grayherring.kotlintest.ui.home

import com.grayherring.kotlintest.data.modul.Book

/**
 * Created by davidmedina on 2/10/17 =).
 */
interface HomeView {
  fun startEdit(book: Book)

  fun showError(error: String)

  fun showUpdates()

}
