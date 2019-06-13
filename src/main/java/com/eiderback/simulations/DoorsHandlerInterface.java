package com.eiderback.simulations;

public interface DoorsHandlerInterface {
  void scrambleDoors();
  String takeFirstDoor();
  boolean takeFirstEmptyDoor();
  boolean isItACarBehindTheDoor(String aDoor);
}
