package com.lpoog712.snake.model;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall implements Element {
    private final Position position;

    public Wall(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#402c1e"));
        graphics.putString(position.getX(), position.getY(), "X");
    }
}
