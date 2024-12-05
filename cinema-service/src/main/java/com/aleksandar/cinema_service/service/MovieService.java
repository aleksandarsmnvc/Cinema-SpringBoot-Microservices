package com.aleksandar.cinema_service.service;

import com.aleksandar.cinema_service.dto.MovieDTO;
import com.aleksandar.cinema_service.model.Movie;
import com.aleksandar.cinema_service.repository.MovieRepository;
import com.aleksandar.cinema_service.request.MovieCreateRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    @Autowired
    private MovieRepository repository;
    private final FileUploadService file_service;

    public Movie getMovie(int id) throws EntityNotFoundException{
        return repository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Movie not found with id:"+id));
    }

    public List<Movie> getAllMovies(){
        return repository.findAll();
    }

    public void addMovie(MovieCreateRequest request, MultipartFile cover_file,MultipartFile trailer_file){
        String cover_image=null;
        if(cover_file!=null)
            cover_image=file_service.uploadMovieCoverImg(cover_file).getBody();

        String trailer=null;
        if(trailer_file!=null)
            trailer=file_service.uploadMovieTrailer(trailer_file).getBody();

        repository.save(Movie.builder()
                .name(request.getName())
                .cover_image(cover_image)
                .description(request.getDescription())
                .director(request.getDirector())
                .trailer(trailer)
                .build());
    }

}
