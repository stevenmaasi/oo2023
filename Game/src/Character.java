public class Character {
    int xCoordinate;
    int yCoordinate;
    char symbol;

    public Character(int worldWidth, int worldHeight, char symbol) {
        this.xCoordinate = getRandomCoordinate(worldWidth);
        this.yCoordinate = getRandomCoordinate(worldHeight);
        this.symbol = symbol;
    }

    private static int getRandomCoordinate(int worldDimension) {
        return (int) (Math.random() * (worldDimension - 2) + 1);
    }
}
