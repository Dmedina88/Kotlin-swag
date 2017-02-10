package com.grayherring.kotlintest.data.modul

import java.io.Serializable

/**
 * Created by David Medina.
 */
data class Book(var categories: String = "",
                var author: String = "",
                var lastCheckedOut: String = "",
                var id: Int = -1,
                var lastCheckedOutBy: String = "",
                var title: String = "",
                var publisher: String = "",
                var url: String = "/books/-1/") : Serializable






