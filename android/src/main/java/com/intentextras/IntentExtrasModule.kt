package com.intentextras

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.annotations.ReactModule
import android.app.Activity
import android.content.Intent
import com.facebook.react.bridge.WritableMap
import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.WritableArray

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

  override fun getIntentData(): WritableMap {
    val activity = currentActivity
    val result = Arguments.createMap()
    
    if (activity != null) {
      val intent = activity.intent
      
      // Get action
      result.putString("action", intent.action)
      
      // Get data
      val data = intent.data
      result.putString("data", data?.toString())
      
      // Get type
      result.putString("type", intent.type)
      
      // Get categories
      val categories = Arguments.createArray()
      intent.categories?.forEach { category ->
        categories.pushString(category)
      }
      result.putArray("categories", categories)
      
      // Get extras
      val extras = Arguments.createMap()
      intent.extras?.let { bundle ->
        for (key in bundle.keySet()) {
          val value = bundle.get(key)
          extras.putString(key, value.toString())
        }
      }
      result.putMap("extras", extras)
    }
    
    return result
  }

  companion object {
    const val NAME = "IntentExtras"
  }
}
