package net.seleucus.wsp.server.commands;

import java.util.Random;
import java.util.Scanner;

public class RandomPasswordGenerator {

    public static void main(String[] args) {

        // Get the size n
        int n = 10;

        // Get and display the alphanumeric string
        //System.out.println(RandomPasswordGenerator.getAlphaNumericString(n));

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter any number: ");

        // This method reads the number provided using keyboard
        int num = scan.nextInt();
        getAlphaNumericString(num);

        // Closing Scanner after the use
        scan.close();
    }

    // function to generate a random string of length n
    static String getAlphaNumericString(int numberofpassphrases) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        String generatedString=null;
        Random random = new Random();

        for (int j = 0; j < numberofpassphrases; j++) {
             generatedString = random.ints(leftLimit, rightLimit + 1)
                    .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
           // System.out.println(generatedString);
        }
        return generatedString;
    }


}
