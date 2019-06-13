package com.eiderback.simulations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.Arrays;
import java.util.List;

import static com.eiderback.simulations.DoorsHandler.CAR;
import static com.eiderback.simulations.DoorsHandler.EMPTY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class MontyHallSimulationTest {
  MontyHallSimulation objectUnderTest;

  @Spy
  DoorsHandler doorsHandler;

  @BeforeEach
  void setUp() {
    initMocks(this);
    objectUnderTest = new MontyHallSimulation(doorsHandler);
  }

  @Test
  void runOneRoundKeepWins() {
    //Mock the scrambling...
    List<String> carFirst = Arrays.asList(CAR, EMPTY, EMPTY);
    when(doorsHandler.scrambledList()).thenReturn(carFirst);
    objectUnderTest.runOneRound();
    assertEquals(1L, objectUnderTest.keepWins);
    assertEquals(0L, objectUnderTest.changeWins);
  }

  @Test
  void runOneRoundChangeWinsCar_in_pos_1() {
    //Mock the scrambling...
    List<String> carSecond = Arrays.asList(EMPTY, CAR, EMPTY);
    when(doorsHandler.scrambledList()).thenReturn(carSecond);
    objectUnderTest.runOneRound();
    assertEquals(0L, objectUnderTest.keepWins);
    assertEquals(1L, objectUnderTest.changeWins);
  }


  @Test
  void runOneRoundChangeWinsCar_in_pos_2() {
    //Mock the scrambling...
    List<String> carThird = Arrays.asList(EMPTY, CAR, EMPTY);
    when(doorsHandler.scrambledList()).thenReturn(carThird);
    objectUnderTest.runOneRound();
    assertEquals(0L, objectUnderTest.keepWins);
    assertEquals(1L, objectUnderTest.changeWins);
  }
}