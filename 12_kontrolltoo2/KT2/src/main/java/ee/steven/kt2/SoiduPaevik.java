package ee.steven.kt2;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class SoiduPaevik {
    @Id
    private Long id;
    private Date kuupaev;
    private double kilometraaz;
    @ManyToOne
    private Auto auto;
}
