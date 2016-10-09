package com.github.nikita_volkov.java.transducers;

import com.github.nikita_volkov.java.iterations.*;

import java.util.function.Function;

public final class FlatmappingTransducer<a, b> implements Transducer<a, b> {

  private final Function<a, Iterable<b>> fn;

  public FlatmappingTransducer(Function<a, Iterable<b>> fn) {
    this.fn = fn;
  }

  @Override
  public <output> Iteration<a, output> transduce(Iteration<b, output> initialIteration) {
    return new ContraflatmapIteration<>(initialIteration, fn);
  }

}