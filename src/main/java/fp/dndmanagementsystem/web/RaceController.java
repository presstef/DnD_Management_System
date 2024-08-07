package fp.dndmanagementsystem.web;

import fp.dndmanagementsystem.service.RaceService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RaceController {
    private final RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }
}
