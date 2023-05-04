package ee.steven.koduneapi;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
public class PankListController {
    List<Pank> pangad = new ArrayList<>(Arrays.asList(
            new Pank(1, "swed", 50, 15000, true),
            new Pank(2, "lhv", 20, 35000, true),
            new Pank(3, "seb", 100, 25000, true),
            new Pank(4, "cit", 500, 10000, true)
    ));

    @GetMapping("pangad")
    public List<Pank> saaPangad() {
        return pangad;
    }

    @GetMapping("pangad-max")
    public double saaMaxLaenugaPank() {
        double max = 0;
        for (int i = 0; i < pangad.size(); i++) {
            if (i == 0) {
                max = pangad.get(i).getMaxLaenuSumma();
            }

            if (max < pangad.get(i).getMaxLaenuSumma()) {
                max = pangad.get(i).getMaxLaenuSumma();
            }
        }

        return max;
    }

    @GetMapping("pangad-min")
    public double saaMinLaenugaPank() {
        double min = 0;
        for (int i = 0; i < pangad.size(); i++) {
            if (i == 0) {
                min = pangad.get(i).getMinLaenuSumma();
            }

            if (min > pangad.get(i).getMinLaenuSumma()) {
                min = pangad.get(i).getMinLaenuSumma();
            }
        }

        return min;
    }

    @GetMapping("pangad-min-max")
    public double saaMinMaxLaenugaPank() {
        double min = 0;
        for (int i = 0; i < pangad.size(); i++) {
            if (i == 0) {
                min = pangad.get(i).getMaxLaenuSumma();
            }

            if (min > pangad.get(i).getMaxLaenuSumma()) {
                min = pangad.get(i).getMaxLaenuSumma();
            }
        }

        return min;
    }

    @DeleteMapping("kustuta-pank/{kood}")
    public List<Pank> kustutaToode(@PathVariable String kood) {
        for (int i = 0; i < pangad.size(); i++) {
            if (Objects.equals(pangad.get(i).getKood(), kood)) {
                pangad.remove(i);
            }
        }

        return pangad;
    }

    @PostMapping("lisa-pank")
    public List<Pank> lisaPankURLParameetritega(
            @RequestParam int id,
            @RequestParam String kood,
            @RequestParam double minLaenuSumma,
            @RequestParam double maxLaenuSumma,
            @RequestParam boolean aktiivne) {
        pangad.add(new Pank(id, kood, minLaenuSumma, maxLaenuSumma, aktiivne));
        return pangad;
    }
}
