package com.lpoog712.snake.model;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class SlowPowerUp implements PowerUp {
    Position position;

    public SlowPowerUp(Position position) {
        this.position = position;
    }

    @Override
    public void applyEffect(Board board) {
        board.setSpeedsnake(board.getSpeedsnake() + 100);
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#3d8f3d"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#00e5ff"));
        graphics.putString(position.getX(), position.getY(), "-");
    }

    @Override
    public Position getPosition() {
        return position;
    }
}
