package com.grayherring.kotlintest.test

import timber.log.Timber
import java.util.ArrayList
import kotlin.properties.Delegates
import kotlin.reflect.KProperty


const val IMAGE_PATH: String = "some_url"
@JvmField var IMAGE_PATH_2: String = "some_url"
@JvmField val IMAGE_PATH_3: String = "some_url"

fun doOtherThing(int: Int) = int.toString().count()
open class Test(var mutable: String, val immutable: String, constructorParameter: String) {
  companion object {
    const val THIS_IS_FROM_A_COMPANION = "companion object"
    @JvmField var THIS_IS_FROM_A_COMPANION_ALSO_VAR = "companion object"
    @JvmField val THIS_IS_FROM_A_COMPANION_ALSO_VAL = "companion object"
  }

  var allCaps = constructorParameter.toUpperCase()
  var someString: String? = null
    private set

  val doOtherOtherThing: (Int) -> Int = { doOtherThing(it) + 4 }
  val doThing: (Int) -> Int = { it * 2 }
  val newInt = hiOrder(2, doThing)
  val otherInt = hiOrder(212314, ::doOtherThing)
  val otherOtherInt: Int  by lazy { 42 }

  val max = if (otherInt > otherOtherInt) {
    Timber.i(otherInt.toString())
    otherInt
  } else {
    Timber.i(otherOtherInt.toString())
    otherOtherInt
  }

  val length = someString?.length ?: -1
  var myListString = asStrangeList(3, "David", "hello")
  var myListNumber = asStrangeNumberList(4, 2, 5, 4L, 44, 6)

  fun <T> asStrangeList(count: Int, vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (i in 0..count) {
      result.addAll(ts.asList())
    }
    return result
  }

  fun <T : Number> asStrangeNumberList(int: Int, vararg ts: T): List<Long> {
    val result = (0..ts.lastIndex).map {
      (ts[it].toLong() * it) + (ts[it].toLong() * int)
    }
    return result
  }

  fun hiOrder(int: Int, myFun: (someInt: Int) -> Int): Int {
    return myFun.invoke(int + 2)
  }

  val lazyInt: Int  by lazy { (0..999999).sum() }

  var StringObservable: String  by Delegates.observable("") { prop, old, new ->
    if (old != new) {
      print("I observed a change")
    }
  }

  var deledateMe: String by Delegate("Test")

  class Delegate(initValue: String) {
    var value = initValue
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {

      return "$thisRef, thank you for delegating '${property.name}' to me val = $value !"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
      this.value = value
      println("$value has been assigned to '${property.name} in $thisRef.'")
    }
  }

}

