package com.dh.filter;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


@Component
public class MygateWayFilter implements GlobalFilter, Ordered {

    private Logger log = LoggerFactory.getLogger(MygateWayFilter.class);

    /**
     * 可以用于验证用户登录状态，设置某部分请求信息等。
     *
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        String uri = request.getURI().toString();
        //判断当前是什么类型请求GET请求直接放行
        if (StringUtils.equals(request.getMethod().toString(), "GET")) {
            return chain.filter(exchange);
        }
        //不是GET，判断是不是登录
        if (uri.contains("test")) {
            return chain.filter(exchange);
        }
        String token = request.getHeaders().getFirst("token");
        System.out.println("token=" + token);
        return response.setComplete();
    }

    @Override
    public int getOrder() {
        return 0;
    }

}
