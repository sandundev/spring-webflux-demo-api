package com.sony.topguns.webflux.service;

import com.sony.topguns.webflux.model.Game;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@Service
public class GameService {
    List<Game> games = Arrays.asList(
            new Game(1, "The Last of Us Part II"),
            new Game(2, "Spider-Man: Miles Morales"),
            new Game(3, "Demon's Souls"),
            new Game(4, "Ghost of Tsushima"),
            new Game(5, "Final Fantasy VII Remake"),
            new Game(6, "Resident Evil 3"),
            new Game(7, "Death Stranding"),
            new Game(8, "Call of Duty: Modern Warfare"),
            new Game(9, "MediEvil"),
            new Game(10, "Sekiro: Shadows Die Twice"),
            new Game(11, "Madden NFL 20"),
            new Game(12, "Tom Clancy's The Division 2"),
            new Game(13, "Red Dead Redemption 2"),
            new Game(14, "Days Gone"),
            new Game(15, "Borderlands 3"),
            new Game(16, "God of War"),
            new Game(17, "Call of Duty: Black Ops 4"),
            new Game(18, "Kingdom Hearts III"),
            new Game(19, "Spider-Man"),
            new Game(20, "Detroit: Become Human"),
            new Game(21, "Uncharted 4: A Thief's End"),
            new Game(22, "FIFA 20"),
            new Game(23, "Mortal Kombat 11"),
            new Game(24, "Rage 2"),
            new Game(25, "Apex Legends"),
            new Game(26, "Gran Turismo Sport"),
            new Game(27, "The Witcher 3: Wild Hunt"),
            new Game(28, "Fortnite"),
            new Game(29, "Overwatch"),
            new Game(30, "Monster Hunter: World"),
            new Game(31, "Destiny 2"),
            new Game(32, "Horizon Zero Dawn"),
            new Game(33, "The Elder Scrolls V: Skyrim"),
            new Game(34, "Call of Duty: Warzone"),
            new Game(35, "Wolfenstein: Youngblood"),
            new Game(36, "DOOM Eternal"),
            new Game(37, "Rainbow Six Siege"),
            new Game(38, "PUBG"),
            new Game(39, "Fortnite Chapter 2"),
            new Game(40, "NBA 2K20")
    );

    public Flux<Game> getAllCustomers() {
        return Flux.fromIterable(games)
                .delaySubscription(Duration.ofSeconds(5))
                .log();
//        return Flux.fromIterable(games)
//                .delayElements(Duration.ofSeconds(1)).log();
    }

    public Mono<Game> getById(Integer id) {
        return Mono.from(games.stream()
                        .filter(game -> game.getId().equals(id))
                        .findFirst()
                        .map(Mono::just)
                        .orElseGet(Mono::empty))
                .delayElement(Duration.ofSeconds(1));
    }
}
