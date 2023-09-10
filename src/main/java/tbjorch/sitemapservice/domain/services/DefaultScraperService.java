package tbjorch.sitemapservice.domain.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tbjorch.sitemapservice.domain.repository.UrlRepository;
import tbjorch.sitemapservice.domain.valueobjects.Url;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DefaultScraperService implements ScraperService {

    private final UrlRepository urlRepository;
    private final List<SitemapScraper> sitemapScrapers;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public DefaultScraperService(UrlRepository urlRepository, List<SitemapScraper> sitemapScrapers) {
        this.urlRepository = urlRepository;
        this.sitemapScrapers = sitemapScrapers;
    }

    @Override
    public List<Url> scrape() {
        return sitemapScrapers.stream()
                .map(this::scrapeSitemap)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    private List<Url> scrapeSitemap(SitemapScraper scraper) {
        var urls = scraper.scrape();
        return urls.stream()
                .map(this::saveIfNotExists)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private Url saveIfNotExists(Url url) {
        if (!urlRepository.exists(url)) {
            logger.info(String.format("Saving url %s", url.getUrl()));
            return urlRepository.save(url);
        } else {
            logger.info(String.format("Skipping existing url %s", url.getUrl()));
            return null;
        }
    }
}
