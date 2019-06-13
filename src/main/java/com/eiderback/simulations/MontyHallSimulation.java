package com.eiderback.simulations;

public class MontyHallSimulation {
  private DoorsHandlerInterface doorsHandler;
  Long keepWins;
  Long changeWins;
  Long roundNo;
  boolean continueSimulation;

  public MontyHallSimulation(DoorsHandlerInterface doorsHandler) {
    this.doorsHandler = doorsHandler;
    resetStatistics();
    continueSimulation = true;
  }

  public void run() {
    while(continueSimulation) { //We run "forever" in this version. Terminate with CRTL-C or similar
      updateRoundNumber();
      runOneRound();
      presentResultOfCurrentRound();
    }
  }

  protected void runOneRound() {
    //Scramble the list of doors.
    doorsHandler.scrambleDoors();
    //Player takes the first door (since the randomization is in the scrambledList we always choose the first door)
    doorsHandler.takeFirstDoor();
    //Host takes the first of the empty doors
    doorsHandler.takeFirstEmptyDoor();
    //The last door is the only thing that is left in the list
    String lastDoor = doorsHandler.takeFirstDoor();
    updateWins(lastDoor);
  }

  private void resetStatistics() {
    keepWins = 0L;
    changeWins = 0L;
    roundNo = 0L;
  }

  private void updateRoundNumber() {
    roundNo++;
  }

  private void updateWins(String lastDoor) {
    if (doorsHandler.isItACarBehindTheDoor(lastDoor)) {
      changeWins++;
    } else {
      keepWins++;
    }
  }

  /**
   * Very simple presentation of the result
   */
  private void presentResultOfCurrentRound() {
    String percentageKeep = computePercentage(keepWins, roundNo);
    String percentageChange = computePercentage(changeWins, roundNo);
    String output = String.format("Rounds played: %s :: Keep wins: %s (%s) | Change wins: %s (%s)", roundNo, keepWins, percentageKeep, changeWins, percentageChange);
    System.out.println(output);
  }

  private String computePercentage(Long wins, Long rounds) {
    float percentage = wins.floatValue() / rounds.floatValue();
    return String.format("%.0f%%", 100 * percentage);
  }

  public static void main(String[] args) {
    MontyHallSimulation simulation = new MontyHallSimulation(new DoorsHandler());
    simulation.run();
  }

}
