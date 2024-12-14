package com.aleksandar.file_upload.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


    @Entity
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public class File {
        @Id
        private String id;
        private String type;
        private String filePath;
    }
