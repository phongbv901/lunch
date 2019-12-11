package com.phongbv.lunch.endpoint;

import org.springframework.http.HttpEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DevController {

    @RequestMapping(value = "/requestInspect", method = RequestMethod.POST)
    public Map<String, Object> getRequest(HttpEntity<String> httpEntity,
                          @RequestHeader MultiValueMap<String, String> headers,
                          HttpServletRequest request){
        Map<String, Object> output = new HashMap<>();
        output.put("body", httpEntity != null ? httpEntity.getBody() : "");
        output.put("headers",headers);
        output.put("cookies", request.getCookies());
        output.put("clientInfo", request.getRemoteAddr());
        output.put("params", request.getParameterMap());
        return output;
    }
}
