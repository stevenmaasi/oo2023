public class Main {
    public static void main(String[] args) {
        /*
         * Luua klass, mis muudaks ette antava lause tähestiku ulatuses mingisuguse nihkega arusaamatuks
         * Samuti eksisteeriks ka dešifreerija, et võimalik nihke ette andmisel funktsiooni selle sama sisendi tagasi muutma arusaadavaks
         * Lugeda failist esimesel real oleva nihke numbri ning ülejäänud read selle nihke abil šifreerida ning salvestada šifreeritud kujul teise faili.
         */
        String text = "Tere, minu nimi on Stevenä!";
        int step = 5;

        System.out.println(cipherText(text, step));
    }

    private static String cipherText(String text, int step) {
        String alphabet = "abcdefghijklmnopqrsšzžtuvõäöüxy";
        StringBuilder cipheredText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            boolean isLetter = Character.isLetter(character);

            if (isLetter) {
                int indexInAlphabet = alphabet.indexOf(Character.toLowerCase(character));

                char newCharacter;

                if (indexInAlphabet + step > alphabet.length()) {
                    int newIndex = indexInAlphabet + step - alphabet.length();
                    newCharacter = alphabet.charAt(newIndex);
                } else {
                    newCharacter = alphabet.charAt(indexInAlphabet + step);
                }

                cipheredText.append(newCharacter);
            } else {
                cipheredText.append(character);
            }
        }

        return cipheredText.toString();
    }
}