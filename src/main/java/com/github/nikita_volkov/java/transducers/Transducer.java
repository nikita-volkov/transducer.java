package com.github.nikita_volkov.java.transducers;

import com.github.nikita_volkov.java.iterations.Iteration;

public interface Transducer<a, b> {
  <output> Iteration<a, output> transduce(Iteration<b, output> initialIteration);
}
