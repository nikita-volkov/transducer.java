package com.github.nikita_volkov.java.transducers;

import com.github.nikita_volkov.java.iterations.Iteration;

public final class ComposingTransducer<a, z> implements Transducer<a, z> {

  private final Transducer[] transducers;

  public <b> ComposingTransducer(
    Transducer<a, b> transducer1,
    Transducer<b, z> transducer2
  ) {
    this.transducers = new Transducer[]{transducer2, transducer1};
  }

  public <b, c> ComposingTransducer(
    Transducer<a, b> transducer1,
    Transducer<b, c> transducer2,
    Transducer<c, z> transducer3
  ) {
    this.transducers = new Transducer[]{transducer3, transducer2, transducer1};
  }

  @Override
  public <output> Iteration<a, output> transduce(Iteration<z, output> initialIteration) {
    Iteration iteration = initialIteration;
    for (Transducer transducer : transducers) {
      iteration = transducer.transduce(iteration);
    }
    return iteration;
  }

}
