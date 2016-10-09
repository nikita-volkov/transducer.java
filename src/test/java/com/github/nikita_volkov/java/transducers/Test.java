package com.github.nikita_volkov.java.transducers;

import com.github.nikita_volkov.java.iterations.CatIteration;
import junit.framework.TestCase;

import java.util.Arrays;

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
}