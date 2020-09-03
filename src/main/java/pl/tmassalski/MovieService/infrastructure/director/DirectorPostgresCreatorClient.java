package pl.tmassalski.MovieService.infrastructure.director;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tmassalski.MovieService.domain.director.Director;
import pl.tmassalski.MovieService.domain.director.DirectorCreatorClient;

@Service
@RequiredArgsConstructor
public class DirectorPostgresCreatorClient implements DirectorCreatorClient {

    private final DirectorRepository directorRepository;

    @Override
    public void create(Director director) {
        directorRepository.save(director);
    }
}
