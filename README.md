# Currency GIF Service

Сервис, который показывает GIF в зависимости от изменения курса валюты по отношению к USD.  
Если курс вырос — отображается GIF с тегом `rich`, если упал — с тегом `broke`.

---

## Функционал

- Получение курса валюты на сегодня и вчера через [OpenExchangeRates](https://openexchangerates.org/)
- Получение GIF по тегу через [Giphy API](https://developers.giphy.com/)
- REST API: `GET /api/currency/{code}`
- Использование Feign для интеграции с внешними сервисами
- Конфигурация через `application.yml`
- Сборка через Gradle
- Поддержка Docker

---

## Требования

- Java 21
- Gradle
- Docker (опционально)
- API-ключи:
  - [OpenExchangeRates](https://openexchangerates.org/signup/)
  - [Giphy](https://developers.giphy.com/dashboard/)

---

## 🛠 Настройка

1. В `src/main/resources/application.yml` укажи свои ключи:

```yaml
currency:
  base: USD
  open-exchange:
    app-id: YOUR_OPENEXCHANGE_APP_ID
    url: https://openexchangerates.org/api
  giphy:
    api-key: YOUR_GIPHY_API_KEY
    url: https://api.giphy.com/v1/gifs/search
    rich-tag: rich
    broke-tag: broke
