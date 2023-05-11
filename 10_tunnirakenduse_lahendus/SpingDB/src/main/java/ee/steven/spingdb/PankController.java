package ee.steven.spingdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PankController {
    @Autowired
    PankRepository pankRepository;

    @GetMapping("pank")
    public Optional<Pank> saaPank(@RequestParam Long id) {
        return pankRepository.findById(id);
    }

    @PostMapping("lisa-pank")
    public List<Pank> lisaPank(
            @RequestParam Long id,
            @RequestParam String kood,
            @RequestParam double minLaenuSumma,
            @RequestParam double maxLaenuSumma,
            @RequestParam boolean aktiivne
    ) {
        pankRepository.save(new Pank(id, kood, minLaenuSumma, maxLaenuSumma, aktiivne));

        return pankRepository.findAll();
    }

    @GetMapping("panga-kood")
    public String saaPangaKood(@RequestParam Long id) {
        Optional<Pank> pank = pankRepository.findById(id);

        if (pank.isPresent()) {
            return pank.get().getKood();
        }

        return "Panka id-ga " + id + " ei eksisteeri!";
    }

    @GetMapping("panga-max-laen")
    public double saaPangaMaxLaen(@RequestParam Long id) {
        Optional<Pank> pank = pankRepository.findById(id);
        return pank.map(Pank::getMaxLaenuSumma).orElse(0.0);

    }

    @GetMapping("panga-min-laen")
    public double saaPangaMinLaen(@RequestParam Long id) {
        Optional<Pank> pank = pankRepository.findById(id);
        return pank.map(Pank::getMinLaenuSumma).orElse(0.0);

    }

    @GetMapping("panga-staatus")
    public boolean muudaPangaStaatust(@RequestParam Long id) {
        return pankRepository.findById(id).get().isAktiivne();
    }

    @PatchMapping("muuda-aktiivsust")
    public List<Pank> muudaAktiivsust(@RequestParam Long id) {
        Pank pank = pankRepository.findById(id).orElseThrow(() -> new RuntimeException("Panka ei leitud!"));
        pank.setAktiivne(!pank.isAktiivne());
        pankRepository.save(pank);

        return pankRepository.findAll();
    }
}
