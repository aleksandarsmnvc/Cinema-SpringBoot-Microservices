package com.aleksandar.cinema_service.service;

import com.aleksandar.cinema_service.dto.CinemaDTO;
import com.aleksandar.cinema_service.model.Cinema;
import com.aleksandar.cinema_service.client.FileUploadService;
import com.aleksandar.cinema_service.repository.CinemaRepository;
import com.aleksandar.cinema_service.request.CinemaCreateRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CinemaService {
    @Autowired
    private final CinemaRepository cinemaRepository;
    private final FileUploadService file_service;

    public Cinema getCinema(int id)throws EntityNotFoundException{
        return cinemaRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Cinema not found with id:"+id));
    }

    public List<Cinema> getAllCinema(){
        return cinemaRepository.findAll();
    }

    public void addCinema(CinemaCreateRequest request, MultipartFile cover_file){

        String cover_image=null;
        if(cover_file!=null)
            cover_image=file_service.uploadImgToFileService(cover_file).getBody();

        cinemaRepository.save(Cinema.builder()
                .name(request.getName())
                .cover_image(cover_image)
                .description(request.getDescription())
                .city(request.getCity())
                .country(request.getCountry())
                .build());
    }
}
