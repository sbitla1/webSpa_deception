package seleucus.wsp.HoneyChecker;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class WriteCSVFile {

    public static void main(String[] args) throws IOException {

 /*       Scanner sc = new Scanner(System.in);
        System.out.print("Enter user id: ");
        int id = sc.nextInt();
        String user ="";

            System.out.print("Enter user name: ");
            user = sc.nextLine();

        for (int i = 0; i < id; i++) {
            csvSplit(id, user);
        }*/
        csvReader();
    }


    public static void csvReader() {
        String csvFile = "userID.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            HashMap<String, String> map = new HashMap<>();
            while ((line = br.readLine()) != null) {
                String[] webSpaUsers = line.split(cvsSplitBy);
                for (int i = 0; i < webSpaUsers.length; i++) {
                    map.put(webSpaUsers[i], webSpaUsers[i]);
                }

                System.out.println("WebSpa Users List [users= " + webSpaUsers[1] + " , Ids=" + webSpaUsers[0] + "]"+map);
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

    public void csvWriter(Integer id){
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File("KeyAdminUsersIDFile.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder builder = new StringBuilder();
        String columnNamesList = "Id,Name";
        // No need give the headers Like: id, Name on builder.append
        builder.append(columnNamesList + "\n");
        builder.append(id + ",");
        builder.append("Sandy");
        builder.append('\n');

        pw.write(builder.toString());
        pw.close();
        System.out.println("File Created with values" +builder.toString());
    }

    public static void csvSplit(Integer id, String string) throws IOException {
        List<List<String>> rows = Arrays.asList(
                Arrays.asList(id.toString(), string));


        FileWriter csvWriter = new FileWriter("new.csv");
        try {
            csvWriter.append("ID");
            csvWriter.append(",");
            csvWriter.append("username");
            csvWriter.append("\n");

            for (List<String> rowData : rows) {
                csvWriter.append(String.join(",", rowData));
                csvWriter.append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        csvWriter.flush();
        csvWriter.close();
    }
}