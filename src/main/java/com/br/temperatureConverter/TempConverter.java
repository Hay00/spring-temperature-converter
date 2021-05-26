/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.temperatureConverter;

/**
 *
 * @author vinicios
 */
public interface TempConverter {

    float kelvinToCelsius(float kelvin);

    float fahrenheitToCelsius(float fahren);

    float fahrenheitToKelvin(float fahren);

}
