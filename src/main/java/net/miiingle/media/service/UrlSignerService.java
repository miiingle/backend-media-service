package net.miiingle.media.service;

import com.amazonaws.auth.PEM;
import com.amazonaws.services.cloudfront.CloudFrontUrlSigner;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.StringInputStream;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import javax.inject.Singleton;
import java.security.PrivateKey;
import java.util.Date;

@RequiredArgsConstructor
@Singleton
public class UrlSignerService {

    private final Config config;

    /**
     * doc:
     * https://docs.aws.amazon.com/AWSJavaSDK/latest/javadoc/com/amazonaws/services/cloudfront/CloudFrontUrlSigner.html
     */
    @SneakyThrows
    public String signUrl(String s3ObjectPath) {

        PrivateKey privateKey = PEM.readPrivateKey(new StringInputStream(config.getPrivateKey()));

        return CloudFrontUrlSigner.getSignedURLWithCannedPolicy(
                calculatePathForObject(s3ObjectPath),
                config.getKeyPairId(),
                privateKey,
                calculateExpiry());
    }

    private String calculatePathForObject(String s3ObjectPath) {
        return String.format("https://%s/%s", config.getDistributionDomain(), s3ObjectPath);
    }

    private Date calculateExpiry() {
        //TODO: do something
        return DateUtils.parseISO8601Date("2021-04-07T22:20:00.000Z");
    }
}