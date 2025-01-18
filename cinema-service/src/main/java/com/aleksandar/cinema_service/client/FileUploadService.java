package com.aleksandar.cinema_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "file-service",path = "/file-storage")
public interface FileUploadService {
    @PostMapping(value = "/upload/img", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<String> uploadImgToFileService(@RequestPart("image") MultipartFile file);

    @GetMapping(value="get/img/{name}")
    ResponseEntity<MultipartFile> GetImgByName(@PathVariable String name);

    @DeleteMapping(value="delete/img/{name}")
    ResponseEntity<Void> DeleteImgByName(@PathVariable String name);

    /*@PostMapping(value = "/upload/trailer",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<String> uploadTrailerToFileService(@RequestPart("trailer") MultipartFile file);

    @GetMapping(value="get/trailer/{name}")
    ResponseEntity<MultipartFile> GetTrailerByName(@PathVariable String name);

    @DeleteMapping(value="delete/trailer/{name}")
    ResponseEntity<Void> DeleteTrailerByName(@PathVariable String name);*/
}
