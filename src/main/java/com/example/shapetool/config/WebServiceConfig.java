package com.example.shapetool.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.core.io.ClassPathResource;

import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;

import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {

    // Register SOAP servlet
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet>
    messageDispatcherServlet(ApplicationContext applicationContext) {

        MessageDispatcherServlet servlet =
                new MessageDispatcherServlet();

        servlet.setApplicationContext(applicationContext);

        // Enable WSDL location transformation
        servlet.setTransformWsdlLocations(true);

        return new ServletRegistrationBean<>(
                servlet,
                "/ws/*"
        );
    }

    // Generate WSDL automatically
    @Bean(name = "shapes")
    public Wsdl11Definition defaultWsdl11Definition(
            XsdSchema shapesSchema) {

        DefaultWsdl11Definition wsdl11Definition =
                new DefaultWsdl11Definition();

        wsdl11Definition.setPortTypeName("ShapesPort");

        wsdl11Definition.setLocationUri("/ws");

        wsdl11Definition.setTargetNamespace(
                "http://example.com/shapetool"
        );

        wsdl11Definition.setSchema(shapesSchema);

        return wsdl11Definition;
    }

    // Load XSD file
    @Bean
    public XsdSchema shapesSchema() {

        return new SimpleXsdSchema(
                new ClassPathResource("xsd/shapes.xsd")
        );
    }
}