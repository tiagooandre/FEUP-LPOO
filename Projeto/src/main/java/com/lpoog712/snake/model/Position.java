package com.lpoog712.snake.model;

import java.util.Objects;
import java.util.Random;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position up() {
        return new Position(this.x, this.y - 1);
    }

    public Position down() {
        return new Position(this.x, this.y + 1);
    }

    public Position left() {
        return new Position(this.x - 1, this.y);
    }

    public Position right() {
        return new Position(this.x + 1, this.y);
    }

    public static Position randomPosition(Board board) {
        Random random = new Random();
        int x = random.nextInt(board.getWidth() - 2) + 1;
        int y = random.nextInt(board.getHeight() - 2) + 1;
        return new Position(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}