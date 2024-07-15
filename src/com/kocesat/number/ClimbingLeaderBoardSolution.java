package com.kocesat.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClimbingLeaderBoardSolution {

  public static void main(String[] args) {
    List<Integer> ranked = readAsIntList("295 294 291 287 287 285 285 284 283 279 277 274 274 271 270 268 268 268 264 260 259 258 257 255 252 250 244 241 240 237 236 236 231 227 227 227 226 225 224 223 216 212 200 197 196 194 193 189 188 187 183 182 178 177 173 171 169 165 143 140 137 135 133 130 130 130 128 127 122 120 116 114 113 109 106 103 99 92 85 81 69 68 63 63 63 61 57 51 47 46 38 30 28 25 22 15 14 12 6 4");
    List<Integer> player = readAsIntList("5 5 6 14 19 20 23 25 29 29 30 30 32 37 38 38 38 41 41 44 45 45 47 59 59 62 63 65 67 69 70 72 72 76 79 82 83 90 91 92 93 98 98 100 100 102 103 105 106 107 109 112 115 118 118 121 122 122 123 125 125 125 127 128 131 131 133 134 139 140 141 143 144 144 144 144 147 150 152 155 156 160 164 164 165 165 166 168 169 170 171 172 173 174 174 180 184 187 187 188 194 197 197 197 198 201 202 202 207 208 211 212 212 214 217 219 219 220 220 223 225 227 228 229 229 233 235 235 236 242 242 245 246 252 253 253 257 257 260 261 266 266 268 269 271 271 275 276 281 282 283 284 285 287 289 289 295 296 298 300 300 301 304 306 308 309 310 316 318 318 324 326 329 329 329 330 330 332 337 337 341 341 349 351 351 354 356 357 366 369 377 379 380 382 391 391 394 396 396 400");
    List<Integer> expected = getExpected();
    List<Integer> actual = climbingLeaderboard(ranked, player);
    boolean passed = true;
    for (int i = 0; i < expected.size(); i++) {
      try {
        if (expected.get(i).intValue() != actual.get(i).intValue()) {
          passed = false;
          System.out.println("Failed test index: " + i);
          break;
        }
      } catch (Exception e) {
        System.out.println("Expected val: " + expected.get(i));
        System.out.println("Failed test index: " + i);
        System.out.println(e.getMessage());
        break;
      }
    }
    System.out.println(actual);
    if (passed) {
      System.out.println("Test passed");
    } else {
      System.out.println("Test failed!");
    }
  }


  public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
    List<Integer> ranks = resolveRanks(ranked);
    final List<Integer> result = new ArrayList<>();

    int index = lastIndex(ranked);
    for (int score : player) {
      // [ 100, 90, 90, 85, 75, 60 ]
      while (index >= 0) {
        int rankedScore = ranked.get(index);
        if (score > rankedScore) {
          if (index == 0) {
            result.add(1);
            break;
          }
          index--;
          continue;
        } else if (score == rankedScore) {
          result.add(ranks.get(index));
          break;
        }
        result.add(ranks.get(index) + 1);
        break;
      }
    }
    return result;
  }
  private static List<Integer> resolveRanks(List<Integer> ranked) {
    int rank = 1;
    List<Integer> result = new ArrayList<>();
    result.add(rank);
    int lastScore = ranked.get(0);
    for (int i = 1; i < ranked.size(); i++) {
      int score = ranked.get(i);
      if (score == lastScore) {
        result.add(rank);
      } else {
        result.add(++rank);
      }
      lastScore = score;
    }
    return result;
  }

  private static <T> int lastIndex(List<T> list) {
    return list.size() - 1;
  }

  private static List<Integer> readAsIntList(String str) {
    return readAsIntList(str, " ");
  }

  private static List<Integer> readAsIntList(String str, String delimiter) {
    String[] numbers = str.split(delimiter);
    return Arrays.stream(numbers)
        .map(Integer::valueOf)
        .toList();
  }

  private static List<Integer> getExpected() {
    return readAsIntList("88\n" +
        "88\n" +
        "87\n" +
        "85\n" +
        "84\n" +
        "84\n" +
        "83\n" +
        "82\n" +
        "81\n" +
        "81\n" +
        "80\n" +
        "80\n" +
        "80\n" +
        "80\n" +
        "79\n" +
        "79\n" +
        "79\n" +
        "79\n" +
        "79\n" +
        "79\n" +
        "79\n" +
        "79\n" +
        "77\n" +
        "75\n" +
        "75\n" +
        "74\n" +
        "73\n" +
        "73\n" +
        "73\n" +
        "71\n" +
        "71\n" +
        "71\n" +
        "71\n" +
        "71\n" +
        "71\n" +
        "70\n" +
        "70\n" +
        "69\n" +
        "69\n" +
        "68\n" +
        "68\n" +
        "68\n" +
        "68\n" +
        "67\n" +
        "67\n" +
        "67\n" +
        "66\n" +
        "66\n" +
        "65\n" +
        "65\n" +
        "64\n" +
        "64\n" +
        "62\n" +
        "61\n" +
        "61\n" +
        "60\n" +
        "59\n" +
        "59\n" +
        "59\n" +
        "59\n" +
        "59\n" +
        "59\n" +
        "58\n" +
        "57\n" +
        "56\n" +
        "56\n" +
        "55\n" +
        "55\n" +
        "53\n" +
        "52\n" +
        "52\n" +
        "51\n" +
        "51\n" +
        "51\n" +
        "51\n" +
        "51\n" +
        "51\n" +
        "51\n" +
        "51\n" +
        "51\n" +
        "51\n" +
        "51\n" +
        "51\n" +
        "51\n" +
        "50\n" +
        "50\n" +
        "50\n" +
        "50\n" +
        "49\n" +
        "49\n" +
        "48\n" +
        "48\n" +
        "47\n" +
        "47\n" +
        "47\n" +
        "45\n" +
        "43\n" +
        "42\n" +
        "42\n" +
        "41\n" +
        "38\n" +
        "36\n" +
        "36\n" +
        "36\n" +
        "36\n" +
        "35\n" +
        "35\n" +
        "35\n" +
        "35\n" +
        "35\n" +
        "35\n" +
        "34\n" +
        "34\n" +
        "34\n" +
        "33\n" +
        "33\n" +
        "33\n" +
        "33\n" +
        "33\n" +
        "32\n" +
        "30\n" +
        "28\n" +
        "28\n" +
        "28\n" +
        "28\n" +
        "27\n" +
        "27\n" +
        "27\n" +
        "26\n" +
        "23\n" +
        "23\n" +
        "22\n" +
        "22\n" +
        "20\n" +
        "20\n" +
        "20\n" +
        "18\n" +
        "18\n" +
        "15\n" +
        "15\n" +
        "14\n" +
        "14\n" +
        "13\n" +
        "13\n" +
        "11\n" +
        "11\n" +
        "10\n" +
        "10\n" +
        "8\n" +
        "8\n" +
        "7\n" +
        "6\n" +
        "5\n" +
        "4\n" +
        "4\n" +
        "4\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1\n" +
        "1", "\n");
  }
}
