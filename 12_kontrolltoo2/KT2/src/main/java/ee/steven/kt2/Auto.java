package ee.steven.kt2;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Auto {
    @Id
    private Long id;
    private double pikkus;
    private double mass;
    private String mark;
    @ManyToOne
    private Omanik omanik;
}
