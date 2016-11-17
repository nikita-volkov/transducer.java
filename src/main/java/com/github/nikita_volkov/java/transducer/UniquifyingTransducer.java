package com.github.nikita_volkov.java.transducer;

import com.github.nikita_volkov.java.reducer.*;

public final class UniquifyingTransducer<a> implements Transducer<a, a> {

  @Override
  public <output> Reducer<a, output> transduce(Reducer<a, output> finalReducer) {
    return new UniquifyingReducer<>(finalReducer);
  }

}
