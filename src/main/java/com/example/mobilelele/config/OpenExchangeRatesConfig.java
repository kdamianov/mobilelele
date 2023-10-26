package com.example.mobilelele.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "open.exchange.rates")
public class OpenExchangeRatesConfig {

    private String appId;
    private List<String> symbols;
    private String host;
    private String schema;
    private String path;


    public String getAppId() {
        return appId;
    }

    public OpenExchangeRatesConfig setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public List<String> getSymbols() {
        return symbols;
    }

    public OpenExchangeRatesConfig setSymbols(List<String> symbols) {
        this.symbols = symbols;
        return this;
    }

    public String getHost() {
        return host;
    }

    public OpenExchangeRatesConfig setHost(String host) {
        this.host = host;
        return this;
    }

    public String getSchema() {
        return schema;
    }

    public OpenExchangeRatesConfig setSchema(String schema) {
        this.schema = schema;
        return this;
    }

    public String getPath() {
        return path;
    }

    public OpenExchangeRatesConfig setPath(String path) {
        this.path = path;
        return this;
    }

    @Override
    public String toString() {
        return "OpenExchangeRatesConfig{" +
                "appId='" + appId + '\'' +
                ", symbols=" + symbols +
                ", host='" + host + '\'' +
                ", schema='" + schema + '\'' +
                '}';
    }
}
