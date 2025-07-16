/* Encryption Program
   Purpose: To encrypt and decrypt secret messages :D
   @author Terry Zhou, Max Deng
   @version Apr 2025
 */

// Import Scanner and java.io classes
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner kb = new Scanner(System.in);

        // constants and variables
        String original = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
        String cipher = "48<D3F6#!JK1M^09QR57UVW*Y2_";

        System.out.println("Welcome to Military Intelligence, Section 6 Encryption Software");
        System.out.println("----------------------------------------------------------");
        // Ask user to choose encrypt or decrypt
        String choice;
        do {
            System.out.println("Menu:");
            System.out.println("Encrypt Message(E): ");
            System.out.println("Decrypt Message(D): ");
            System.out.println("Exit(Q): ");
            System.out.println("----------------------------------------------------------");

            // If it is encrypted
            choice = kb.nextLine();
            if (choice.equals("E")) {
                // Enter message
                System.out.println("Enter the message:");
                String message = kb.nextLine();
                // encrypt the encrypted message
                String encryptedMessage = encrypt(message, original, cipher);
                String upperLowerCase = upperLowerCase(message);
                // write the encrypted message
                System.out.println("The encrypted message is: " + encryptedMessage);
                System.out.println("The Upper/Lowercase is: " + upperLowerCase);

                storeEncryptedMessage("encryptedMessage.txt", encryptedMessage);
                storeEncryptedMessage("casingInfo.txt", upperLowerCase);

                //output
                System.out.println("Encrypted message saved to encryptedMessage.txt");
                System.out.println("Casing info saved to casingInfo.txt");

                System.out.println("----------------------------------------------------------");

            }
            //If it is decrypt
            else if (choice.equals("D")) {
                System.out.println("Read from the file(R) or Enter the message(M)?");
                String choise = kb.nextLine();

                // If read from file
                if (choise.equals("R")) {
                    String message = readFile("encryptedMessage.txt");
                    String upperLowerCase = readFile("casingInfo.txt");

                    System.out.println("Encrypted message read: " + message);
                    System.out.println("Casing pattern read: " + upperLowerCase);

                    //output
                    String decryptedMessage = decrypt(message, original, cipher, upperLowerCase);
                    System.out.println("The decrypted message is: " + decryptedMessage);
                    System.out.println("----------------------------------------------------------");

                }
                //if user Enter the message
                else if (choise.equals("M")) {
                    //Input message from user
                    System.out.println("Enter the message:");
                    String message = kb.nextLine();

                    String upperLowerCase;

                    //upper/lower case input
                    do {
                        System.out.println("Enter if it is Uppercase or Lowercase (eg. Hello = Ullll): ");
                        upperLowerCase = kb.nextLine();
                        if (upperLowerCase.length() != message.length()) {
                            System.out.println("Length mismatch. Make sure your pattern matches the number of characters!");
                        }
                    }
                    while (upperLowerCase.length() != message.length());
                    //call message and output
                    String decryptedMessage = decrypt(message, original, cipher, upperLowerCase);
                    System.out.println("The decrypted message is: " + decryptedMessage);
                    System.out.println("----------------------------------------------------------");
                }
                else {
                    System.out.println("Invalid Input. Please choose R or M.");
                }


            }
            //If quit
            else if (!choice.equals("Q")) {
                System.out.println("Invalid Input. Please choose E, D, or Q.");
            }
        } while (!choice.equals("Q"));
        System.out.println("Bon Voyage!");
    } // main method end

    //----------------------------------------------------------
    // encrypt method declaration
    public static String encrypt(String message, String alphabet, String cipher) {
        String encryptMessage = "";
        message = message.toUpperCase();
        for (int i = 0; i < message.length(); i++) {
            char currentAlphabet = message.charAt(i);
            int index = alphabet.indexOf(currentAlphabet);

            char currentCipher = cipher.charAt(index);
            encryptMessage += currentCipher;
        }
        return encryptMessage;
    }

    public static String upperLowerCase(String message) {
        String upperLowerCase = "";
        for (int i = 0; i < message.length(); i++) {
            char currentAlphabet = message.charAt(i);

            if (Character.isUpperCase(currentAlphabet))
                upperLowerCase += "U";
            else if (Character.isLowerCase(currentAlphabet))
                upperLowerCase += "l";
            else
                upperLowerCase += " ";
        }
        return upperLowerCase;
    }
    // encrypt method end

    //----------------------------------------------------------
    // decrypt method declaration
    public static String decrypt(String message, String alphabet, String cipher, String upperLowerCase) {
        String decryptMessage = "";
        message = message.toUpperCase();
        for (int i = 0; i < message.length(); i++) {
            char currentCipher = message.charAt(i);
            int index = cipher.indexOf(currentCipher);

            char currentAlphabet = alphabet.charAt(index);

            if (upperLowerCase.charAt(i) == 'U')
                currentAlphabet = Character.toUpperCase(currentAlphabet);
            if (upperLowerCase.charAt(i) == 'l')
                currentAlphabet = Character.toLowerCase(currentAlphabet);

            decryptMessage += currentAlphabet;


        }
        return decryptMessage;
    }
    // decrypt method end

    // saveEncrypted Message method declaration
    public static void storeEncryptedMessage(String filename, String message) throws IOException {
        File file = new File(filename);
        PrintWriter writer = new PrintWriter(file);

        writer.write(message);
        writer.close();
    }
    // file read method declaration
    public static String readFile(String filename) throws IOException {
        File file = new File(filename);
        Scanner input = new Scanner(file);

        String message = "";
        while (input.hasNextLine()) {
            message += input.nextLine();
        }
        input.close();
        return message;
    }
    // writeCipher method end


    // EncryptionTemplate class end
}