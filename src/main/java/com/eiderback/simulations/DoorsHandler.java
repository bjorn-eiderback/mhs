package com.eiderback.simulations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Helper class to hide the details of the doors' list
 * And to enable test of the algorithm
 */
public class DoorsHandler implements DoorsHandlerInterface {
  public static final String CAR = "Car";
  public static final String EMPTY = "";
  //In the test there is a car behind one door and nothing behind two doors
  private static final List<String> POSSIBLE_DOORS = Arrays.asList(CAR, EMPTY, EMPTY);
  private List<String> doors;

  /**
   * Create a scrambled list from POSSIBLE_DOORS.
   * @return a randomly scrambled list of doors
   */
  List<String> scrambledList() {
    List<String> list = new ArrayList<>(POSSIBLE_DOORS);
    Collections.shuffle(list);
    return list;
  }

  /**
   * Scramble the doors list
   */
  @Override
  public void scrambleDoors() {
    //To be able to delete an item we have to create an ArrayList of the scrambled list
    doors = new ArrayList(scrambledList());
  }

  @Override
  public String takeFirstDoor() {
    return doors.remove(0);
  }

  @Override
  public boolean takeFirstEmptyDoor() {
    return doors.remove(EMPTY);
  }

  @Override
  public boolean isItACarBehindTheDoor(String aDoor) {
    return CAR.equals(aDoor);
  }
}
