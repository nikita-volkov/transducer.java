package com.github.nikita_volkov.java.transducer;

import com.github.nikita_volkov.java.iterations.*;

import java.util.function.Predicate;

public final class FilteringTransducer<a> implements Transducer<a, a> {

  private final Predicate<a> predicate;

  public FilteringTransducer(Predicate<a> predicate) {
    this.predicate = predicate;
  }

  @Override
  public <output> Iteration<a, output> transduce(Iteration<a, output> finalIteration) {
    return new FilteringIteration<>(finalIteration, predicate);
  }

}
