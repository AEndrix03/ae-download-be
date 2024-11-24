package it.aredegalli.dwld.repository;

import it.aredegalli.dwld.model.DwldCatFileLnk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaFileLinkRepository extends JpaRepository<DwldCatFileLnk, Long> {

    List<DwldCatFileLnk> findAllDwldCatFileLinkByDwldCatIdAndUserIdOrderByOrder(Long categoriaId, Long userId);

    List<DwldCatFileLnk> findAllDwldCatFileLinkByDwldFileIdAndUserIdOrderByOrder(Long fileId, Long userId);

}
