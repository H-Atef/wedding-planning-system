package com.moghoneim.apigateway.routes;

import org.springframework.cloud.gateway.server.mvc.filter.FilterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class Routes {
    @Bean
    RouterFunction<ServerResponse> usersServiceRoute() {
        return GatewayRouterFunctions.route("users_service")
                .route(RequestPredicates.path("/api/v1/users/**"),
                        HandlerFunctions.http("http://localhost:8082/")).build();
    }



    @Bean
    RouterFunction<ServerResponse> discoveryServerRoute() {
        return GatewayRouterFunctions.route("discovery_server")
                .route(RequestPredicates.path("/eureka/web"),
                        HandlerFunctions.http("http://localhost:8761/"))
                .filter(FilterFunctions.setPath("/"))
                .build();
    }

    @Bean
    RouterFunction<ServerResponse> discoveryServerStaticRoute() {
        return GatewayRouterFunctions.route("discovery_server_static")
                .route(RequestPredicates.path("/eureka/**"),
                        HandlerFunctions.http("http://localhost:8761/"))
                .build();
    }


}
