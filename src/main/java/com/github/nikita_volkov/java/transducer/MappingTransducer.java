package com.github.nikita_volkov.java.transducer;

import com.github.nikita_volkov.java.reducer.*;

import java.util.function.Function;

public final class MappingTransducer<a, b> implements Transducer<a, b> {

  private final Function<a, b> fn;

  public MappingTransducer(Function<a, b> fn) {
    this.fn = fn;
  }

  @Override
  public <output> Reducer<a, output> transduce(Reducer<b, output> finalReducer) {
    return new ContramappingReducer<>(finalReducer, fn);
  }

}
