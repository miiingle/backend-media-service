package net.miiingle.media.service;

import com.amazonaws.services.cloudfront.CloudFrontUrlSigner;
import com.amazonaws.services.cloudfront.util.SignerUtils;
import com.amazonaws.util.DateUtils;
import lombok.SneakyThrows;

import javax.inject.Singleton;
import java.io.File;
import java.util.Date;

@Singleton
public class UrlSignerService {

    /**
     * doc:
     * https://docs.aws.amazon.com/AWSJavaSDK/latest/javadoc/com/amazonaws/services/cloudfront/CloudFrontUrlSigner.html
     */
    @SneakyThrows
    public String signUrl() {

        String distributionDomain = "dxxxxxxxx.cloudfront.net";
        File privateKeyFile = new File("/Users/startupbuilder/Developer/miiingle-media-service/src/test/resources/cloudfront-signer/private_key.pem");
        String s3ObjectKey = "README.md";
        String keyPairId = "KYIPxxxxxxxx";
        Date dateLessThan = DateUtils.parseISO8601Date("2021-04-05T22:20:00.000Z");

        return CloudFrontUrlSigner.getSignedURLWithCannedPolicy(
                SignerUtils.Protocol.https, distributionDomain, privateKeyFile,
                s3ObjectKey, keyPairId, dateLessThan);
    }
}