package com.grayherring.kotlintest.test;

import timber.log.Timber;

public class javaTest {

  javaTest() {
    Test test = new Test("adsa", "asd", "asd");

    Timber.d(Test.THIS_IS_FROM_A_COMPANION);
    Timber.d(TestKt.IMAGE_PATH);
    Timber.d(Test.THIS_IS_FROM_A_COMPANION_ALSO_VAL);
    Timber.d(Test.THIS_IS_FROM_A_COMPANION_ALSO_VAR);
  }
}
