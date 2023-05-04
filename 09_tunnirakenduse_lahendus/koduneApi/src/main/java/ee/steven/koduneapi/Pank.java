package ee.steven.koduneapi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pank {
    private int id;
    private String kood;
    private double minLaenuSumma;
    private double maxLaenuSumma;
    private boolean aktiivne;
}
