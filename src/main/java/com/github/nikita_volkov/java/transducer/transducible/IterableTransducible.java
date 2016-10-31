package com.github.nikita_volkov.java.transducer.transducible;

import com.github.nikita_volkov.java.iterations.Iteration;
import com.github.nikita_volkov.java.reducer.reducible.*;

/**
 * Lifter of any Iterable into Transducible
 */
public final class IterableTransducible<input> implements Transducible<input> {

  private final Reducible<input> reducible;

  private IterableTransducible(Reducible<input> reducible) {
    this.reducible = reducible;
  }

  public IterableTransducible(Iterable<input> iterable) {
    this(new IterableReducible<>(iterable));
  }

  @Override
  public <output> output reduce(Iteration<input, output> iteration) {
    return reducible.reduce(iteration);
  }

}
