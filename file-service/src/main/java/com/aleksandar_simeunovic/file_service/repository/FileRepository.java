package com.aleksandar_simeunovic.file_service.repository;

import com.aleksandar_simeunovic.file_service.model.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, String> {
}
