package pl.tmassalski.MovieService.domain.actor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActorFacade {

    private final ActorRetrievalClient actorRetrievalClient;

    public ActorResponse getActorById(long id) {
        Actor actor = actorRetrievalClient.getById(id);
        return actor.generateResponse();
    }
}
