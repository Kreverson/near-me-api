package artapp.points_api.Controller;

import artapp.points_api.Controller.dto.CreatePointOfInterest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PointOfInterestController {

    @PostMapping("/points-of-interests")
    public ResponseEntity<Void> createPOI(@RequestBody CreatePointOfInterest dto) {
        return ResponseEntity.ok().build();
    }

}
