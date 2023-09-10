package tbjorch.sitemapservice.application;

import org.springframework.kafka.core.KafkaTemplate;
import tbjorch.sitemapservice.domain.services.ScraperService;
import tbjorch.sitemapservice.domain.valueobjects.Url;

public class DefaultScraperApplicationService {

    private final ScraperService scraperService;
    private final KafkaTemplate<String, String> kafka;

    public DefaultScraperApplicationService(ScraperService scraperService, KafkaTemplate<String, String> kafka) {
        this.scraperService = scraperService;
        this.kafka = kafka;
    }

    public void scrapeSitemap() {
        var urls = scraperService.scrape();
        urls.stream()
                .map(Url::getUrl)
                .forEach(urlValue -> kafka.send("urls", urlValue));
    }
}
