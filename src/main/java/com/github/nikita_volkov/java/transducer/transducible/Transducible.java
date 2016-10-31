package com.github.nikita_volkov.java.transducer.transducible;

import com.github.nikita_volkov.java.reducer.Reducer;
import com.github.nikita_volkov.java.reducer.reducible.Reducible;
import com.github.nikita_volkov.java.transducer.Transducer;

public interface Transducible<input> extends Reducible<input> {
  default <input2, output> output reduce(Transducer<input, input2> transducer, Reducer<input2, output> reducer) {
    return reduce(transducer.transduce(reducer.newIteration()));
  }
}
