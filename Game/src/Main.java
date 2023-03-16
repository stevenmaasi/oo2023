public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // String sõnaline = "Tere"
        // char täheline = "s" - üks täht
        // double komakohaga = 422.34343
        // float komakohaga = 331.2323F
        // boolean kahendväärtus = true/false
        // byte pisikenumber = 100
        // short lühikenumber = 312
        // long pikknumber = 1231232321L

        int worldWidth = 10;
        int worldHeight = 5;

        int playerXCoordinate = getRandomCoordinate(worldWidth);
        int playerYCoordinate = getRandomCoordinate(worldHeight);
        char playerSymbol = 'X';

        int dragonXCoordinate = getRandomCoordinate(worldWidth);
        int dragonYCoordinate = getRandomCoordinate(worldHeight);
        char dragonSymbol = 'D';

        int orcXCoordinate = getRandomCoordinate(worldWidth);
        int orcYCoordinate = getRandomCoordinate(worldHeight);
        char orcSymbol = 'O';

        for (int y = 0; y < worldHeight; y++) {
            System.out.println();
            for (int x = 0; x < worldWidth; x++) {
                if (y == 0 || y == worldHeight-1) {
                    System.out.print("-");
                } else if (x == 0 || x == worldWidth-1) {
                    System.out.print("|");
                } else {
                    findCharacter(playerXCoordinate, playerYCoordinate, playerSymbol, dragonXCoordinate, dragonYCoordinate, dragonSymbol, orcXCoordinate, orcYCoordinate, orcSymbol, y, x);
                }
            }
        }
    }

    private static int getRandomCoordinate(int coordinate) {
        return (int) (Math.random() * (coordinate - 2) + 1);
    }

    private static void findCharacter(
            int playerXCoordinate, int playerYCoordinate, char playerSymbol, int dragonXCoordinate, int dragonYCoordinate,
            char dragonSymbol, int orcXCoordinate, int orcYCoordinate, char orcSymbol, int mapY, int mapX
    ) {
        if (playerXCoordinate == mapX && playerYCoordinate == mapY) {
            System.out.print(playerSymbol);
        } else if (dragonXCoordinate == mapX && dragonYCoordinate == mapY) {
            System.out.print(dragonSymbol);
        } else if (orcXCoordinate == mapX && orcYCoordinate == mapY) {
            System.out.print(orcSymbol);
        } else {
            System.out.print(" ");
        }
    }
}