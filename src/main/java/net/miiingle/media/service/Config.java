package net.miiingle.media.service;

import io.micronaut.context.annotation.ConfigurationProperties;
import lombok.Data;

@Data
@ConfigurationProperties("app.media.service")
public class Config {

    private String distributionDomain;
    private String privateKey;
    private String keyPairId;
    private Long defaultExpiry;
}
