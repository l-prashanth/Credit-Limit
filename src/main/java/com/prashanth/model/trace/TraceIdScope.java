package com.prashanth.model.trace;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class TraceIdScope {
    private String traceId;
}
