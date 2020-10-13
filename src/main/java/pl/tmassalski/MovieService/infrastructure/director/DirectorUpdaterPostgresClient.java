package pl.tmassalski.MovieService.infrastructure.director;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tmassalski.MovieService.domain.director.Director;
import pl.tmassalski.MovieService.domain.director.DirectorUpdaterClient;

@Service
@RequiredArgsConstructor
public class DirectorUpdaterPostgresClient implements DirectorUpdaterClient {

    private final DirectorRepository directorRepository;

    @Override
    public void update(Director director) {
        directorRepository.save(director);

    }

    @Override
    public void delete(Long id) {
        directorRepository.deleteById(id);
    }
}
