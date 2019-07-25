package com.github.jackson.mixin.iterable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 */
public class PersonCollection {
  private String name;
  private CollectionWrapper<String> pets = new CollectionWrapper<>(Collections.emptyList());

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Collection<String> getPets() {
    return pets;
  }

  public void setPets(Collection<String> pets) {
    ArrayList<String> arrayList = new ArrayList<>(pets);
    this.pets = new CollectionWrapper<>(arrayList);
  }
}
