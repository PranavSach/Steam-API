package dev.pranav.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;
    public List<games> allGames(){
        return gameRepository.findAll();
    }
    public Optional<games> singleGame(Integer appId){
        return gameRepository.findGamesByAppId(appId);
    }

}
