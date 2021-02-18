import java.util.Scanner;
import exploration.*;

public class ExploringMars {

  public static void main(String[] args) {
    int field_x, field_y;

    try (Scanner reader = new Scanner(System.in)) {
      // leitura de dados da coordenada do canto superior direito do campo
      System.out.println("Enter the top right coordinates of the field: ");
      field_x = reader.nextInt();
      field_y = reader.nextInt();
      reader.nextLine(); // processa o \n não consumido pelo nextInt anterior

      // cria instância do campo com a coordenada dadas
      Field field = new Field(field_x, field_y);

      System.out.println("Enter the probe information or press 'q' to exit: ");

      // implantação de sondas até que o usuário decida parar
      while (true) {
        String input = reader.nextLine();

        if (input.equals("q")) {
          break;
        }

        // leitura de informações da sonda
        int probe_x = Integer.parseInt(input.split(" ")[0]);
        int probe_y = Integer.parseInt(input.split(" ")[1]);
        char dir = input.split(" ")[2].charAt(0);

        // criação de instância da sonda e da sequência de instruções
        Direction direction = Direction.getDirection(dir);
        Position position = new Position(probe_x, probe_y);
        Probe probe = new Probe(position, direction, field);
        Instructions instructions = new Instructions(reader.nextLine(), probe);

        // realização das instruções
        instructions.processInstructions();

        // Mostra a posição e direção finais da sonda no terminal
        System.out.println(probe.getFinalPosition());
      }
    }

  }
}