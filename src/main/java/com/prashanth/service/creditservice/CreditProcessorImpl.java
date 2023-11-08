package com.prashanth.service.creditservice;

import com.prashanth.utils.CommonUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreditProcessorImpl implements CreditProcessor {

    private CommonUtils commonUtils;

    @Override
    public String credit(String token) {
        commonUtils.validateToken(token);
        return "Credit Logic";
    }
}
