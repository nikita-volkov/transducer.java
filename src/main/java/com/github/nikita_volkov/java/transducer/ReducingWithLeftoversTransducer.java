package com.github.nikita_volkov.java.transducer;

import com.github.nikita_volkov.java.composites.Product2;
import com.github.nikita_volkov.java.reducer.*;

import java.util.Optional;

public final class ReducingWithLeftoversTransducer<a, b> implements Transducer<a, b> {

  private final Reducer<a, Product2<Optional<a>, b>> intermediateReducer;

  public ReducingWithLeftoversTransducer(Reducer<a, Product2<Optional<a>, b>> intermediateReducer) {
    this.intermediateReducer = intermediateReducer;
  }

  @Override
  public <output> Reducer<a, output> transduce(Reducer<b, output> finalReducer) {
    return new ReducingWithLeftoversReducer<>(intermediateReducer, finalReducer);
  }

}
