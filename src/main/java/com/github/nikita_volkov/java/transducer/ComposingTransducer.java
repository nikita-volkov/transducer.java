package com.github.nikita_volkov.java.transducer;

import com.github.nikita_volkov.java.reducer.Reducer;

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

  public <b, c, d, e, f> ComposingTransducer(
    Transducer<a, b> transducer1,
    Transducer<b, c> transducer2,
    Transducer<c, d> transducer3,
    Transducer<d, e> transducer4,
    Transducer<e, f> transducer5,
    Transducer<f, z> transducer6
  ) {
    this.transducers = new Transducer[]{transducer6, transducer5, transducer4, transducer3, transducer2, transducer1};
  }

  public <b, c, d, e, f, g> ComposingTransducer(
    Transducer<a, b> transducer1,
    Transducer<b, c> transducer2,
    Transducer<c, d> transducer3,
    Transducer<d, e> transducer4,
    Transducer<e, f> transducer5,
    Transducer<f, g> transducer6,
    Transducer<g, z> transducer7
  ) {
    this.transducers = new Transducer[]{transducer7, transducer6, transducer5, transducer4, transducer3, transducer2, transducer1};
  }

  @Override
  public <output> Reducer<a, output> transduce(Reducer<z, output> finalReducer) {
    Reducer reducer = finalReducer;
    for (Transducer transducer : transducers) {
      reducer = transducer.transduce(reducer);
    }
    return reducer;
  }

}
