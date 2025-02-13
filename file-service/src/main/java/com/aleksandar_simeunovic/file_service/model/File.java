package com.aleksandar_simeunovic.file_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "files")
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

