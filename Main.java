import java.util.Scanner;
import path.*;

public class Main {

  public static void main(String[] args) {
    int field_x, field_y;

    try (Scanner reader = new Scanner(System.in)) {
      System.out.println("Enter the top right coordinates of the field: ");
      field_x = reader.nextInt();
      field_y = reader.nextInt();
      reader.nextLine(); // throw away the \n not consumed by nextInt()

      // Create field instance with the given coordinates
      Field field = new Field(field_x, field_y);

      System.out.println("Enter the probe information or press 'q' to exit: ");

      while (true) {
        int probe_x, probe_y;
        char direction;

        String input = reader.nextLine();

        if (input.equals("q")) {
          break;
        }

        probe_x = Integer.parseInt(input.split(" ")[0]);
        probe_y = Integer.parseInt(input.split(" ")[1]);
        direction = input.split(" ")[2].charAt(0);

        Probe probe = new Probe(probe_x, probe_y, direction);

        String instructions = reader.nextLine();

        probe.doInstructions(instructions, field);
        System.out.println(probe.getFinalPosition());
      }
    }

  }
}