package com.github.jackson.mixin.iterable;

import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 *
 */
public class CollectionWrapper<T> implements Collection<T> {

  private Collection<T> inner;
  public CollectionWrapper(Collection<T> inner) {
    this.inner = inner;
  }

  @Override
  public int size() {
    return inner.size();
  }

  @Override
  public boolean isEmpty() {
    return inner.isEmpty();
  }

  @Override
  public boolean contains(Object o) {
    return inner.contains(o);
  }

  @Override
  public Iterator<T> iterator() {
    return inner.iterator();
  }

  @Override
  public Object[] toArray() {
    return inner.toArray();
  }

  @Override
  public <T1> T1[] toArray(T1[] a) {
    return inner.toArray(a);
  }

  @Override
  public boolean add(T t) {
    return inner.add(t);
  }

  @Override
  public boolean remove(Object o) {
    return inner.remove(o);
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    return inner.containsAll(c);
  }

  @Override
  public boolean addAll(Collection<? extends T> c) {
    return inner.addAll(c);
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    return inner.removeAll(c);
  }

  @Override
  public boolean removeIf(Predicate<? super T> filter) {
    return inner.removeIf(filter);
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    return inner.retainAll(c);
  }

  @Override
  public void clear() {
    inner.clear();
  }

  @Override
  public boolean equals(Object o) {
    return inner.equals(o);
  }

  @Override
  public int hashCode() {
    return inner.hashCode();
  }

  @Override
  public Spliterator<T> spliterator() {
    return inner.spliterator();
  }

  @Override
  public Stream<T> stream() {
    return inner.stream();
  }

  @Override
  public Stream<T> parallelStream() {
    return inner.parallelStream();
  }

  @Override
  public void forEach(Consumer<? super T> action) {
    inner.forEach(action);
  }
}
