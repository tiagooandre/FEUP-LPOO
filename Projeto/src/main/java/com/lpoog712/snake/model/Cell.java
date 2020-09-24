package com.lpoog712.snake.model;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Cell implements Element {
    private char direction;
    private Position position;

    public Cell(char direction, Position position) {
        this.direction = direction;
        this.position = position;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public char getDirection() {
        return direction;
    }

    public Position getPosition() {
        return position;
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#6e3d1a"));
        graphics.putString(position.getX(), position.getY(), "#");
    }
}