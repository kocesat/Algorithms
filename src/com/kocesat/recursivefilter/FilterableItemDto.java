package com.kocesat.recursivefilter;

import java.util.List;

public class FilterableItemDto {

  private String name;
  private List<FilterableItemDto> subItems;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<FilterableItemDto> getSubItems() {
    return subItems;
  }

  public void setSubItems(List<FilterableItemDto> subItems) {
    this.subItems = subItems;
  }

  @Override
  public String toString() {
    return "FilterableItemDto{" +
        "name='" + name + '\'' +
        '}';
  }
}
