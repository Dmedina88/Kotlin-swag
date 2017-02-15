package com.grayherring.kotlintest.test

import com.grayherring.kotlintest.data.networking.SwagApi

/**
 * Created by davidmedina on 2/12/17 =).
 */

object ThisIsASinglton {
  lateinit private var swagApi: SwagApi
  fun initSingaton(swagApi: SwagApi) {
    this.swagApi = swagApi
  }
}