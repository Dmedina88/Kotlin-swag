package com.grayherring.kotlintest.ui.home

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.grayherring.kotlintest.R
import com.grayherring.kotlintest.databinding.ItemBookBinding

/**
 * Created by davidmedina on 2/10/17 =).
 */
class BookAdapter(val homeVM: HomeVM) : RecyclerView.Adapter<BookVH>() {
  override fun getItemCount(): Int {
    return homeVM.books.count()
  }

  override fun onBindViewHolder(holder: BookVH, position: Int) {
    val book = homeVM.books[position]
    holder.binding!!.book = book
    holder.binding!!.root.setOnClickListener { v -> homeVM.update(book) }

  }

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BookVH {
    val binding = DataBindingUtil.inflate<ItemBookBinding>(
        LayoutInflater.from(parent?.context),
        R.layout.item_book,
        parent,
        false
    )

    return BookVH(binding.root)
  }

}
class BookVH(itemView: View?) : RecyclerView.ViewHolder(itemView) {
  var binding: ItemBookBinding? = DataBindingUtil.bind(itemView)
}