package br.com.movieflix.mapper;

import br.com.movieflix.controller.request.MovieRequest;
import br.com.movieflix.controller.response.CategoryResponse;
import br.com.movieflix.controller.response.MovieResponse;
import br.com.movieflix.controller.response.StreamingResponse;
import br.com.movieflix.entity.Category;
import br.com.movieflix.entity.Movie;
import br.com.movieflix.entity.Streaming;
import lombok.experimental.UtilityClass;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@UtilityClass
public class MovieMapper {

    public static Movie toMovie(MovieRequest request) {
        // Convertendo para Set para alinhar com a Entity
        Set<Category> categories = request.categories().stream()
                .map(categoryId -> Category.builder().id(categoryId).build())
                .collect(Collectors.toSet());

        Set<Streaming> streamings = request.streamings().stream()
                .map(streamingId -> Streaming.builder().id(streamingId).build())
                .collect(Collectors.toSet());

        return Movie.builder()
                .title(request.title())
                .description(request.description())
                .releaseDate(request.releaseDate())
                .rating(request.rating())
                .categories(categories)
                .streamings(streamings)
                .build();
    }

    public static MovieResponse toMovieResponse(Movie movie) {
        // Aqui mantemos List no Response, pois o JSON aceita melhor ordenação em arrays
        List<CategoryResponse> categories = movie.getCategories()
                .stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList();

        List<StreamingResponse> streamings = movie.getStreamings()
                .stream()
                .map(StreamingMapper::toStreamingResponse)
                .toList();

        return MovieResponse.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .description(movie.getDescription())
                .releaseDate(movie.getReleaseDate())
                .rating(movie.getRating())
                .categories(categories)
                .streamings(streamings)
                .build();
    }
}