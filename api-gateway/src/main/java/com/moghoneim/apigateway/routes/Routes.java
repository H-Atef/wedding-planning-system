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
    RouterFunction<ServerResponse> userServiceSwaggerRoute() {
        return GatewayRouterFunctions.route("user_service_swagger")
                .route(RequestPredicates.path("/aggregate/user-service/v3/api-docs"),
                        HandlerFunctions.http("http://localhost:8082"))
                .filter(FilterFunctions.setPath("/api-docs"))
                .build();
    }

    @Bean
    RouterFunction<ServerResponse> guestsServiceRoute() {
        return GatewayRouterFunctions.route("guests_service")
                .route(RequestPredicates.path("/api/v1/guests/**"),
                        HandlerFunctions.http("http://localhost:8081/")).build();
    }

    @Bean
    RouterFunction<ServerResponse> guestsServiceSwaggerRoute() {
        return GatewayRouterFunctions.route("guests_service_swagger")
                .route(RequestPredicates.path("/aggregate/guests-service/v3/api-docs"),
                        HandlerFunctions.http("http://localhost:8081"))
                .filter(FilterFunctions.setPath("/api-docs"))
                .build();
    }

    @Bean
    RouterFunction<ServerResponse> rsvpServiceRoute() {
        return GatewayRouterFunctions.route("rsvp_service")
                .route(RequestPredicates.path("/api/v1/rsvp/**"),
                        HandlerFunctions.http("http://localhost:8083/")).build();
    }

    @Bean
    RouterFunction<ServerResponse> rsvpServiceSwaggerRoute() {
        return GatewayRouterFunctions.route("rsvp_service_swagger")
                .route(RequestPredicates.path("/aggregate/rsvp-service/v3/api-docs"),
                        HandlerFunctions.http("http://localhost:8083"))
                .filter(FilterFunctions.setPath("/api-docs"))
                .build();
    }

    @Bean
    RouterFunction<ServerResponse> vendorsServiceRoute() {
        return GatewayRouterFunctions.route("vendors_service")
                .route(RequestPredicates.path("/api/v1/vendors/**"),
                        HandlerFunctions.http("http://localhost:8085/")).build();


    }

    @Bean
    RouterFunction<ServerResponse> vendorsServiceSwaggerRoute() {
        return GatewayRouterFunctions.route("vendors_service_swagger")
                .route(RequestPredicates.path("/aggregate/vendors-service/v3/api-docs"),
                        HandlerFunctions.http("http://localhost:8085"))
                .filter(FilterFunctions.setPath("/api-docs"))
                .build();
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
