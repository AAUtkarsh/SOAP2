package com.automationanywhere.soap3;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class WsdlController {

    @GetMapping("/wsdl")
    public void getWsdl(HttpServletResponse response) throws IOException {
        // Load the merged WSDL file from the classpath
        ClassPathResource wsdlResource = new ClassPathResource("merged_wsdl.xml");
        InputStream inputStream = wsdlResource.getInputStream();

        // Set the response headers
        response.setContentType("text/xml");
        response.setHeader("Content-Disposition", "attachment; filename=\"merged_wsdl.xml\"");

        // Write the WSDL file to the response
        int bytesRead;
        byte[] buffer = new byte[4096];
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            response.getOutputStream().write(buffer, 0, bytesRead);
        }
        response.flushBuffer();
    }
}

