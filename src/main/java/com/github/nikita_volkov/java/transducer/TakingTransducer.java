package com.github.nikita_volkov.java.transducer;

import com.github.nikita_volkov.java.iterations.*;

public final class TakingTransducer<a> implements Transducer<a, a> {

  private final long amount;

  public TakingTransducer(long amount) {
    this.amount = amount;
  }

  @Override
  public <output> Iteration<a, output> transduce(Iteration<a, output> finalIteration) {
    return new TakingIteration<>(finalIteration, amount);
  }

}
