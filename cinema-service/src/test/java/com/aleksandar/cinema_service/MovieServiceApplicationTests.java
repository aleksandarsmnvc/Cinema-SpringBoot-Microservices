package com.aleksandar.cinema_service;

import com.aleksandar.cinema_service.model.Movie;
import com.aleksandar.cinema_service.repository.MovieRepository;
import com.aleksandar.cinema_service.service.MovieService;
import jakarta.persistence.EntityNotFoundException;
import org.assertj.core.api.OptionalIntAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.lenient;

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
		lenient().when(movieRepository.findById(movie.getMovie_id())).thenReturn(Optional.of(movie));

		Optional<Movie>opt=movieRepository.findById(movie.getMovie_id());
		if(opt.isPresent()){
			Movie test_movie=opt.get();
			Assertions.assertEquals(movie.getName(),"SomeName");
		}
		else throw new EntityNotFoundException("Not Found!");

	}

}
