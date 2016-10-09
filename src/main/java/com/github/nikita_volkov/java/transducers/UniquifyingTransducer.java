package com.github.nikita_volkov.java.transducers;

import com.github.nikita_volkov.java.iterations.*;

public final class UniquifyingTransducer<a> implements Transducer<a, a> {

  @Override
  public <output> Iteration<a, output> transduce(Iteration<a, output> finalIteration) {
    return new UniqueIteration<a, output>(finalIteration);
  }

}
