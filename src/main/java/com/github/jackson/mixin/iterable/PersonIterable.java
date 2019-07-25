package com.github.jackson.mixin.iterable;

import java.util.LinkedList;

public class PersonIterable {
  private String name;
  private final LinkedList<String> pets = new LinkedList<>();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Iterable<String> getPets() {
    return new IterableWrapper<>(pets);
  }

  public void setPets(Iterable<String> pets) {
    this.pets.clear();
    pets.forEach( this.pets::add);
  }
}
