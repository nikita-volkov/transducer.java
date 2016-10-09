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

  public <b, c, d> ComposingTransducer(
    Transducer<a, b> transducer1,
    Transducer<b, c> transducer2,
    Transducer<c, d> transducer3,
    Transducer<d, z> transducer4
  ) {
    this.transducers = new Transducer[]{transducer4, transducer3, transducer2, transducer1};
  }


  public <b, c, d, e> ComposingTransducer(
    Transducer<a, b> transducer1,
    Transducer<b, c> transducer2,
    Transducer<c, d> transducer3,
    Transducer<d, e> transducer4,
    Transducer<e, z> transducer5
  ) {
    this.transducers = new Transducer[]{transducer5, transducer4, transducer3, transducer2, transducer1};
  }

  @Override
  public <output> Iteration<a, output> transduce(Iteration<z, output> finalIteration) {
    Iteration iteration = finalIteration;
    for (Transducer transducer : transducers) {
      iteration = transducer.transduce(iteration);
    }
    return iteration;
  }

}
