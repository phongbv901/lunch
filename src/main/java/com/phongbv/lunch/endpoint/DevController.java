package com.phongbv.lunch.endpoint;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class DevController {

    private Gson gson = new Gson();

    @RequestMapping(value = "/requestInspect", method = RequestMethod.POST)
    public Map<String, Object> inspectCommand(HttpEntity<String> httpEntity,
                          @RequestHeader MultiValueMap<String, String> headers,
                          HttpServletRequest request){
        Map<String, Object> output = new HashMap<>();
        output.put("body", httpEntity != null ? httpEntity.getBody() : "");
        output.put("headers",headers);
        output.put("cookies", request.getCookies());
        output.put("clientInfo", request.getRemoteAddr());
        output.put("params", request.getParameterMap());
        log.info("Request inspect details: {}", output);
        return output;
    }

    @RequestMapping(value = "/interactive", method = RequestMethod.POST)
    public Map<String, Object> inspectInteractive(HttpEntity<String> httpEntity,
                                          @RequestHeader MultiValueMap<String, String> headers,
                                          HttpServletRequest request){
        Map<String, Object> output = new HashMap<>();
        output.put("body", httpEntity != null ? httpEntity.getBody() : "");
        output.put("headers",headers);
        output.put("cookies", request.getCookies());
        output.put("clientInfo", request.getRemoteAddr());
        output.put("params", request.getParameterMap());
        log.info("Request inspect details: {}", gson.toJson(output));
        return output;
    }
}
