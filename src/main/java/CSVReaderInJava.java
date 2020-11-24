import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReaderInJava {
    public static void main(String... args) {
        List<Address> address = readBooksFromCSV("F://Excel Test/TestDataCSV.csv");

        // let's print all the person read from CSV file
        for (Address b : address) {
            // for( int i = 0; i <= address.size(); i++)
            Address address1 = new Address();
            //System.out.println(Str.matches("(.*)Tutorials(.*)"));
            if (b.getMatches().contentEquals(b.getAddressToMatch())) {
                String value = b.getUniqueIds();
                System.out.println(value);
                address1.setMatches(value);
            }

            System.out.println(b.getAddresses() + ", " + b.getUniqueIds() + ", " + b.getAddressToMatch() + ", " + b.getMatches());
        }
    }

    private static String longestCommonSubstring(String S1, String S2) {
        int Start = 0;
        int Max = 0;
        for (int i = 0; i < S1.length(); i++) {
            for (int j = 0; j < S2.length(); j++) {
                int x = 0;
                while (S1.charAt(i + x) == S2.charAt(j + x)) {
                    x++;
                    if (((i + x) >= S1.length()) || ((j + x) >= S2.length())) break;
                }
                if (x > Max) {
                    Max = x;
                    Start = i;
                }
            }
        }
        return S1.substring(Start, (Start + Max));
    }

    public static int stringCompare(String str1, String str2) {

        int l1 = str1.length();
        int l2 = str2.length();
        int lmin = Math.min(l1, l2);

        for (int i = 0; i < lmin; i++) {
            int str1_ch = (int) str1.charAt(i);
            int str2_ch = (int) str2.charAt(i);

            if (str1_ch != str2_ch) {
                return str1_ch - str2_ch;
            }
        }

        // Edge case for strings like
        // String 1="Geeks" and String 2="Geeksforgeeks"
        if (l1 != l2) {
            return l1 - l2;
        }

        // If none of the above conditions is true,
        // it implies both the strings are equal
        else {
            return 0;
        }
    }

    static int MAX_CHAR = 26;

    static boolean twoStrings(String s1, String s2) {
        // vector for storing character occurrences
        boolean v[] = new boolean[MAX_CHAR];
        Arrays.fill(v, false);

        // increment vector index for every
        // character of str1
        for (int i = 0; i < s1.length(); i++)
            v[s1.charAt(i) - 'a'] = true;

        // checking common substring of str2 in str1
        for (int i = 0; i < s2.length(); i++)
            if (v[s2.charAt(i) - 'a'])
                return true;

        return false;
    }

    private static List<Address> readBooksFromCSV(String fileName) {
        List<Address> books = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                Address book = createBook(attributes);
                books.add(book);
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return books;
    }

    private static Address createBook(String[] metadata) {
        String addresses = metadata[0];
        String UniqueIds = metadata[1];
        String addressToMatch = metadata[2];
        String beds = metadata[3];
        String matches = "";
        // create and return book of this metadata
        return new Address(addresses, UniqueIds, addressToMatch, beds, matches);
    }

}
