package com.eiderback.simulations;

import java.util.List;

public interface DoorsHandlerInterface {
  void scrambleDoors();
  String takeFirstDoor();
  boolean takeFirstEmptyDoor();
  boolean isItACarBehindTheDoor(String aDoor);
}
