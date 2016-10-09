package com.github.nikita_volkov.java.transducers;

import com.github.nikita_volkov.java.iterations.Iteration;

import java.util.function.Function;

public final class TransducerBuilder<a, b> implements Transducer<a, b> {

  private final Transducer<a, b> transducer;

  private TransducerBuilder(Transducer<a, b> transducer) {
    this.transducer = transducer;
  }

  @Override
  public <output> Iteration<a, output> transduce(Iteration<b, output> finalIteration) {
    return transducer.transduce(finalIteration);
  }

  public TransducerBuilder<a, b> take(long amount) {
    return new TransducerBuilder<a, b>(new ComposingTransducer<>(transducer, new TakingTransducer<>(amount)));
  }

  public TransducerBuilder<a, b> unique() {
    return new TransducerBuilder<a, b>(new ComposingTransducer<>(transducer, new UniquifyingTransducer<>()));
  }

  public <c> TransducerBuilder<a, c> map(Function<b, c> fn) {
    return new TransducerBuilder<a, c>(new ComposingTransducer<>(transducer, new MappingTransducer<>(fn)));
  }

  public static <a> TransducerBuilder<a, a> taking(long amount) {
    return new TransducerBuilder<>(new TakingTransducer<>(amount));
  }

}
