public class Player extends Character {
    Direction direction;
    Item item;

    public Player(int worldWidth, int worldHeight) {
        super(worldWidth, worldHeight, 'X');
        this.direction = Direction.UP;
    }

    public void move(String input, World world) {
        switch (input) {
            case "w" -> this.direction = Direction.UP;
            case "s" -> this.direction = Direction.DOWN;
            case "a" -> this.direction = Direction.LEFT;
            case "d" -> this.direction = Direction.RIGHT;
        }

        if (direction.equals(Direction.UP) && this.yCoordinate > 1) {
            this.yCoordinate = this.yCoordinate - 1;
        } else if (direction.equals(Direction.DOWN) && this.yCoordinate < world.height-2) {
            this.yCoordinate = this.yCoordinate + 1;
        } else if (direction.equals(Direction.LEFT) && this.xCoordinate > 1) {
            this.xCoordinate = this.xCoordinate - 1;
        } else if (direction.equals(Direction.RIGHT) && this.xCoordinate < world.width-2) {
            this.xCoordinate = this.xCoordinate + 1;
        }
    }
}
