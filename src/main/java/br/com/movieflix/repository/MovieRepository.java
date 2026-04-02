package br.com.movieflix.repository;

import br.com.movieflix.entity.Movie;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @EntityGraph(attributePaths = {"categories", "streamings"})
    List<Movie> findAll();
}
