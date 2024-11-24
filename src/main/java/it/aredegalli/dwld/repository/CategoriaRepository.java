package it.aredegalli.dwld.repository;

import it.aredegalli.dwld.model.DwldCat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<DwldCat, Long> {

    List<DwldCat> findAllByUserIdOrderByOrder(Long userId);

    List<DwldCat> findAllByUserIdAndAndDwldCatPdrIdOrderByOrder(Long userId, Long parentId);

}
