import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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

        Scanner scanner = new Scanner(System.in);

        World world = new World(10, 5);
        Player player = new Player(world.width, world.height);
        Dragon dragon = new Dragon(world.width, world.height);
        Orc orc = new Orc(world.width, world.height);

        List<Character> characters = new ArrayList<>(Arrays.asList(player, dragon, orc));

        Item sword = new Item(10,1,"Mõõk", world.width, world.height);
        Item hammer = new Item(5,3,"Haamer", world.width, world.height);
        Item boot = new Item(1,10,"Saabas", world.width, world.height);

        List<Item> items = new ArrayList<>(Arrays.asList(sword, hammer, boot));

        world.printMap(
                world.width, world.height,
                player.xCoordinate, player.yCoordinate, player.symbol,
                dragon.xCoordinate, dragon.yCoordinate, dragon.symbol,
                orc.xCoordinate, orc.yCoordinate, orc.symbol, items
        );

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            player.move(input, world);
            world.printMap(world.width, world.height,
                    player.xCoordinate, player.yCoordinate, player.symbol,
                    dragon.xCoordinate, dragon.yCoordinate, dragon.symbol,
                    orc.xCoordinate, orc.yCoordinate, orc.symbol, items);
            System.out.println();
            for (Item i : items) {
                if (i.xCoordinate == player.xCoordinate && i.yCoordinate == player.yCoordinate) {
                    player.item = i;
                    System.out.println("Korjasid eseme: " + player.item.name);
                    break;
                }
            }
            input = scanner.nextLine();
        }
    }
}