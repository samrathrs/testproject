/**
 * 
 */
package com.transerainc.security;

import org.pac4j.cas.client.CasClient;
import org.pac4j.cas.config.CasConfiguration;
import org.pac4j.core.client.Clients;
import org.pac4j.core.config.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author tnguyen (Tri Nguyen)
 *
 */

@Configuration
@ComponentScan
public class Pac4jConfig extends Config {

    @Value("${auth.cas.server.full.url}")
    private String casServerFullUrl;

    @Value("${auth.cas.callback.url}")
    private String casCallbackUrl;

    @Bean
    public Config config() {
        // CAS
        final CasConfiguration casConfiguration = new CasConfiguration(casServerFullUrl);
        final CasClient casClient = new CasClient(casConfiguration);

        final Clients clients = new Clients(casCallbackUrl, casClient);

        final Config config = new Config(clients);
        return config;
    }
}
