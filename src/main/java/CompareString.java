import java.io.*;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class CompareString {

    public static void main(String... args) {
        String s1 = "10436 10 AVENUE NW";
        String s2 = "405 11523 100 AVENUE NW";
       // String val = longestCommonSubstring(s1,s2);
        long startTime = System.nanoTime();
        Instant start = Instant.now();
        createAuthFile("\n Stats");
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;


// CODE HERE
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();


        // 1 second = 1_000_000_000 nano seconds
        double elapsedTimeInSecond = (double) elapsedTime / 1_000_000_000;
        System.out.println("Start Time: "+start +"\n"+" End Time: "+finish+"\n");
        System.out.println("Elapsed time "+timeElapsed +" ms");
        for(int i=0;i<3;i++){
            createAuthFile(String.valueOf(timeElapsed)+" ms");
        }


    }

    public static void createAuthFile(String str){
        try {

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String filepath = "F://trunk/WebSpa/fileAuth.txt";
            File myObj = new File(filepath);
            if (!myObj.exists()) {
                myObj.createNewFile();
            } else {
           /*     String[] passphrases = new String[3];
                passphrases[0] = "1 ms";
                passphrases[1] = "2 ms";
                passphrases[2] = "3 ms";

                FileWriter myWriter = new FileWriter(filepath);
                for (String pass : passphrases) {
                    myWriter.write(pass);
                    myWriter.write("\n");
                }*/
              //  FileWriter myWriter = new FileWriter(filepath);
                FileWriter fileWriter = new FileWriter(filepath, true); //Set true for append mode
                PrintWriter printWriter = new PrintWriter(fileWriter);
                printWriter.println(str);  //New line
                printWriter.close();


           // myWriter.close();

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
