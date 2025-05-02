package streaming.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import streaming.backend.buffers.DicebearSeedBuffer;
import streaming.backend.dtos.ApiResponseDto;
import streaming.backend.dtos.responses.DicebearSeedResponse;

@RestController
@RequestMapping("dicebear-seed")
public class DicebearSeedController {
    @Autowired
    DicebearSeedBuffer dicebearSeedBuffer;

    @GetMapping
    ResponseEntity<ApiResponseDto<DicebearSeedResponse>> getSeed() {
        String seed = dicebearSeedBuffer.getRandomSeed();
        DicebearSeedResponse dicebearSeedResponse = new DicebearSeedResponse(seed);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ApiResponseDto<>(true, dicebearSeedResponse, "Dicebear seed created.")
        );
    }
}