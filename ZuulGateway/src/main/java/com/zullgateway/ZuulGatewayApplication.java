package com.zullgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.zullgateway.filters.ErrorFilter;
import com.zullgateway.filters.PostFilter;
import com.zullgateway.filters.PreFilter;
import com.zullgateway.filters.RouteFilter;

@SpringBootApplication
@EnableZuulProxy
public class ZuulGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayApplication.class, args);
	}

	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}

	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}

	@Bean
	public RouteFilter routerFilter() {
		return new RouteFilter();
	}

	@Bean
	public ErrorFilter filterError() {
		return new ErrorFilter();
	}

}
