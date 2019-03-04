package com.sunfy;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * 配置say-hello信息
 */
public class SayhelloConfiguration {
    @Autowired
    IClientConfig ribbonClientConfig;

    // ribbon 的ping
    @Bean
    public IPing ribbonPing(IClientConfig config){
        return new PingUrl();
    }

    // 路由规则
    @Bean
    public IRule ribbonRule(IClientConfig config){
        return new AvailabilityFilteringRule();
    }
}
