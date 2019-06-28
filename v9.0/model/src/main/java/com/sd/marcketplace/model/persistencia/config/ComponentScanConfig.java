package com.sd.marcketplace.model.persistencia.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.sd.marcketplace.model.persistencia.mapper"})
public class ComponentScanConfig {
}