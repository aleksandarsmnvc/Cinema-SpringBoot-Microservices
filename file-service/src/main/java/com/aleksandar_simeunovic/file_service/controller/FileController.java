package com.aleksandar_simeunovic.file_service.controller;

import com.aleksandar_simeunovic.file_service.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file-storage")
@RequiredArgsConstructor
public class FileController {
    private final FileService storageService;

    @PostMapping("/upload/img")
    public ResponseEntity<String> uploadImageToFileSystem(@RequestPart("image") MultipartFile file) {
        return ResponseEntity.ok().body(storageService.uploadImageToFileSystem(file));
    }

    @GetMapping("/download/img/{id}")
    public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable String id) {
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf("image/png"))
                .body(storageService.downloadImageFromFileSystem(id));
    }

    @DeleteMapping("/delete/img/{id}")
    public ResponseEntity<Void> deleteImageFromFileSystem(@PathVariable String id) {
        storageService.deleteImageFromFileSystem(id);
        return ResponseEntity.ok().build();
    }
}
