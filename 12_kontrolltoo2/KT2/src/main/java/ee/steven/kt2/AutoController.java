package ee.steven.kt2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AutoController {
    @Autowired
    AutoRepository autoRepository;

    @GetMapping("get-by-mark")
    public List<Auto> getByMark(@RequestParam String mark) {
        return autoRepository.findByMark(mark);
    }

    @GetMapping("get-by-pikkus")
    public List<Auto> getByPikkus(@RequestParam double minLength, @RequestParam double maxLength) {
        return autoRepository.findByPikkusBetween(minLength, maxLength);
    }

    @GetMapping("get-by-mass")
    public List<Auto> getByMass(@RequestParam double minMass, @RequestParam double maxMass) {
        return autoRepository.findByMassBetween(minMass, maxMass);
    }

    @GetMapping("get-by-omanik")
    public List<Auto> getByOmanik(@RequestParam Omanik omanik) {
        return autoRepository.findByOmanik(omanik);
    }

    @GetMapping("get-by-omanik-max-mass")
    public Auto getByOmanikMaxMass(@RequestParam Omanik omanik) throws Exception {
        List<Auto> autod = autoRepository.findByOmanik(omanik);

        double max = 0;
        int index = 0;

        for (int i = 0; i < autod.size(); i++) {
            if (i == 0) {
                max = autod.get(i).getMass();
            }

            if (max < autod.get(i).getMass()) {
                max = autod.get(i).getMass();
                index = i;
            }
        }

        if (autod.get(index).getMass() > 3500) {
            throw new Exception("Auto mass on üle 3500kg!");
        }

        return autod.get(index);
    }

    @GetMapping("get-by-omanik-max-pikkus")
    public Auto getByOmanikMaxPikkus(@RequestParam Omanik omanik) {
        List<Auto> autod = autoRepository.findByOmanik(omanik);

        double max = 0;
        int index = 0;

        for (int i = 0; i < autod.size(); i++) {
            if (i == 0) {
                max = autod.get(i).getPikkus();
            }

            if (max < autod.get(i).getPikkus()) {
                max = autod.get(i).getPikkus();
                index = i;
            }
        }

        return autod.get(index);
    }
}
