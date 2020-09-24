package com.lpoog712.snake.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    private int height;
    private int width;
    private Snake snake;
    private List<PowerUp> powerUps = new ArrayList<>();
    private List<Wall> walls = new ArrayList<>();
    private int speedsnake;
    private int defaultspeed;
    private boolean gameOver;
    private int powerUptime;

    public Board(int height, int width, Snake snake) {
        this.height = height;
        this.width = width;
        this.snake = snake;
        this.speedsnake = 100;
        this.defaultspeed = this.speedsnake;
        this.gameOver = false;

        powerUps.add(new Food(new Position(20, 20)));
        powerUptime = 0;

        createWalls();
    }

    public Snake getSnake() {
        return snake;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getSpeedsnake() {
        return speedsnake;
    }

    public void setSpeedsnake(int speedsnake) {
        this.speedsnake = speedsnake;
    }

    public void setPowerUptime(int powerUptime) {
        this.powerUptime = powerUptime;
    }

    public void removePowerUps() {
        this.powerUps.removeIf(powerUp -> !(powerUp instanceof Food));
    }

    public void resetSpeed() {
        this.speedsnake = defaultspeed;
    }

    public void resetValues() {
        this.speedsnake = this.defaultspeed;
        this.powerUps.removeIf(powerUp -> !(powerUp instanceof Food));
    }

    public void showPowerUp() {
        Random random = new Random();
        int chance = random.nextInt(6);

        switch (chance) {
            case 0:
                this.powerUps.add(new FastPowerUp(Position.randomPosition(this)));
                break;
            case 1:
                this.powerUps.add(new SlowPowerUp(Position.randomPosition(this)));
            default:
                break;
        }
    }

    public void createWalls() {
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(new Position(c, 0)));
            walls.add(new Wall(new Position(c, height - 1)));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(new Position(0, r)));
            walls.add(new Wall(new Position(width - 1, r)));
        }
    }

    public void checkCollision() {
        Wall wall = (Wall) getCollidingElement(snake.getHead().getPosition(), walls);
        if (wall != null) {
            gameOver = true;
        }

        Cell cell = (Cell) getCollidingElement(snake.getHead().getPosition(), snake.getBody());
        if (cell != null) {
            gameOver = true;
        }

        PowerUp powerUp = (PowerUp) getCollidingElement(snake.getHead().getPosition(), powerUps);
        if (powerUp != null) {
            powerUp.applyEffect(this);

            if (powerUptime == 3) {
                this.resetValues();
            }

            if (!(powerUp instanceof Food)) {
                powerUps.remove(powerUp);
                powerUptime = 0;
            } else {
                powerUptime++;
            }

            this.showPowerUp();
        }
    }

    private Element getCollidingElement(Position position, List<? extends Element> elements) {
        for (Element element : elements) {
            if (element.getPosition().equals(position)) {
                return element;
            }
        }
        return null;
    }

    public List<Element> getAllElements() {
        List<Element> elements = new ArrayList<>();

        elements.addAll(snake.getCells());
        elements.addAll(walls);
        elements.addAll(powerUps);

        return elements;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void gameOver() {
        System.out.println("Game Over!");
    }
}
