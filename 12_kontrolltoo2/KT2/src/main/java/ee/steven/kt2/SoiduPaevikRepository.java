package ee.steven.kt2;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SoiduPaevikRepository extends JpaRepository<SoiduPaevik, Long> {
    List<SoiduPaevik> findSoiduPaevikByAuto(Auto auto);
}
