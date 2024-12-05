package com.aleksandar.cinema_service;

import com.aleksandar.cinema_service.model.Movie;
import com.aleksandar.cinema_service.repository.MovieRepository;
import com.aleksandar.cinema_service.service.MovieService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.awaitility.Awaitility.given;

@SpringBootTest
class MovieServiceApplicationTests {

	@Mock
	private MovieRepository movieRepository;

	@InjectMocks
	private MovieService movieService;

	@Test
	@ExtendWith(MockitoExtension.class)
	void MovieServiceGetTestHappyFlow() {
		Movie movie=Movie.builder().movie_id(1)
				.name("SomeName")
				.description("SomeDescription")
				.cover_image("SomeCoverImage")
				.director("SomeDirector")
				.trailer("SomeTrailer")
				.build();
		given(movieRepository.findById(1))
				.willReturn(Optional.of(movie));


	}

}
