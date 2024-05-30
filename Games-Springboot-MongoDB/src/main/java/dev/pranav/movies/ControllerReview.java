package dev.pranav.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/Reviews")
public class ControllerReview {
    @Autowired
    private ServiceReview serviceReview;

    @PostMapping
    public ResponseEntity<Reviews> create(@RequestBody Map<String, String> pay){
        return new ResponseEntity<Reviews>(serviceReview.create(pay.get("body"), pay.get("appId")), HttpStatus.CREATED);
    }

}
