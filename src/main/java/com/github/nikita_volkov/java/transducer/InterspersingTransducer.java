package com.github.nikita_volkov.java.transducer;

import com.github.nikita_volkov.java.iterations.*;

public final class InterspersingTransducer<a> implements Transducer<a, a> {

  private final a separator;

  public InterspersingTransducer(a separator) {
    this.separator = separator;
  }

  @Override
  public <output> Iteration<a, output> transduce(Iteration<a, output> finalIteration) {
    return new IntersperseIteration<a, output>(finalIteration, separator);
  }

}
