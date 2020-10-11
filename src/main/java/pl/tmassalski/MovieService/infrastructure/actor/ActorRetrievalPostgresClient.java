package pl.tmassalski.MovieService.infrastructure.actor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tmassalski.MovieService.domain.actor.Actor;
import pl.tmassalski.MovieService.domain.actor.ActorRetrievalClient;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActorRetrievalPostgresClient implements ActorRetrievalClient {

    private final ActorRepository actorRepository;

    @Override
    public Actor getById(long id) {
        Optional<Actor> result = actorRepository.findById(id);
        return result.orElseThrow();
    }
}
