import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CSVReader {
    public static void main(String[] args) throws IOException {
    csvReader();
    }

    public static void csvReader() {
        String csvFile = "F://Excel Test/TestDataCSV.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            HashMap<String, String> map = new HashMap<>();
            while ((line = br.readLine()) != null) {
                String[] webSpaUsers = line.split(cvsSplitBy);
                for (int i = 0; i < webSpaUsers.length; i++) {
                    if(webSpaUsers[2].contains(webSpaUsers[0])){
                        System.out.println("matches for"+webSpaUsers[2] +"is - "+webSpaUsers[1]);

                    }
                }

               // System.out.println("[addresses= " + webSpaUsers[0] +
               //         " , UniqueIds=" + webSpaUsers[1] +", addressToMatch= " + webSpaUsers[2] + " , beds=" + webSpaUsers[3] +", matches="+"]"+map);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static String longestCommonSubstring(String S1, String S2)
    {
        int Start = 0;
        int Max = 0;
        for (int i = 0; i < S1.length(); i++)
        {
            for (int j = 0; j < S2.length(); j++)
            {
                int x = 0;
                while (S1.charAt(i + x) == S2.charAt(j + x))
                {
                    x++;
                    if (((i + x) >= S1.length()) || ((j + x) >= S2.length())) break;
                }
                if (x > Max)
                {
                    Max = x;
                    Start = i;
                }
            }
        }
        return S1.substring(Start, (Start + Max));
    }

    public static void meth() {
        String file = "F://Excel Test/TestDataCSV.csv";
        String headers;
        String line;
        try (BufferedReader br =
                     new BufferedReader(new FileReader(file))) {
            headers = br.readLine();
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    }