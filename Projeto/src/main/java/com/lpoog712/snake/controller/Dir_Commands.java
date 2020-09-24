package com.lpoog712.snake.controller;

import com.lpoog712.snake.model.Cell;
import com.lpoog712.snake.model.Snake;

public class Dir_Commands extends Command {
    private final Snake snake;

    public Dir_Commands(Snake snake) {
        this.snake = snake;
    }

    @Override
    public void execute() {
        Cell tail = snake.getCells().remove(snake.getCells().size() - 1);

        if (snake.getHead().getDirection() == 'N') {
            tail.setPosition(snake.getHead().getPosition().up());
            tail.setDirection('N');

        }
        else if (snake.getHead().getDirection() == 'S') {
            tail.setPosition(snake.getHead().getPosition().down());
            tail.setDirection('S');
        }
        else if (snake.getHead().getDirection() == 'E') {
            tail.setPosition(snake.getHead().getPosition().right());
            tail.setDirection('E');
        }
        else if (snake.getHead().getDirection() == 'W') {
            tail.setPosition(snake.getHead().getPosition().left());
            tail.setDirection('W');
        }
        snake.addFront(tail);
    }
}
