package greenVsRed;

class Grid {
    int size;
    int[][] grid;

    Grid(int x, int y) {
        this.size = 0;
        this.grid = new int[x][y];
    }

    void initialiseGrid(String line) {
        String[] values = line.split("");

        for (int i = 0; i < grid[0].length; i++) {
            grid[size][i] = Integer.parseInt(values[i]);
        }
        size++;

    }


    void nextGeneration() {
        int[][] nextGrid = new int[this.grid.length][this.grid[0].length];
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[0].length; j++) {
                int sum = 0;
                if (this.grid[i][j] == 0) {
                    for (int k = i - 1; k <= i + 1; k++) {
                        for (int l = j - 1; l <= j + 1; l++) {
                            if (k < 0 || k == this.grid.length || l < 0 || l == this.grid.length) {
                                continue;
                            }
                            if (k == i && l == j) {
                                continue;
                            }
                            if (this.grid[k][l] == 1) {
                                sum++;
                            }
                        }
                    }
                    if (sum == 3 || sum == 6) {
                        nextGrid[i][j] = 1;
                    } else {
                        nextGrid[i][j] = 0;
                    }


                } else {
                    for (int k = i - 1; k <= i + 1; k++) {
                        for (int l = j - 1; l <= j + 1; l++) {
                            if (k < 0 || k == this.grid.length || l < 0 || l == this.grid.length) {
                                continue;
                            }
                            if (k == i && l == j) {
                                continue;
                            }
                            if (this.grid[k][l] == 0) {
                                sum++;
                            }
                        }
                    }
                    if (sum != 2 && sum != 3 && sum != 6) {
                        nextGrid[i][j] = 0;
                    } else {
                        nextGrid[i][j] = 1;
                    }

                }


            }
        }
        this.grid = nextGrid;
    }

}
