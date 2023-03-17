public class Decipher {
    String text;
    int step;

    public Decipher(String text, int step) {
        this.text = text;
        this.step = step;
    }

    public static String decipherText(String text, int step) {
        String alphabet = "abcdefghijklmnopqrsšzžtuvõäöüxy";
        StringBuilder cipheredText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            boolean isLetter = Character.isLetter(character);

            if (isLetter) {
                int indexInAlphabet = alphabet.indexOf(Character.toLowerCase(character));

                char newCharacter;

                if ((indexInAlphabet - step) < 0) {
                    int newIndex = indexInAlphabet - step + alphabet.length();
                    newCharacter = alphabet.charAt(newIndex);
                } else {
                    newCharacter = alphabet.charAt(indexInAlphabet - step);
                }

                cipheredText.append(newCharacter);
            } else {
                cipheredText.append(character);
            }
        }

        return cipheredText.toString();
    }
}
