package com.aleksandar.file_upload.controller;

import com.aleksandar.file_upload.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file-storage")
@RequiredArgsConstructor
public class StorageController {
    private final StorageService storageService;

    @PostMapping("/upload/img")
    public ResponseEntity<String> uploadImageToFileSystem(@RequestPart("image") MultipartFile file) {
        return ResponseEntity.ok().body(storageService.uploadImageToFileSystem(file));
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable String id) {
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf("image/png"))
                .body(storageService.downloadImageFromFileSystem(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteImageFromFileSystem(@PathVariable String id) {
        storageService.deleteImageFromFileSystem(id);
        return ResponseEntity.ok().build();
    }
}
