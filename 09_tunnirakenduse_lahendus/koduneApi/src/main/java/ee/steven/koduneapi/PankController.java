package ee.steven.koduneapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PankController {
    Pank pank = new Pank(1, "swed", 50, 15000, true);

    @GetMapping("pank")
    public Pank saaPank() {
        return pank;
    }

    @GetMapping("panga-kood")
    public String saaPangaKood() {
        return pank.getKood();
    }

    @GetMapping("panga-min-laen")
    public double saaPangaMinLaen() {
        return pank.getMinLaenuSumma();
    }

    @GetMapping("panga-max-laen")
    public double saaPangaMaxLaen() {
        return pank.getMaxLaenuSumma();
    }

    @GetMapping("panga-staatus")
    public boolean saaPangaStaatus() {
        return pank.isAktiivne();
    }

    @PatchMapping("muuda-aktiivsust")
    public Pank muudaAktiivsus() {
        pank.setAktiivne( !pank.isAktiivne() );
        return pank;
    }
}
