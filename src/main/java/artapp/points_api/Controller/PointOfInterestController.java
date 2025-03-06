package artapp.points_api.Controller;

import artapp.points_api.Controller.dto.CreatePointOfInterest;
import artapp.points_api.entity.PointOfInterest;
import artapp.points_api.repository.PointOfInterestRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PointOfInterestController {

    private final PointOfInterestRepository repository;

    public PointOfInterestController(PointOfInterestRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/points-of-interests")
    public ResponseEntity<Void> createPOI(@RequestBody CreatePointOfInterest dto) {
        repository.save(new PointOfInterest(dto.name(), dto.x(), dto.y()));
        return ResponseEntity.ok().build();
    }

}
