package com.kocesat.recursivefilter;

import java.util.ArrayList;
import java.util.List;

public class RecursiveFiltering {

  public static void main(String[] args) {
    List<FilterableItem> items = getItems();
    List<FilterableItemDto> dtoList = filterAndMapToDto(items);
    print(dtoList);
  }

  private static void print(List<FilterableItemDto> dtoList) {
    for (FilterableItemDto dto : dtoList) {
      System.out.println(dto);
      if (dto.getSubItems() != null && !dto.getSubItems().isEmpty()) {
        System.out.println("---subItems---" + dto.getName());
        print(dto.getSubItems());
        System.out.println("---end subItems---" + dto.getName());
      }
    }
  }

  private static List<FilterableItemDto> filterAndMapToDto(List<FilterableItem> items) {
    List<FilterableItemDto> dtoList = new ArrayList<>();
    for (FilterableItem item : items) {
      if (item.isIncludable()) {
        FilterableItemDto dto = new FilterableItemDto();
        dto.setName(item.getName());
        if (item.getSubItems() != null && !item.getSubItems().isEmpty()) {
          dto.setSubItems(filterAndMapToDto(item.getSubItems()));
        }
        dtoList.add(dto);
      }
    }
    return dtoList;
  }

  private static List<FilterableItem> getItems() {
    FilterableItem subItem1 = new FilterableItem();
    subItem1.setName("subitem1");
    subItem1.setIncludable(true);

    FilterableItem subItem2 = new FilterableItem();
    subItem2.setName("subitem2");
    subItem2.setIncludable(false);

    FilterableItem subItem3 = new FilterableItem();
    subItem3.setName("subitem3");
    subItem3.setIncludable(true);

    FilterableItem subItem4 = new FilterableItem();
    subItem4.setName("subitem4");
    subItem4.setIncludable(true);

    FilterableItem subItem5 = new FilterableItem();
    subItem5.setName("subitem5");
    subItem5.setIncludable(false);

    FilterableItem subItem6_1 = new FilterableItem();
    subItem6_1.setName("subitem6_1");
    subItem6_1.setIncludable(true);

    FilterableItem subItem6 = new FilterableItem();
    subItem6.setName("subitem6");
    subItem6.setIncludable(true);
    subItem6.setSubItems(List.of(subItem6_1));

    FilterableItem item1 = new FilterableItem();
    item1.setName("item1");
    item1.setIncludable(true);
    item1.getSubItems().add(subItem1);
    item1.getSubItems().add(subItem2);
    item1.getSubItems().add(subItem3);

    FilterableItem item2 = new FilterableItem();
    item2.setName("item2");
    item2.setIncludable(true);
    item2.getSubItems().add(subItem4);
    item2.getSubItems().add(subItem5);
    item2.getSubItems().add(subItem6);

    return List.of(item1, item2);
  }
}
