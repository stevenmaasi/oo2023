import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
         * Luua klass, mis muudaks ette antava lause tähestiku ulatuses mingisuguse nihkega arusaamatuks
         * Samuti eksisteeriks ka dešifreerija, et võimalik nihke ette andmisel funktsiooni selle sama sisendi tagasi muutma arusaadavaks
         * Lugeda failist esimesel real oleva nihke numbri ning ülejäänud read selle nihke abil šifreerida ning salvestada šifreeritud kujul teise faili.
         */

        // Step max = alphabet.length() = 31
        int step = 31;
        String text = "Tere, minu nimi on Steven!";
        String inputFilePath = "F:\\OOP2023\\oo2023\\05_kontrolltoo1\\KT1\\src\\file.txt";
        String outputFile = "output.txt";

        String cipheredText = Cipher.cipherText(text, step);

        System.out.println();
        System.out.println("Šifreeritud tekst: " + cipheredText);
        System.out.println("Dešifreeritud tekst: " + Decipher.decipherText(cipheredText, step));

        writeCipherToFile(inputFilePath, outputFile);
    }

    private static List<String> readFile(Path filePath) throws IOException {
        return Files.readAllLines(filePath);
    }

    private static List<String> cipherFileText(String inputFilePath) {
        List<String> lines = null;

        try {
            lines = readFile(Path.of(inputFilePath));
            int fileStep = Integer.parseInt(lines.get(0));

            for (int i = 1; i < lines.size(); i++) {
                lines.set(i, Cipher.cipherText(lines.get(i), fileStep));
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return lines;
    }

    private static void writeCipherToFile(String inputFilePath, String outputFile) {
        try {
            List<String> lines = cipherFileText(inputFilePath);

            if (lines.size() > 0) {
                FileWriter myWriter = new FileWriter(outputFile);

                for (int i = 1; i < lines.size(); i++) {
                    myWriter.write(lines.get(i) + '\n');
                }

                myWriter.close();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}