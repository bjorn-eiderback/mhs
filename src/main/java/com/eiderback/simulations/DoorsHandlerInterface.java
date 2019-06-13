package com.eiderback.simulations;

import java.util.List;

public interface DoorsHandlerInterface {
  void scrambledDoors();
  String takeFirstDoor();
  boolean takeFirstEmptyDoor();
  boolean isItACarBehindTheDoor(String aDoor);
}
