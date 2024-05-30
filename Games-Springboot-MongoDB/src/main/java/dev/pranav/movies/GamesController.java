package dev.pranav.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/games")
public class GamesController {
    @Autowired
    private GameService gameService;
    @GetMapping
    public ResponseEntity<List<games>> getAllGames(){
        return new ResponseEntity<List<games>>(gameService.allGames(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<games>> getSingleGame(@PathVariable Integer id){
        return new ResponseEntity<Optional<games>>(gameService.singleGame(id), HttpStatus.OK);
    }

}
