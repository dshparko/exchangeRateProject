package by.dshparko.exchangerateproject.client;

import by.dshparko.exchangerateproject.model.ExchangeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "exchangeClient", url = "${currency.open-exchange.url}")
public interface OpenExchangeClient {
    @GetMapping("/latest.json")
    ExchangeResponse getLatest(@RequestParam("app_id") String appId);

    @GetMapping("/historical/{date}.json")
    ExchangeResponse getHistorical(@PathVariable String date, @RequestParam("app_id") String appId);
}