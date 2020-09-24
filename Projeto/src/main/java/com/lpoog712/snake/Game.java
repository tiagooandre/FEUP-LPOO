package com.lpoog712.snake;

import com.lpoog712.snake.controller.Command;
import com.lpoog712.snake.controller.QuitCommand;
import com.lpoog712.snake.model.*;
import com.lpoog712.snake.view.Arena;

import java.io.IOException;

public class Game {
    private Board board;
    private Arena arena;
    public Game() throws IOException {
        Snake snake = new Snake(new Position(10, 10));
        this.board = new Board(30, 30, snake);
        this.arena = new Arena(board);
    }

    public void start() throws InterruptedException, IOException {
        while (!board.isGameOver()) {
            Thread.sleep(board.getSpeedsnake());
            Command command =  this.arena.nextCommand(); //IOException
            command.execute();
            if (command instanceof QuitCommand) {
                break;
            }
            // --- Collision
            board.checkCollision();
            this.draw();
        }
        arena.gameOver();
    }

    public void draw() {
        try {
            arena.draw();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
