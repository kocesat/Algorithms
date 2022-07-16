package com.kocesat.path.maze;

import java.util.*;

public class Maze {
    private boolean directed;
    private Stack<MazeNode> path = new Stack<>();
    private Stack<MazeNode> lastVisited = new Stack<>();

    public Maze(boolean directed) {
        this.directed = directed;
    }

    public String findPath(MazeNode from, MazeNode to) {
        lastVisited.push(from);
        List<String> pathStrings = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if (hasPath(to)) {
            while (!path.isEmpty()) {
                pathStrings.add(path.pop().getValue());
            }
        }
        for (int i = pathStrings.size() - 1; i >= 0; i--) {
            sb.append(pathStrings.get(i));
        }
        return sb.toString();
    }

    public boolean hasPath(MazeNode to) {
        if (lastVisited.isEmpty()) {
            return false;
        }
        MazeNode current = lastVisited.pop();
        path.push(current);
        current.setVisited(true);
        if (current.equals(to)) {
            return true;
        }
        for (MazeNode neighbor : current.getNeighbors()) {
            if (!neighbor.isVisited()) {
                lastVisited.push(neighbor);
                if (hasPath(to)) {
                    return true;
                }
            }
        }
        path.pop();
        return false;
    }

    public void appendNode(MazeNode from, MazeNode to) {
        from.addNeighbor(to);
        if (!directed) {
            to.addNeighbor(from);
        }
    }

    public boolean isDirected() {
        return directed;
    }

    public void setDirected(boolean directed) {
        this.directed = directed;
    }
}
