package com.github.nikita_volkov.java.transducer;

import com.github.nikita_volkov.java.iterations.Iteration;

public interface Transducer<a, b> {
  <output> Iteration<a, output> transduce(Iteration<b, output> finalIteration);
}