package com.grayherring.kotlintest.ui.util

import android.os.Bundle
import com.grayherring.kotlintest.R
import com.grayherring.kotlintest.SwagApp
import com.grayherring.kotlintest.ui.base.BaseActivity

class DebugViewActivity : BaseActivity() {
    override fun initializeDependencyInjector() {
        (this.application as SwagApp)
                .component
                .inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_debug_view)
    }

}