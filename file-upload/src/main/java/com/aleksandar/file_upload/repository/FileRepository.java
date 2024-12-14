package com.aleksandar.file_upload.repository;

import com.aleksandar.file_upload.model.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File,String> {

}
