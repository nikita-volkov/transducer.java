package com.github.nikita_volkov.java.transducer;

import com.github.nikita_volkov.java.reducer.*;

public final class TakingTransducer<a> implements Transducer<a, a> {

  private final long amount;

  public TakingTransducer(long amount) {
    this.amount = amount;
  }

  @Override
  public <output> Reducer<a, output> transduce(Reducer<a, output> finalReducer) {
    return new TakingReducer<>(finalReducer, amount);
  }

}
