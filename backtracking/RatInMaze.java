public class RatInMaze {

    // public static boolean RInMaze(int maze[][]){
    //     int n = maze.length;
    //     int path[][] = new int[n][n];
    //     return solveMaze(maze, 0,0, path);
    // }
    // public static boolean solveMaze(int maze[][], int i, int j, int path[][]){
    //     int n = maze.length;
    //     // check if i,j cell valid or not
    //     if(i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1){
    //         return false;
    //     }
    //     // Include the cell in current path
    //         path[i][j] = 1;
    // //Destination cell
    // // if(i == n-1 && j == n-1){
    // //     return true;
    // // }
    // if(i == n-1 && j == n-1){
    //     for (int k = 0; k < n; k++) {
    //         for (int k2 = 0; k2 < n; k2++) {
    //             System.out.print(path[k][k2]+ " ");
    //         }System.out.println();
    //     }
    //     return true;
    // }


    // // Explore further in all directions
    // // Top
    // if(solveMaze(maze, i-1, j, path)){
    //     return true;
    // }
    // // right
    // if(solveMaze(maze, i, j+1, path)){
    //     return true;
    // }
    // // Down
    // if(solveMaze(maze, i+1, j, path)){
    //     return true;
    // }
    // // Left
    // if(solveMaze(maze, i, j-1, path)){
    //     return true;
    // }
    // return false;
    // }
    public static boolean RInMaze(int maze[][]){
        int n = maze.length;
        int path[][] = new int[n][n];
        solveMaze(maze, 0,0, path);
    }
    public static void solveMaze(int maze[][], int i, int j, int path[][]){
        int n = maze.length;
        // check if i,j cell valid or not
        if(i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1){
            return;
        }
        // Include the cell in current path
            path[i][j] = 1;
    //Destination cell
    // if(i == n-1 && j == n-1){
    //     return true;
    // }
    if(i == n-1 && j == n-1){
        for (int k = 0; k < n; k++) {
            for (int k2 = 0; k2 < n; k2++) {
                System.out.print(path[k][k2]+ " ");
            }System.out.println();
        }
        System.out.println();
        path[i][j] = 1;
        return;
    }


    // Explore further in all directions
    // Top
    solveMaze(maze, i-1, j, path);
    // right
    solveMaze(maze, i, j+1, path);
    // Down
    solveMaze(maze, i+1, j, path);
    // Left
    solveMaze(maze, i, j-1, path);
    path[i][j] = 1;
}
    public static void main(String[] args) {
        int maze[][] = {{1,1,0},{1,1,0}, {1,1,1}};
        boolean pathPossible = RInMaze(maze);
        System.out.println(pathPossible);
    }
}
