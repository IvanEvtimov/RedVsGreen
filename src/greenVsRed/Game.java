package greenVsRed;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Insert the size of grid (x, y): ");
        String[] line = scanner.nextLine().split(", ");

        Grid grid = new Grid(Integer.parseInt(line[0]), Integer.parseInt(line[1]));

        for (int i = 0; i < grid.grid.length; i++) {
            System.out.print(String.format("Insert %s digits: ", grid.grid[0].length));
            grid.initialiseGrid(scanner.nextLine());
        }

        System.out.print("Insert x1, y1, N: ");
        String[] line1 = scanner.nextLine().split(", ");
        int x = Integer.parseInt(line1[0]);
        int y = Integer.parseInt(line1[1]);
        int turns = Integer.parseInt(line1[2]);

        int wasGreen = 0;

        for (int i = 0; i < turns; i++) {
            if (grid.grid[x][y] == 1) {
                wasGreen++;
            }
            grid.nextGeneration();


        }

        System.out.println(String.format("The cell [%s, %s] was green %s times.", x, y, wasGreen));


    }


}
