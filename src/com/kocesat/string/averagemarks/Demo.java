package com.kocesat.string.averagemarks;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {

  private static final Pattern PATTERN = Pattern.compile("\\d+");

  public static void main(String[] args) {
    List<String> studentMarkStrings = List.of(
        "Micheal Scofield: 9 10 11",
        "Tony Stark; 5-5-5",
        "Mark Zuckerber* 10:20:35"
    );
    String actual = solve(studentMarkStrings);
    System.out.println(actual);
    String expectedResult = "Micheal Scofield-10,Tony Stark-5,Mark Zuckerber-21";
    System.out.println("Test Passed: " + expectedResult.equals(actual));
  }

  public static String solve(List<String> strList) {

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < strList.size(); i++) {
      Student student = getStudent(strList.get(i));
      sb.append(student.getName());
      sb.append("-");
      sb.append(getAverage(student.getMarks()));
      if (i != strList.size() - 1) {
        sb.append(",");
      }
    }
    return sb.toString();
  }

  public static Student getStudent(String str) {
    List<Integer> marks = new ArrayList<>();
    StringBuilder nameBuilder = new StringBuilder();

    int firstDigitIndex = 0;
    for (char ch : str.toCharArray()) {
      if (Character.isDigit(ch)) {
        break;
      }

      if (Character.isLetter(ch) || Character.isSpaceChar(ch)) {
        nameBuilder.append(ch);
        firstDigitIndex++;
      }
    }

    Matcher matcher = PATTERN.matcher(str.substring(firstDigitIndex));

    while (matcher.find()) {
      Integer mark = Integer.valueOf(matcher.group());
      marks.add(mark);
    }

    Student student = new Student();
    student.setName(nameBuilder.toString().trim());
    student.setMarks(marks);
    return student;
  }

  public static Integer getAverage(List<Integer> marks) {
    if (marks.isEmpty()) {
      return 0;
    }
    int sum = 0;
    for (Integer mark : marks) {
      sum = sum + mark;
    }

    if (sum == 0) {
      return 0;
    }

    return sum / marks.size();
  }
}
