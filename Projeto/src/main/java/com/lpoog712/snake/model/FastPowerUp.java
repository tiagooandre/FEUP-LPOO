package com.lpoog712.snake.model;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class FastPowerUp implements PowerUp {
    Position position;

    public FastPowerUp(Position position) {
        this.position = position;
    }

    @Override
    public void applyEffect(Board board) {
        board.setSpeedsnake(board.getSpeedsnake() - 100);
        if (board.getSpeedsnake() < 100) {
            board.setSpeedsnake(100);
        }
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#3d8f3d"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#002aff"));
        graphics.putString(position.getX(), position.getY(), "+");
    }

    @Override
    public Position getPosition() {
        return position;
    }
}
