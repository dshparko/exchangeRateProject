package by.dshparko.exchangerateproject.model;

import lombok.Data;

import java.util.List;

@Data
public class GiphyResponse {
    private List<GifData> data;

    @Data
    public static class GifData {
        private String embed_url;
    }
}
