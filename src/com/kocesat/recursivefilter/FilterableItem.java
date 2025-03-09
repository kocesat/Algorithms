package com.kocesat.recursivefilter;

import java.util.ArrayList;
import java.util.List;

public class FilterableItem {

  private String name;
  private boolean includable;
  private List<FilterableItem> subItems = new ArrayList<>();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isIncludable() {
    return includable;
  }

  public void setIncludable(boolean includable) {
    this.includable = includable;
  }

  public List<FilterableItem> getSubItems() {
    return subItems;
  }

  public void setSubItems(List<FilterableItem> subItems) {
    this.subItems = subItems;
  }
}
