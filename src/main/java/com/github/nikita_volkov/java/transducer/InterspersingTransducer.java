package com.github.nikita_volkov.java.transducer;

import com.github.nikita_volkov.java.reducer.*;

public final class InterspersingTransducer<a> implements Transducer<a, a> {

  private final a separator;

  public InterspersingTransducer(a separator) {
    this.separator = separator;
  }

  @Override
  public <output> Reducer<a, output> transduce(Reducer<a, output> finalReducer) {
    return new InterspersingReducer<>(finalReducer, separator);
  }

}
