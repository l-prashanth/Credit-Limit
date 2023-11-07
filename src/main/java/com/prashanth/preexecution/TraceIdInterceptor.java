package com.prashanth.preexecution;

import com.prashanth.model.trace.TraceIdScope;
import com.prashanth.utils.CommonUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.UUID;

@Component
@Slf4j
public class TraceIdInterceptor implements HandlerInterceptor {

    @Autowired
    private TraceIdScope traceId;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        String id = request.getHeader("trace_id");
        log.info("Trace>>"+ traceId);
        if(CommonUtils.isNullOrEmpty(id)){
            traceId.setTraceId(UUID.randomUUID().toString());
            log.info("Trace>>"+ traceId);
        }
        else{
            traceId.setTraceId(traceId.getTraceId());
            log.info("Trace>>"+ traceId);
        }
        return true;
    }
}