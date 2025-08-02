package by.dshparko.exchangerateproject.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "currency")
@Data
@Component
public class CurrencyProperties {
    private String base;
    private OpenExchange openExchange;
    private Giphy giphy;

    @Data
    public static class OpenExchange {
        private String appId;
        private String url;
    }

    @Data
    public static class Giphy {
        private String apiKey;
        private String url;
        private String richTag;
        private String brokeTag;
    }
}

