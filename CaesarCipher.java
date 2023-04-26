/**
 * class: CaesarCipher
 * @author: Hugo Padilla
 * @date: April 25, 2023
 * @version: 1.0
 * @course: ITEC 2140 - 05 Spring 2023
 * Description: In this class, I want to be able to perform two methods encrypting, and decrypting.
 * In my encrypt method, I will transform a following message into the Caesar encryption format, excluding modes of punctuations and spaces.
 * In my decrypt method, I shold be able to reverse the following Cypher into normal english, or however the original was.
 */
public class CaesarCipher {
    private int shift; // the 'shift' integer will decide how many spaces we actually move our characters.

    public CaesarCipher(int shift) {
        this.shift = shift; // This grabs our 'key' integer from our main method, and puts it into our encryption/decryption methods.
    }

    public String encrypt(String message) {
        StringBuilder result = new StringBuilder(); // Makes a new string. 
        for (char c : message.toCharArray()) { // Translates all of our characters from our inital message.
            if (Character.isLetter(c)) { // Makes sure that our characters are letters.
                char base = Character.isUpperCase(c) ? 'A' : 'a'; // Checks for capitlization. 
                char shifted = (char) ((c - base + shift) % 26 + base); // Moves our characters based on our 'shift' value, as well as, the encryption method.
                result.append(shifted); // Writes the new encrypted message.
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public String decrypt(String message) {
        StringBuilder result = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                char shifted = (char) ((c - base - shift + 26) % 26 + base); // This acts as the key for a previously encrypted message, if the key value matches the previous one to encrypt a message, it should decrypt sucessfuly.
                result.append(shifted);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
