public class Main {
    public static void main(String[] args) {
        /*
         * Luua klass, mis muudaks ette antava lause tähestiku ulatuses mingisuguse nihkega arusaamatuks
         * Samuti eksisteeriks ka dešifreerija, et võimalik nihke ette andmisel funktsiooni selle sama sisendi tagasi muutma arusaadavaks
         * Lugeda failist esimesel real oleva nihke numbri ning ülejäänud read selle nihke abil šifreerida ning salvestada šifreeritud kujul teise faili.
         */
        int step = 5;
        String text = "Tere, minu nimi on Steven!";

        String cipheredText = Cipher.cipherText(text, step);

        System.out.println("Šifreeritud tekst: " + cipheredText);
        System.out.println("Dešifreeritud tekst: " + Decipher.decipherText(cipheredText, step));
    }
}