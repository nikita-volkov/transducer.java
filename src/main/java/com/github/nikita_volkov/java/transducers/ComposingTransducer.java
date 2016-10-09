package com.github.nikita_volkov.java.transducers;

import com.github.nikita_volkov.java.iterations.Iteration;

public final class ComposingTransducer<a, b, c> implements Transducer<a, c> {
  private final Transducer<a, b> transducer1;
  private final Transducer<b, c> transducer2;

  public ComposingTransducer(Transducer<a, b> transducer1, Transducer<b, c> transducer2) {
    this.transducer1 = transducer1;
    this.transducer2 = transducer2;
  }

  @Override
  public <output> Iteration<a, output> transduce(Iteration<c, output> initialIteration) {
    return transducer1.transduce(transducer2.transduce(initialIteration));
  }
}
