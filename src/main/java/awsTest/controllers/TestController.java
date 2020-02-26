package awsTest.controllers;

import awsTest.models.DBData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TestController {
    @GetMapping("/getData")
    public ResponseEntity<DBData> getDBData() {
        return new ResponseEntity(new DBData("testData"), HttpStatus.OK);
    }
}
