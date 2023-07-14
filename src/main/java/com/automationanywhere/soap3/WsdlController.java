package com.automationanywhere.soap3;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WsdlController {

    @GetMapping(value = "/soap.wsdl", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public Resource getWsdl() {
        return new ClassPathResource("soap.wsdl");
    }
}
