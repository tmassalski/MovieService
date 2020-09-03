package pl.tmassalski.MovieService.infrastructure.actor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tmassalski.MovieService.domain.actor.Actor;
import pl.tmassalski.MovieService.domain.actor.ActorCreatorClient;

@Service
@RequiredArgsConstructor
public class ActorPostgresCreatorClient implements ActorCreatorClient {

    private final ActorRepository actorRepository;

    @Override
    public void create(Actor actor) {
        actorRepository.save(actor);
    }
}
