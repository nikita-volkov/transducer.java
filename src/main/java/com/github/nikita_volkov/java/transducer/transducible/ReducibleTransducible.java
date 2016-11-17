package com.github.nikita_volkov.java.transducer.transducible;

import com.github.nikita_volkov.java.iterations.Iteration;
import com.github.nikita_volkov.java.reducer.reducible.Reducible;

/**
 * Lifter of any Reducible into Transducible.
 */
public final class ReducibleTransducible<input> implements Transducible<input> {

  private final Reducible<input> reducible;

  public ReducibleTransducible(Reducible<input> reducible) {
    this.reducible = reducible;
  }

  @Override
  public <output> output execute(Iteration<input, output> iteration) {
    return reducible.execute(iteration);
  }

}
