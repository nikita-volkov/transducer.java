package com.github.nikita_volkov.java.transducer;

import com.github.nikita_volkov.java.reducer.*;

import java.util.function.Predicate;

public final class FilteringTransducer<a> implements Transducer<a, a> {

  private final Predicate<a> predicate;

  public FilteringTransducer(Predicate<a> predicate) {
    this.predicate = predicate;
  }

  @Override
  public <output> Reducer<a, output> transduce(Reducer<a, output> finalReducer) {
    return new FilteringReducer<>(finalReducer, predicate);
  }

}
