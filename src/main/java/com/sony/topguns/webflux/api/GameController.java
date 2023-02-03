package com.sony.topguns.webflux.api;

import com.sony.topguns.webflux.model.Game;
import com.sony.topguns.webflux.service.GameService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/games")
    public Flux<Game> getAllGames() {
        return gameService.getAllCustomers();
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/games/{id}")
    public Mono<Game> getById(Integer id) {
        return gameService.getById(id);
    }
}
