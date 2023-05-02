package org.micro.apigateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CheckingHeaderGatewayFilterFactory extends AbstractGatewayFilterFactory<CheckingHeaderGatewayFilterFactory.Config> {
    public CheckingHeaderGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return List.of("header");
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            if (exchange.getRequest().getHeaders().containsKey(config.header)) {
                exchange.getRequest().mutate().headers(h -> h.remove(config.header));
                return chain.filter(exchange);
            } else {
                exchange.getResponse().setStatusCode(HttpStatus.valueOf(403));
                return exchange.getResponse().setComplete();
            }
        };
    }

    public static class Config {
        private String header;

        public Config() {
        }

        public void setHeader(String header) {
            this.header = header;
        }
    }
}
