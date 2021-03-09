import java.util.Optional;
import java.util.Scanner;
import exploration.*;

public class ExploringMars {

  public static void main(String[] args) {
    int fieldTopX, fieldTopY;

    try (Scanner reader = new Scanner(System.in)) {
      // leitura de dados da coordenada do canto superior direito do campo
      System.out.println("Insira a coordenada do canto direito superior do campo: ");
      fieldTopX = reader.nextInt();
      fieldTopY = reader.nextInt();
      reader.nextLine(); // processa o \n não consumido pelo nextInt anterior

      // cria instância do campo com a coordenada dadas
      Field field = new Field(fieldTopX, fieldTopY);

      // implantação de sondas até que o usuário decida parar
      while (true) {
        // leitura de informações da sonda
        System.out.println("Insira a coordenada e direção da sonda ou insira 'exit' para sair: ");
        String input = reader.nextLine();

        if (input.equals("exit")) {
          break;
        }

        // atribuição de variáveis
        int probeX = Integer.parseInt(input.split(" ")[0]);
        int probeY = Integer.parseInt(input.split(" ")[1]);
        char dir = input.split(" ")[2].charAt(0);

        // criação de instância da sonda e da sequência de instruções
        Optional<Direction> optDir = Direction.getDirection(dir);
        Direction direction = optDir.orElseThrow(IllegalArgumentException::new);
        Position position = new Position(probeX, probeY);

        // insere sonda no campo se o espaço não estiver ocupado ou estiver fora dos
        // limites
        if (field.isAvailableSpace(probeX, probeY)) {
          Probe probe = new Probe(position, direction, field);
          Instructions instructions = new Instructions(reader.nextLine(), probe);

          // realização das instruções
          instructions.processInstructions();

          // Imprime a posição e direção finais da sonda no terminal
          System.out.println(probe.getFinalPosition());
        } else {
          System.out.println("Erro: espaço já ocupado ou fora dos limites do campo.");
        }
      }
    }

  }
}