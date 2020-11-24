package seleucus.wsp.HoneyChecker.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seleucus.wsp.HoneyChecker.model.UserDTO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@ComponentScan(basePackages = ("seleucus.wsp.HoneyChecker.controller"))
@EnableAutoConfiguration
public class HoneyCheckerServiceController {

    private static Map<String, String> usersData = null;

    @RequestMapping(method = RequestMethod.POST, value = "/validate", produces = "application/json")
    public ResponseEntity<Boolean> isValidWebSpaUser(@RequestBody UserDTO userDTO) {
        if (usersData == null) {
            csvReader();
        }
        boolean isValid = usersData.containsKey(userDTO.getUserName()) && usersData.get(userDTO.getUserName()).equals(userDTO.getId());
        return new ResponseEntity<Boolean>(isValid, HttpStatus.OK);
    }

    @RequestMapping(value = "/csvFile", method = RequestMethod.GET)
    @ResponseBody
    public void showCSVFile() {
        csvReader();
    }

    public void csvReader() {
        String csvFile = "F:/trunk/WebSpa/userID.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        usersData = new HashMap<>();

        try {
            br = new BufferedReader(new FileReader(csvFile));
            br.readLine(); //header line
            while ((line = br.readLine()) != null) {
                if (line.equals("")) {
                    continue;
                }
                String[] webSpaUsers = line.split(cvsSplitBy);
                usersData.put(webSpaUsers[0], webSpaUsers[1]);
                System.out.println("User Data map: " + usersData);
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
}
