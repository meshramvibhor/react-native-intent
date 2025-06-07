package com.intentextras

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.annotations.ReactModule
import android.app.Activity
import android.content.Intent
import com.facebook.react.bridge.WritableMap
import com.facebook.react.bridge.Arguments

@ReactModule(name = IntentExtrasModule.NAME)
class IntentExtrasModule(reactContext: ReactApplicationContext) :
  NativeIntentExtrasSpec(reactContext) {

  override fun getName(): String {
    return NAME
  }

  // Example method
  // See https://reactnative.dev/docs/native-modules-android
  override fun multiply(a: Double, b: Double): Double {
    return a * b
  }

  override fun getIntentExtras(): WritableMap {
    val activity = currentActivity
    val extras = Arguments.createMap()
    if (activity != null) {
      val intent = activity.intent
      val bundle = intent.extras
      if (bundle != null) {
        for (key in bundle.keySet()) {
          val value = bundle.get(key)
          extras.putString(key, value.toString())
        }
      }
    }
    return extras
  }

  companion object {
    const val NAME = "IntentExtras"
  }
}
