package io.github.api.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * @author 
 */
@Getter
public class AuthResponsePayload {
    @JsonProperty private String token;
}
