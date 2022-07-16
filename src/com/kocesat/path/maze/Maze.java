package com.kocesat.path.maze;

import java.util.*;

public class Maze {
    private final boolean directed;
    private Stack<MazeNode> path = new Stack<>();
    private Stack<MazeNode> waitingVisits = new Stack<>();

    public Maze(boolean directed) {
        this.directed = directed;
    }

    public String findPath(MazeNode startingNode, MazeNode finalNode) {
        waitingVisits.push(startingNode);
        return getString(findPathAndCollectStrings(finalNode));
    }

    private boolean pathExistsTo(MazeNode finalNode) {
        if (waitingVisits.isEmpty()) {
            return false;
        }
        MazeNode current = waitingVisits.pop();
        path.push(current);
        current.setVisited(true);
        if (current.equals(finalNode)) {
            return true;
        }
        for (MazeNode neighbor : current.getNeighbors()) {
            if (!neighbor.isVisited()) {
                waitingVisits.push(neighbor);
                if (pathExistsTo(finalNode)) {
                    return true;
                }
            }
        }
        path.pop();
        return false;
    }

    private List<String> findPathAndCollectStrings(MazeNode finalNode) {
        List<String> pathStrings = new ArrayList<>();
        if (pathExistsTo(finalNode)) {
            while (!path.isEmpty()) {
                pathStrings.add(path.pop().getValue());
            }
        }
        return pathStrings;
    }

    private String getString(List<String> pathStrings) {
        StringBuilder sb = new StringBuilder();
        for (int i = pathStrings.size() - 1; i >= 0; i--) {
            sb.append(pathStrings.get(i));
        }
        return sb.toString();
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
}
