package ee.steven.toiduaineteproovikas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ToiduaineController {
    @Autowired
    ToiduaineRepository toiduaineRepository;

    @Autowired
    ToiduKomponentRepository toiduKomponentRepository;

    @GetMapping("saa-rasv")
    public int saaRasv(
            @RequestParam Long id
    ) {
        ToiduKomponent toiduKomponent = toiduKomponentRepository.findById(id).get();
        //toiduKomponent.getToiduaine().getRasv() * toiduKomponent.getKogus()

        // TODO lindistuselt peale pausi edasi vaadata
        return 0;
    }


    @GetMapping("lisa-toidukomponent")
    public List<ToiduKomponent> lisaToidukomponent(
            @RequestParam Long id,
            @RequestParam Long toiduaineId,
            @RequestParam int kogus
    ) {
        Toiduaine toiduaine = toiduaineRepository.findById(toiduaineId).get();
        toiduKomponentRepository.save(new ToiduKomponent(id, toiduaine,kogus));
        return toiduKomponentRepository.findAll();
    }


    @GetMapping("lisa-toiduaine")
    public List<Toiduaine> lisaToiduaine(
            @RequestParam Long id,
            @RequestParam String nimetus,
            @RequestParam int valk,
            @RequestParam int rasv,
            @RequestParam int sysivesik
    ) throws Exception {
        if (valk + rasv + sysivesik > 100) {
            throw new Exception("Protsent ei saa olla üle 100");
        }
        toiduaineRepository.save(new Toiduaine(id, nimetus, valk, rasv, sysivesik));
        return toiduaineRepository.findAll();
    }
}
