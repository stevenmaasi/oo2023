package ee.steven.spingdb;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pank {
    @Id
    private long id;
    private String kood;
    private double minLaenuSumma;
    private double maxLaenuSumma;
    private boolean aktiivne;
}
