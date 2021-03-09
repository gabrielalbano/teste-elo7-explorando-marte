package exploration;

import java.util.Optional;

public class Instructions {
  private final Probe probe;
  private final String instructionList;

  public Instructions(String instructionList, Probe probe) {
    this.instructionList = instructionList;
    this.probe = probe;
  }

  public void processInstructions() {
    // Processa a string de instruções char a char
    for (int i = 0; i < this.instructionList.length(); i++) {
      char inst = this.instructionList.charAt(i);

      Optional<Movement> optMove = Movement.getMovement(inst);
      Movement move = optMove.orElseThrow(IllegalArgumentException::new);
      move.doMovement(probe);
    }

    probe.occupyPosition(probe.getPosition());
  }

}