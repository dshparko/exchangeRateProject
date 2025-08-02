package by.dshparko.exchangerateproject.service;

import by.dshparko.exchangerateproject.client.GiphyClient;
import by.dshparko.exchangerateproject.client.OpenExchangeClient;
import by.dshparko.exchangerateproject.config.CurrencyProperties;
import by.dshparko.exchangerateproject.model.GiphyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final OpenExchangeClient exchangeClient;
    private final GiphyClient giphyClient;
    private final CurrencyProperties props;

    public String getGifByCurrency(String currencyCode) {
        String appId = props.getOpenExchange().getAppId();
        double todayRate = exchangeClient.getLatest(appId).getRates().get(currencyCode);
        String yesterday = LocalDate.now().minusDays(1).toString();
        double yesterdayRate = exchangeClient.getHistorical(yesterday, appId).getRates().get(currencyCode);

        String tag = todayRate > yesterdayRate ? props.getGiphy().getRichTag() : props.getGiphy().getBrokeTag();
        GiphyResponse gif = giphyClient.getGif(props.getGiphy().getApiKey(), tag, 1);
        return gif.getData().getFirst().getEmbed_url();
    }
}

