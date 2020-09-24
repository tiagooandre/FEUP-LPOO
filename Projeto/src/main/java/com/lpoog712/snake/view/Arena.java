package com.lpoog712.snake.view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.lpoog712.snake.controller.*;
import com.lpoog712.snake.model.Board;
import com.lpoog712.snake.model.Element;

import java.io.IOException;

public class Arena {
    private final TerminalScreen screen;
    private Board board;

    public Arena(Board board) throws IOException {
        TerminalSize terminalSize = new TerminalSize(board.getWidth(), board.getHeight());
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);

        Terminal terminal = terminalFactory.createTerminal();
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);   // we don't need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary

        this.board = board;
    }

    public TerminalScreen getScreen() {
        return screen;
    }

    public void draw() throws IOException {
        screen.clear();
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#3d8f3d"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(board.getWidth(), board.getHeight()), ' ');

        for (Element element : board.getAllElements())
            element.draw(graphics);
        screen.refresh();
    }

    public Command nextCommand() throws IOException {
        KeyStroke input = screen.pollInput();

        if (input == null) {
            return new Dir_Commands(board.getSnake());
        }

        if (input.getKeyType() == KeyType.ArrowDown && board.getSnake().getHeadDirection() != 'N') {
            return new MoveDownCommand(board.getSnake());
        }

        if (input.getKeyType() == KeyType.ArrowUp && board.getSnake().getHeadDirection() != 'S') {
            return new MoveUpCommand(board.getSnake());
        }

        if (input.getKeyType() == KeyType.ArrowLeft && board.getSnake().getHeadDirection() != 'E') {
            return new MoveLeftCommand(board.getSnake());
        }

        if (input.getKeyType() == KeyType.ArrowRight && board.getSnake().getHeadDirection() != 'W') {
            return new MoveRightCommand(board.getSnake());
        }

        if (input.getKeyType() == KeyType.Character && input.getCharacter() == 'q') {
            return new QuitCommand(screen);
        }

        return new Dir_Commands(board.getSnake());
    }

    public void gameOver() {
        try {
            Thread.sleep(3000);
            screen.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        board.gameOver();
    }
}
