package com.lpoog712.snake;

import com.lpoog712.snake.model.Board;
import com.lpoog712.snake.model.Position;
import com.lpoog712.snake.model.Snake;
import org.junit.Assert;
import org.junit.Test;

public class SnakeTest {
    @Test
    public void snakeMoving() {
        Snake snake = new Snake(new Position(10, 10));
        snake.move();
        Assert.assertNotEquals(new Position(10, 10), snake.getHead().getPosition());
    }

    @Test
    public void snakeControlled() {
        Snake snake = new Snake(new Position(10, 10));
        snake.turnRight();
        Position position = new Position(11, 10);
        Assert.assertEquals(position, snake.getHead().getPosition());
    }
}
