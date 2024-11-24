package it.aredegalli.dwld.repository;

import it.aredegalli.dwld.model.DwldFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<DwldFile, Long> {
}
