package com.grayherring.kotlintest.dagger;

import java.lang.annotation.Retention;
import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

public final class Qualifiers {

  private Qualifiers() {
    throw new AssertionError("No instances.");
  }

  @Qualifier @Retention(RUNTIME) public @interface API {
  }

  @Qualifier @Retention(RUNTIME) public @interface MockPref {
  }

  @Qualifier @Retention(RUNTIME) public @interface BookRelay {
  }
}
