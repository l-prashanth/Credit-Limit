package com.prashanth.controller;

import com.prashanth.model.token.JWTTokenResponse;
import com.prashanth.service.jwtservice.JWTProcessorImpl;
import com.prashanth.utils.JwtTokenUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jwt")
@AllArgsConstructor
public class JWTTokenController {

    private JwtTokenUtil jwtTokenUtil;
    private JWTProcessorImpl jwtProcessor;

    @PostMapping("/generate-token")
    public ResponseEntity<JWTTokenResponse> generateToken(
            @Schema(description = "Grant Type") @RequestHeader(value = "grant_type") String grantType,
            @Schema(description = "Client Id") @RequestHeader(value = "client_id") String clientId,
            @Schema(description = "Client Secret") @RequestHeader(value = "client_secret") String clientSecret,
            @Schema(description = "Trace Id") @RequestHeader(value = "trace_id") String traceId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(jwtProcessor.generateToken(clientId, clientSecret,traceId));
    }

    @PostMapping("/validate-token")
    public ResponseEntity<Object> validateToken(@RequestBody JWTTokenResponse jwtTokenResponse) {
        return ResponseEntity.ok(jwtTokenUtil.validateToken(jwtTokenResponse.getToken()));
    }

}
