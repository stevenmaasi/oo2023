package ee.steven.kt2;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutoRepository extends JpaRepository<Auto, Long> {
    List<Auto> findByMark(String mark);

    List<Auto> findByPikkusBetween(double minLength, double maxLength);

    List<Auto> findByMassBetween(double minMass, double maxMass);

    List<Auto> findByOmanik(Omanik omanik);
}
