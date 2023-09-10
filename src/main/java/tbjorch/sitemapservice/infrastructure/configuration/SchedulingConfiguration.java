package tbjorch.sitemapservice.infrastructure.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import tbjorch.sitemapservice.application.DefaultScraperApplicationService;

@Configuration
@EnableScheduling
public class SchedulingConfiguration {

    private final DefaultScraperApplicationService scraperService;

    public SchedulingConfiguration(DefaultScraperApplicationService scraperService) {
        this.scraperService = scraperService;
    }

    @Scheduled(cron = "0 0/1 * * * ?")
    public void scrape() {
        scraperService.scrapeSitemap();
    }
}
