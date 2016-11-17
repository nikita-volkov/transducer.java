package com.github.nikita_volkov.java.transducer;

import com.github.nikita_volkov.java.reducer.*;

public final class ReducingTransducer<a, b> implements Transducer<a, b> {

  private final Reducer<a, b> intermediateReducer;

  public ReducingTransducer(Reducer<a, b> intermediateReducer) {
    this.intermediateReducer = intermediateReducer;
  }

  @Override
  public <output> Reducer<a, output> transduce(Reducer<b, output> finalReducer) {
    return new ReducingReducer<>(intermediateReducer, finalReducer);
  }

}
