package com.kocesat.path.maze;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MazeNode {
    private String value;
    private List<MazeNode> neighbors = new ArrayList<>();
    private boolean visited = false;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MazeNode)) return false;
        MazeNode mazeNode = (MazeNode) o;
        return Objects.equals(value, mazeNode.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public MazeNode(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MazeNode{" +
                "value=" + value +
                ", visited=" + visited +
                '}';
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<MazeNode> getNeighbors() {
        return List.copyOf(neighbors);
    }

    public MazeNode addNeighbor(MazeNode mazeNode) {
        this.neighbors.add(mazeNode);
        return this;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
