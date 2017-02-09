package com.grayherring.kotlintest.ui.util

import android.content.Context
import android.os.Bundle
import com.grayherring.kotlintest.PREF_NAME
import com.grayherring.kotlintest.R
import com.grayherring.kotlintest.SwagApp
import com.grayherring.kotlintest.ui.base.BaseActivity
import com.grayherring.kotlintest.util.BoolPreferences
import com.jakewharton.processphoenix.ProcessPhoenix
import io.palaima.debugdrawer.actions.ActionsModule
import io.palaima.debugdrawer.actions.SwitchAction
import io.palaima.debugdrawer.commons.BuildModule
import io.palaima.debugdrawer.commons.DeviceModule
import io.palaima.debugdrawer.commons.NetworkModule
import io.palaima.debugdrawer.commons.SettingsModule
import io.palaima.debugdrawer.timber.TimberModule
import io.palaima.debugdrawer.view.DebugView
import timber.log.Timber


class DebugViewActivity : BaseActivity() {

  private lateinit var debugView: DebugView;

  override fun initializeDependencyInjector() {
    (this.application as SwagApp)
        .component
        .inject(this)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_debug_view)

    debugView = findViewById(R.id.debug_view) as DebugView

    //todo this triger on its own when  its true and restarts
    //todoissue injecting this as apref
    val mockPref = BoolPreferences(this.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE), "MockPref")
    val isMockMode = mockPref.isIt()
    Timber.d("isMockMode enabled -> %s", isMockMode)
    val mockSwitch = SwitchAction("Mock Mode: ",
        { value ->
          if (isMockMode != value) {
            mockPref.set(value)
            ProcessPhoenix.triggerRebirth(this@DebugViewActivity)
          }
        }, isMockMode
    )

    debugView.modules(
        ActionsModule(
            mockSwitch
        ),
        TimberModule(),
        BuildModule(this),
        DeviceModule(this),
        NetworkModule(this),
        SettingsModule(this)
    )
  }

  override protected fun onStart() {
    super.onStart()
    debugView.onStart()
  }

  override protected fun onResume() {
    super.onResume();
    debugView.onResume();
  }

  override protected fun onPause() {
    super.onPause()
    debugView.onPause()
  }

  override protected fun onStop() {
    super.onStop()
    debugView.onStop()
  }
}