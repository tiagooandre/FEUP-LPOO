package com.lpoog712.snake.controller;

import com.lpoog712.snake.model.Cell;
import com.lpoog712.snake.model.Snake;

public class MoveUpCommand extends Command {
    private Snake snake;

    public MoveUpCommand(Snake snake) {
        this.snake = snake;
    }

    @Override
    public void execute() {
        Cell tail = snake.getCells().remove(snake.getCells().size() - 1);
        tail.setPosition(snake.getHead().getPosition().up());
        tail.setDirection('N');
        snake.addFront(tail);
    }
}
