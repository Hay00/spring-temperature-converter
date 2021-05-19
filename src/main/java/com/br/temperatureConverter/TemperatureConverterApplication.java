package com.br.temperatureConverter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TemperatureConverterApplication {

    static ApplicationContext ctx;

    public static void main(String[] args) {
        SpringApplication.run(TemperatureConverterApplication.class, args);
        ctx = new ClassPathXmlApplicationContext("/integration/integration.xml");
    }

    @GetMapping("/convert")
    public String convert(@RequestParam(value = "temperature", required = true) Float temperature) {
        // Fahrenheit to Celsius
        float celsius = ctx.getBean("toCelsius", TempConverter.class).fahrenheitToCelsius(temperature);

        // Fahrenheit to Kelvin
        float kelvin = ctx.getBean("toKelvin", TempConverter.class).fahrenheitToCelsius(temperature);

        // Return response
        return String.format("Celsius: %.2f\nKelvin: %.2f", celsius, kelvin);
    }

}
