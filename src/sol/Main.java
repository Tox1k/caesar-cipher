package sol;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    while(true) {
        System.out.println("[*]Caesar Cipher by sol[*]");
        System.out.println("1. Encrypt Text");
        System.out.println("2. Decrypt Text");
        System.out.println("3. Exit");
        System.out.print("[*]: ");
        int select = Integer.parseInt(input.nextLine());
        if(select == 3)break;
        System.out.println("Type the text:");
        Text inputText = new Text(input.nextLine());
        System.out.print("type the key: ");
        int key = Integer.parseInt(input.nextLine());
        String output = "";
        switch (select){
            case 1:
                output = encryptCaesar(inputText, key);
                break;
            case 2:
                output = decryptCaesar(inputText, key);
                break;
        }
        System.out.println("[*]Output:\n" + output + '\n');
    }

    System.out.println("Exiting program...");
    }
    public static String encryptCaesar(Text plaintext, int key){
        int offset = 26;
        key %= offset;
        String encryptedMessage = "";
        for(int i = 0; i < plaintext.length(); i++){

            int c = plaintext.asciiAt(i);
            //defaults to the text char, modifies it only if in range A-Z or a-z
            char outChar = plaintext.charAt(i);

            /*if(c < 'A' || (c > 'Z' && c < 'a') || c > 'z'){
                outChar = (char)c;
            }*/

            if(c >= 'A' && c <= 'Z'){
                if(c + key > 'Z'){
                    outChar = (char)(c + key - offset);
                }else{
                    outChar = (char)(c + key);
                }
            }

            if(c >= 'a' && c <= 'z'){
                if(c + key > 'z'){
                    outChar = (char)(c + key - offset);
                }else{
                    outChar = (char)(c + key);
                }
            }

            encryptedMessage += outChar;
        }
        return encryptedMessage;
    }
    public static String decryptCaesar(Text ciphertext, int key){
        int offset = 26;
        key %= offset;
        String decryptedMessage = encryptCaesar(ciphertext,offset - key);
        return decryptedMessage;
    }
}
