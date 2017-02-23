package com.grayherring.kotlintest.ui.home

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.TextView
import com.grayherring.kotlintest.data.modul.Book
import org.jetbrains.anko.bottomPadding
import org.jetbrains.anko.dip
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.padding
import org.jetbrains.anko.textView
import org.jetbrains.anko.topPadding
import org.jetbrains.anko.verticalLayout
import org.jetbrains.anko.wrapContent

class Holder(val root: CardView) : RecyclerView.ViewHolder(root) {
  lateinit var author: TextView
  lateinit var title: TextView

  init {
    with(root) {
      layoutParams = LayoutParams(matchParent, wrapContent)
      padding = dip(8)
      useCompatPadding = true
      cardElevation = dip(6).toFloat()
      verticalLayout {
        lparams(width = matchParent)
        author = textView {
          textSize = 20f
          topPadding = dip(8)
          lparams(width = matchParent)
        }
        title = textView {
          textSize = 20f
          bottomPadding = dip(8)
          lparams(width = matchParent)
        }
      }
    }
  }

  fun bind(book: Book, update: () -> Unit) {
    author.text = book.author
    title.text = book.title
    root.setOnClickListener { update.invoke() }
  }
}

class BookAdapter(val homeVM: HomeVM) : RecyclerView.Adapter<Holder>() {


  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder? {
    val holder = Holder(CardView(parent.context))

    return holder
  }

  override fun onBindViewHolder(holder: Holder, position: Int) {
    holder.bind(homeVM.books[position], { homeVM.update(homeVM.books[position]) })
  }

  override fun getItemCount(): Int {
    return homeVM.books.size
  }

}


