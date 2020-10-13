package pl.tmassalski.MovieService.domain.director;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DirectorCreator {

    private final DirectorCreatorClient directorCreatorClient;

    @Transactional
    public Director create(DirectorCreatorCommand directorCreatorCommand) {
        Director director = Director.generate(directorCreatorCommand);
        directorCreatorClient.create(director);
        return director;
    }
}
