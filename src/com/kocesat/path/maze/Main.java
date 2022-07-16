package com.kocesat.path.maze;

public class Main {
    public static void main(String[] args) {
        Maze maze = new Maze(false);
        MazeNode e = new MazeNode("e");
        MazeNode s1 = new MazeNode("s");
        MazeNode s2 = new MazeNode("s");
        MazeNode a = new MazeNode("a");
        MazeNode d = new MazeNode("d");
        MazeNode i = new MazeNode("ı");
        MazeNode m = new MazeNode("m");
        maze.appendNode(e, s1);
        maze.appendNode(e, new MazeNode("you're not alone."));
        maze.appendNode(e, new MazeNode("keep going"));
        maze.appendNode(s1, s2);
        maze.appendNode(s1, new MazeNode(""));
        maze.appendNode(s2, a);
        maze.appendNode(a, new MazeNode("amk"));
        maze.appendNode(s2, new MazeNode("no way from here"));
        maze.appendNode(d, a);
        maze.appendNode(d, i);
        maze.appendNode(new MazeNode("f"), i);
        maze.appendNode(m, i);
        System.out.println(maze.findPath(e, m));
    }
}
