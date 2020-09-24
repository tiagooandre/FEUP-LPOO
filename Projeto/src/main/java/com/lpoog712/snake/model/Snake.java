package com.lpoog712.snake.model;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<Cell> cells;

    public Snake(Position position) {
        cells = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            cells.add(new Cell('N', position));
            position = position.down();
        }
    }

    //Unit testing
    // --- head = cells.get(0)
    public void move() {
        cells.get(0).setPosition(new Position(cells.get(0).getPosition().getX(), cells.get(0).getPosition().getY() - 1));
        for (Cell cell : cells) {
            cell.setPosition(new Position(cell.getPosition().getX(), cell.getPosition().getY() - 1));
        }
    }

    //Unit testing
    public void turnRight() {
//        cells.get(0).setPosition(new Position(cells.get(0).getPosition().getX() + 1, cells.get(0).getPosition().getY()));
        for (Cell cell : cells) {
            cell.setPosition(new Position(cell.getPosition().getX() + 1, cell.getPosition().getY()));
        }
    }

    public List<Cell> getCells() {
        return cells;
    }

    public Cell getHead() {
        return cells.get(0);
    }

    public Cell getTail() {
        return this.cells.get(this.cells.size() - 1);
    }

    public void addFront(Cell cell) {
        this.cells.add(0, cell);
    }

    public char getHeadDirection() {
        return cells.get(0).getDirection();
    }

    public char getTailDirection() {
        return cells.get(this.cells.size() - 1).getDirection();
    }

    public List<Cell> getBody() {
        List<Cell> body = new ArrayList<>();
        for (int i = 1; i < this.cells.size(); i++)
            body.add(cells.get(i));
        return body;
    }

    public void increaseSize() {
        switch (this.getTailDirection()) {
            case 'N':
                this.cells.add(new Cell('N', this.getTail().getPosition().down()));
                break;
            case 'S':
                this.cells.add(new Cell('S', this.getTail().getPosition().up()));
                break;
            case 'W':
                this.cells.add(new Cell('W', this.getTail().getPosition().right()));
                break;
            case 'E':
                this.cells.add(new Cell('E', this.getTail().getPosition().left()));
                break;
        }
    }

}
