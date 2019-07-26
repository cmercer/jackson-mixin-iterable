package com.github.jackson.mixin.iterable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PersonTests {

  private ObjectMapper jacksonMapper;
  private ObjectMapper globalFilterMapper;
  private PersonIterable personIterable;
  private PersonCollection personCollection;

  @Before
  public void before() {
    jacksonMapper = new ObjectMapper();
    globalFilterMapper = initGlobalFilter(new ObjectMapper());

    personIterable = new PersonIterable();
    personIterable.setName("Jim Henson");
    List<String> pets = new ArrayList<>();
    pets.add("Kermit the Frog");
    pets.add("Miss Piggy");
    pets.add("Sam the Eagle");
    personIterable.setPets(pets);

    personCollection = new PersonCollection();
    personCollection.setName("Jim Henson");
    personCollection.setPets(pets);
  }

  @After
  public void after() {
    jacksonMapper = null;
    globalFilterMapper = null;
  }

  @Test
  public void personIterableTest() throws JsonProcessingException {
    String jacksonResult = jacksonMapper.writeValueAsString(personIterable);
    String squigglyResult = globalFilterMapper.writeValueAsString(personIterable);
    Assert.assertEquals(jacksonResult, squigglyResult);
  }

  @Test
  public void iterableOnlySerializationTest() throws JsonProcessingException {
    String jacksonResult = jacksonMapper.writeValueAsString(personIterable.getPets());
    String squigglyResult = globalFilterMapper.writeValueAsString(personIterable.getPets());
    Assert.assertEquals(jacksonResult, squigglyResult);
  }

  @Test
  public void personCollectionTest() throws JsonProcessingException {
    String jacksonResult = jacksonMapper.writeValueAsString(personCollection);
    String squigglyResult = globalFilterMapper.writeValueAsString(personCollection);
    Assert.assertEquals(jacksonResult, squigglyResult);
  }

  ObjectMapper initGlobalFilter(ObjectMapper mapper) {
    SimpleFilterProvider simpleFilterProvider = new SimpleFilterProvider();
    simpleFilterProvider.addFilter(Constants.FILTER_NAME, SimpleBeanPropertyFilter.serializeAll());
    mapper.setFilterProvider(simpleFilterProvider);
    mapper.addMixIn(Object.class, GlobalMixin.class);
    return mapper;
  }
}
