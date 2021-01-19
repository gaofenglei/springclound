package com.gfl;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableHystrix
public class RibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonApplication.class, args);
	}

	//定义负载均衡规则
	@Bean
	public IRule ribbonRule(){
		return new RandomRule();
	}

/*	这里我们主要介绍一下 Irule：
	RoundRobinRule：轮询规则
	RandomRule：随机规则
	WeightedResponseTimeRule：使用响应时间的平均或者百分比为每个服务分配权重的规则，如果没法收集响应时间信息，会默认使用轮询规则
	BestAvailableRule：会先根据断路器过滤掉处于故障的服务，然后选择并发量最小的服务
	ZoneAvoidanceRule：根据server所在Zone和其性能，选择服务器，默认规则
	AvailabilityFilteringRule：先根据断路器规则过滤掉有问题的服务，然后对剩余的服务按照轮询的策略进行访问
	RetryRule：先按照RoundRobinRule规则进行服务获取，如果调用服务失败会在指定时间内进行重试，直到获取到可用的服务。*/

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
