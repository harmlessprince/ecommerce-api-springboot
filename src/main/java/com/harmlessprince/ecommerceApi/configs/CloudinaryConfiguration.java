package com.harmlessprince.ecommerceApi.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfiguration {
    @Value("${cloundinary.cloud-name}")
    private String cloudName;
    @Value("${cloundinary.api-key}")
    private String apiKey;
    @Value("${cloundinary.api-secret}")
    private String apiSecret;
    @Value("${cloundinary.url}")
    private String url;

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(
                ObjectUtils.asMap(
                        "cloud_name", cloudName,
                        "api_key", apiKey,
                        "api_secret", apiSecret
                )
        );
    }
}
