package com.github.nikita_volkov.java.transducer;

import com.github.nikita_volkov.java.reducer.StringCatReducer;
import com.github.nikita_volkov.java.reducer.reducible.*;
import com.github.nikita_volkov.java.transducer.transducible.IterableTransducible;
import junit.framework.TestCase;

import java.util.Arrays;

public class Test extends TestCase {
  public void testUniquifyingTransducer() {
    Transducer<String, String> transducer = new UniquifyingTransducer<>();
    assertEquals("123", new IterableReducible<>(Arrays.asList("1", "2", "2", "3")).reduce(transducer.transduce(new StringCatReducer())));
  }

  public void testMappingTransducer() {
    Transducer<Integer, String> transducer = new MappingTransducer<>(a -> a.toString());
    assertEquals("123", new IterableTransducible<>(Arrays.asList(1, 2, 3)).reduce(transducer, new StringCatReducer()));
  }

  public void testTakingTransducer() {
    Transducer<Integer, String> transducer = new ComposingTransducer<>(new MappingTransducer<>(a -> a.toString()), new TakingTransducer<>(3));
    assertEquals("123", new ArrayReducible<>(1, 2, 3, 4).reduce(transducer.transduce(new StringCatReducer())));
  }

  public void testComposingTransducerOrder1() {
    Transducer<String, String> transducer = new ComposingTransducer<>(new TakingTransducer<>(3), new UniquifyingTransducer<>());
    assertEquals("12", new ArrayReducible<>("1", "2", "2", "3").reduce(transducer.transduce(new StringCatReducer())));
  }

  public void testComposingTransducerOrder2() {
    Transducer<String, String> transducer = new ComposingTransducer<>(new UniquifyingTransducer<>(), new TakingTransducer<>(3));
    assertEquals("123", new ArrayReducible<>("1", "2", "2", "3", "4").reduce(transducer.transduce(new StringCatReducer())));
  }

  public void testFlatmappingTransducer() {
    Transducer<Integer, String> transducer = new FlatmappingTransducer<>(i -> i % 2 == 0 ? Arrays.asList(i.toString(), "!") : Arrays.asList());
    assertEquals("2!4!", new ArrayReducible<>(1, 2, 3, 4, 5).reduce(transducer.transduce(new StringCatReducer())));
  }

  public void testTransducerBuilder() {
    Transducer<Integer, String> transducer = TransducerBuilder.<Integer>taking(3).unique().map(x -> x.toString());
    assertEquals("12", new ArrayReducible<>(1, 2, 2, 3).reduce(transducer.transduce(new StringCatReducer())));
  }
}