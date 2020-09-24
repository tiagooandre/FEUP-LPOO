package com.lpoog712.snake.controller;

import com.lpoog712.snake.model.Cell;
import com.lpoog712.snake.model.Snake;

public class MoveLeftCommand extends Command {
    private Snake snake;

    public MoveLeftCommand(Snake snake) {
        this.snake = snake;
    }

    @Override
    public void execute() {
        Cell tail = snake.getCells().remove(snake.getCells().size() - 1);
        tail.setPosition(snake.getHead().getPosition().left());
        tail.setDirection('W');
        snake.addFront(tail);
    }
}
