package exploration;

public class Instructions {
  private Probe probe;
  private String instruction_list;

  public Instructions(String instruction_list, Probe probe) {
    this.instruction_list = instruction_list;
    this.probe = probe;
  }

  public void processInstructions() {
    // Processa a string de instruções char a char
    for (int i = 0; i < this.instruction_list.length(); i++) {
      char inst = this.instruction_list.charAt(i);

      Movement move = Movement.getMovement(inst);
      move.doMovement(probe);
    }

    probe.occupyPosition(probe.getPosition());
  }

}