package tbjorch.sitemapservice.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import tbjorch.sitemapservice.application.DefaultScraperApplicationService;
import tbjorch.sitemapservice.domain.repository.UrlRepository;
import tbjorch.sitemapservice.domain.services.DefaultScraperService;
import tbjorch.sitemapservice.domain.services.ScraperService;
import tbjorch.sitemapservice.domain.services.SitemapScraper;
import tbjorch.sitemapservice.infrastructure.repositories.InMemoryUrlRepository;
import tbjorch.sitemapservice.scraper.implementations.aftonbladet.scraper.AftonbladetSitemapScraper;
import tbjorch.sitemapservice.scraper.implementations.dn.scraper.DnSitemapScraper;
import tbjorch.sitemapservice.scraper.implementations.expressen.scraper.ExpressenSitemapScraper;
import tbjorch.sitemapservice.scraper.implementations.svd.scraper.SvdSitemapScraper;

import java.util.List;

@Configuration
public class BeanConfiguration {

    @Bean
    public AftonbladetSitemapScraper aftonbladetSitemanScraper() {
        return new AftonbladetSitemapScraper();
    }

    @Bean
    DnSitemapScraper dnSitemapScraper() {
        return new DnSitemapScraper();
    }

    @Bean
    SvdSitemapScraper svdSitemapScraper() {
        return new SvdSitemapScraper();
    }

    @Bean
    ExpressenSitemapScraper expressenSitemapScraper() {
        return new ExpressenSitemapScraper();
    }

    @Bean
    public DefaultScraperApplicationService testScraper(ScraperService scraperService, KafkaTemplate<String, String> kafka) {
        return new DefaultScraperApplicationService(scraperService, kafka);
    }

    @Bean
    public UrlRepository urlRepository() {
        return new InMemoryUrlRepository();
    }

    @Bean
    public ScraperService scraperService(UrlRepository urlRepository, List<SitemapScraper> scrapers) {
        return new DefaultScraperService(urlRepository, scrapers);
    }
}
