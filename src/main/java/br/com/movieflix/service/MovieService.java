package br.com.movieflix.service;

import br.com.movieflix.entity.Category;
import br.com.movieflix.entity.Movie;
import br.com.movieflix.entity.Streaming;
import br.com.movieflix.repository.MovieRepository;
import br.com.movieflix.service.CategoryService;
import br.com.movieflix.service.StreamingService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final CategoryService categoryService;
    private final StreamingService streamingService;

    @Transactional
    public Movie save(Movie movie) {
        // Buscamos as entidades gerenciadas pelo Hibernate antes de salvar
        movie.setCategories(this.findCategories(movie.getCategories()));
        movie.setStreamings(this.findStreamings(movie.getStreamings()));
        return movieRepository.save(movie);
    }

    @Transactional
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    // Alterado para Set para ser compatível com a correção da Entity
    private Set<Category> findCategories(Set<Category> categories) {
        if (categories == null || categories.isEmpty()) return Collections.emptySet();

        // Coletamos os IDs e buscamos todos de uma vez (evita o problema N+1)
        List<Long> ids = categories.stream().map(Category::getId).toList();
        return new HashSet<>(categoryService.findAllById(ids));
    }

    private Set<Streaming> findStreamings(Set<Streaming> streamings) {
        if (streamings == null || streamings.isEmpty()) return Collections.emptySet();

        List<Long> ids = streamings.stream().map(Streaming::getId).toList();
        return new HashSet<>(streamingService.findAllById(ids));
    }
}