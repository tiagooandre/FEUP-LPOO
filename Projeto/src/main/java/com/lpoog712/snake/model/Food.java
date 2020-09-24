package com.lpoog712.snake.model;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Food implements PowerUp {
    private Position position;

    public Food(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#3d8f3d"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#cc0000"));
        graphics.putString(position.getX(), position.getY(), "#");
    }

    @Override
    public void applyEffect(Board board) {
        board.getSnake().increaseSize();
        this.position = Position.randomPosition(board);
    }
}
