package softuni.exam.instagraphlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.instagraphlite.models.models.entity.Pictures;

import java.util.List;
import java.util.Optional;

@Repository
public interface PictureRepository extends JpaRepository<Pictures, Long> {
    Optional<Pictures> findByPath(String path);

    boolean existsByPath(String path);

    List<Pictures> findAllBySizeGreaterThanOrderBySizeAsc(double size);

}
