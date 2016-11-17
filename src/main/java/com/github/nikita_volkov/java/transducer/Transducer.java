package com.github.nikita_volkov.java.transducer;

import com.github.nikita_volkov.java.reducer.Reducer;

public interface Transducer<a, b> {
  <output> Reducer<a, output> transduce(Reducer<b, output> finalReducer);
}
