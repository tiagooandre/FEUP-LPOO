package com.lpoog712.snake.controller;

import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class QuitCommand extends Command {
    private Screen screen;

    public QuitCommand(Screen screen) {
        this.screen = screen;
    }

    @Override
    public void execute() {
        try {
            screen.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
