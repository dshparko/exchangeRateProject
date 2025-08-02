package by.dshparko.exchangerateproject.client;

import by.dshparko.exchangerateproject.model.GiphyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "giphyClient", url = "${currency.giphy.url}")
public interface GiphyClient {
    @GetMapping
    GiphyResponse getGif(@RequestParam("api_key") String apiKey,
                         @RequestParam("q") String tag,
                         @RequestParam("limit") int limit);
}