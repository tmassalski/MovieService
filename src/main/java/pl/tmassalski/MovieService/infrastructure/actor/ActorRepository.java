package pl.tmassalski.MovieService.infrastructure.actor;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tmassalski.MovieService.domain.actor.Actor;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
