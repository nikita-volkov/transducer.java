package com.github.nikita_volkov.java.transducers;

import com.github.nikita_volkov.java.iterations.CatIteration;
import junit.framework.TestCase;

import java.util.*;

public class Test extends TestCase {
  public void testUniquifyingTransducer() {
    Transducer<String, String> transducer = new UniquifyingTransducer<>();
    assertEquals("123", transducer.transduce(new CatIteration()).consume(Arrays.asList("1", "2", "2", "3")));
  }

  public void testMappingTransducer() {
    Transducer<Integer, String> transducer = new MappingTransducer<>(a -> a.toString());
    assertEquals("123", transducer.transduce(new CatIteration()).consume(Arrays.asList(1, 2, 3)));
  }

  public void testTakingTransducer() {
    Transducer<Integer, String> transducer = new ComposingTransducer<>(new MappingTransducer<>(a -> a.toString()), new TakingTransducer<>(3));
    assertEquals("123", transducer.transduce(new CatIteration()).consume(Arrays.asList(1, 2, 3, 4)));
  }

  public void testComposingTransducerOrder1() {
    Transducer<String, String> transducer = new ComposingTransducer<>(new TakingTransducer<>(3), new UniquifyingTransducer<>());
    assertEquals("12", transducer.transduce(new CatIteration()).consume(Arrays.asList("1", "2", "2", "3")));
  }

  public void testComposingTransducerOrder2() {
    Transducer<String, String> transducer = new ComposingTransducer<>(new UniquifyingTransducer<>(), new TakingTransducer<>(3));
    assertEquals("123", transducer.transduce(new CatIteration()).consume(Arrays.asList("1", "2", "2", "3", "4")));
  }

  public void testFlatmappingTransducer() {
    Transducer<Integer, String> transducer = new FlatmappingTransducer<>(i -> i % 2 == 0 ? Arrays.asList(i.toString(), "!") : Arrays.asList());
    assertEquals("2!4!", transducer.transduce(new CatIteration()).consume(Arrays.asList(1, 2, 3, 4, 5)));
  }

  public void testTransducerBuilder() {
    Transducer<Integer, String> transducer = TransducerBuilder.<Integer>taking(3).unique().map(x -> x.toString());
    assertEquals("12", transducer.transduce(new CatIteration()).consume(Arrays.asList(1, 2, 2, 3)));
  }
}