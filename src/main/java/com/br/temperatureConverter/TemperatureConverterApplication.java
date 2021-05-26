package com.br.temperatureConverter;

import com.br.temperatureConverter.Response.Content;
import com.br.temperatureConverter.Response.Coordinates;
import com.br.temperatureConverter.Response.OpenWeather;
import com.br.temperatureConverter.Response.Response;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@Service
public class TemperatureConverterApplication {

    static ApplicationContext ctx;

    public static void main(String[] args) {
        SpringApplication.run(TemperatureConverterApplication.class, args);
        ctx = new ClassPathXmlApplicationContext("/integration/integration.xml");
    }

    @GetMapping("/weather")
    public ResponseEntity<Response> handle(@RequestParam(value = "city", required = true) String city) {

        // Api do OpenWeather e apiKey para acesso
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + ",br&";
        String apiKey = "&APPID=f0ba3cc0175bb4a2d3b3fcf6480b341f";

        // Rest template para realizar a requisição HTTP
        RestTemplate restTemplate = new RestTemplateBuilder().build();

        // Faz a requisição
        ResponseEntity<OpenWeather> result = restTemplate.getForEntity(apiUrl + apiKey, OpenWeather.class);

        // Tudo certo com o request
        if (result.getStatusCode() == HttpStatus.OK) {

            // Classes para o parsing
            Content content = result.getBody().getMain();
            Coordinates coord = result.getBody().getCoord();

            // Dados
            float temperature = content.getTemp();
            String coordinates = coord.getLon() + "," + coord.getLat();
            int pressure = content.getPressure();
            int humidity = content.getHumidity();

            // Converte a temperatura de Kelvin para Celsius
            temperature = ctx.getBean("toCelsius", TempConverter.class).kelvinToCelsius(temperature);

            // Cria a resposta do request realizado pelo user
            Response response = new Response(temperature, coordinates, pressure, humidity);
            return new ResponseEntity<Response>(response, HttpStatus.OK);
        }
        return null;
    }

}
