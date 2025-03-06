package artapp.points_api.Controller;

import artapp.points_api.Controller.dto.CreatePointOfInterest;
import artapp.points_api.entity.PointOfInterest;
import artapp.points_api.repository.PointOfInterestRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/points-of-interests")
    public ResponseEntity<Page<PointOfInterest>> ListPOI(@RequestParam (name = "page", defaultValue = "0") Integer page,
                                                         @RequestParam (name = "pageSize", defaultValue = "10") Integer pageSize) {

        var body = repository.findAll(PageRequest.of(page, pageSize));

        return ResponseEntity.ok(body);
    }

    @GetMapping("/near-me")
    public ResponseEntity<List<PointOfInterest>> ListPOI(@RequestParam ("x") Long x,
                                                         @RequestParam ("y") Long y,
                                                         @RequestParam("dmax") Long dmax) {

        var xMin = x - dmax;
        var xMax = x + dmax;
        var yMin = y - dmax;
        var yMax = y + dmax;

        var body = repository.findNearMe(xMin, xMax, yMin, yMax);
        
        return ResponseEntity.ok(body);
    }

}
