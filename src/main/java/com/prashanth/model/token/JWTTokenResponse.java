package com.prashanth.model.token;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JWTTokenResponse {

    @JsonProperty("token_type")
    private String tokenType;
    @JsonProperty("expires_in")
    private String expirationTime;
    @JsonProperty("access_token")
    private String token;
}
