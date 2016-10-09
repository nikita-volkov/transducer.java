package com.github.nikita_volkov.java.transducers;

import com.github.nikita_volkov.java.iterations.CatIteration;
import junit.framework.TestCase;

import java.util.Arrays;

public class Test extends TestCase {
  public void test1() {
    Transducer<Integer, String> transducer = new ComposingTransducer<>(new UniquifyingTransducer<>(), new MappingTransducer<>(a -> a.toString()));
    assertEquals("1234", transducer.transduce(new CatIteration()).consume(Arrays.asList(1, 2, 3, 4)));
  }
  public void test2() {
    Transducer<Integer, String> transducer = new ComposingTransducer<>(new UniquifyingTransducer<>(), new MappingTransducer<>(a -> a.toString()), new TakingTransducer<>(3));
    assertEquals("123", transducer.transduce(new CatIteration()).consume(Arrays.asList(1, 2, 3, 4)));
  }
}