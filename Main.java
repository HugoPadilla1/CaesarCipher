/**
 * class: Main
 * @author: Hugo Padilla
 * @date: April 25, 2023
 * @version: 1.0
 * @course: ITEC 2140 - 05 Spring 2023
 * Description: In this main method, I want the user to be able to input their message, choose a key, and decide whether
 * or not they wish to decrypt or encrpyt the following message. This class should be able to refer to the CaesarCipher in order
 * to successfully complete the operation.
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a message: ");
        String message = scanner.nextLine(); // This obtains the message we are going to either encrypt or decrypt.

        System.out.print("Enter a key value: ");
        int key = scanner.nextInt(); // This acts as our 'code', which communicates with the CaesarCipher class,
                                     // What happens is this key is translated into the 'shift', how many spaces our character shift.

        CaesarCipher cipher = new CaesarCipher(key); // Refers back to the CaesarCipher class in order to make a new instance.

        System.out.print("Encrypt or decrypt? ");
        String operation = scanner.next(); // Reads for keywords, 'encrypt' or 'decrypt'.
        scanner.close();

        String result;
        if (operation.equalsIgnoreCase("encrypt")) {
            result = cipher.encrypt(message); // encrypt the message
        } else if (operation.equalsIgnoreCase("decrypt")) {
            result = cipher.decrypt(message); // decrypt the message
        } else {
            System.out.println("Input invalid, please enter either 'encrypt' or 'decrypt'."); // in case of error.
            return;
        }

        System.out.println("Result: " + result); // Finally, prints our result, either encrypted or decrypted. 
    }
}