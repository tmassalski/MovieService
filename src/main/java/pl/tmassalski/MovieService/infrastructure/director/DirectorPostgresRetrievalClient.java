package pl.tmassalski.MovieService.infrastructure.director;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tmassalski.MovieService.domain.director.Director;
import pl.tmassalski.MovieService.domain.director.DirectorRetrievalClient;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DirectorPostgresRetrievalClient implements DirectorRetrievalClient {

    private final DirectorRepository directorRepository;

    @Override
    public Director getById(Long id) {
        Optional<Director> result = directorRepository.findById(id);
        return result.orElseThrow();
    }

    @Override
    public List<Director> getAll() {
        return directorRepository.findAll();
    }
}
