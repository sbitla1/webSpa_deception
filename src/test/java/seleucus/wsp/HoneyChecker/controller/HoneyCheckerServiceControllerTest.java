package seleucus.wsp.HoneyChecker.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import seleucus.wsp.HoneyChecker.model.UserDTO;

import static org.junit.jupiter.api.Assertions.*;

class HoneyCheckerServiceControllerTest {



    @Test
    void csvReader() {

        boolean isValidFromHoneyCheckerService = false;
        RestTemplate restTemplate = new RestTemplate();

        //Call REST Api service here
        UserDTO userDTO = new UserDTO(Integer.toString(11), "skbitla");
        ResponseEntity<Boolean> honeyCheckerServiceResponse = null;
        honeyCheckerServiceResponse = restTemplate.postForEntity("http://localhost:8080" + "/validate", userDTO, Boolean.class);
        if (honeyCheckerServiceResponse.getBody().booleanValue()) {
            isValidFromHoneyCheckerService = true;
        }

        HoneyCheckerServiceController honeyCheckerServiceController = new HoneyCheckerServiceController();

        honeyCheckerServiceController.csvReader();
    }
}