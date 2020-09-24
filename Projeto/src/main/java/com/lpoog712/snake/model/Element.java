package com.lpoog712.snake.model;

import com.googlecode.lanterna.graphics.TextGraphics;

public interface Element {
    void draw(TextGraphics graphics);
    Position getPosition();
}
