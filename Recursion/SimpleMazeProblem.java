package Medium;
import java.util.*;
public class MazeProblem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] maze = new int[3][3];
        WaystoReachEnd(maze,0,0,"");
//        int ans = StepsToReachEnd(maze,0,0);
//        System.out.print(ans);
    }
    private static void WaystoReachEnd(int[][] maze,int r, int c,String p){
        if(r == maze.length-1 && c== maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(r <3)
        WaystoReachEnd(maze,r+1,c,p+"D");
        if(c <3)
        WaystoReachEnd(maze,r,c+1,p+"R");
    }

    public static int StepsToReachEnd(int[][] maze, int r, int c){
        if(r == maze.length-1 || c == maze[0].length-1){
            return 1;
        }
        int down = StepsToReachEnd(maze,r+1,c);
        int right = StepsToReachEnd(maze,r,c+1);
        return down + right;
    }
}
