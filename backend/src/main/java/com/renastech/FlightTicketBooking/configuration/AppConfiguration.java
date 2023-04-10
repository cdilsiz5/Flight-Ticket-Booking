package com.renastech.FlightTicketBooking.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "flight")
public class AppConfiguration
{

    @Value("$upload-path")
    private String uploadPath;

}
