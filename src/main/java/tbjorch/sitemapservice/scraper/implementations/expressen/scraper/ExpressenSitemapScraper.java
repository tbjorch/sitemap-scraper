package tbjorch.sitemapservice.scraper.implementations.expressen.scraper;

import jakarta.xml.bind.JAXB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tbjorch.sitemapservice.domain.services.SitemapScraper;
import tbjorch.sitemapservice.scraper.implementations.expressen.elements.Url;
import tbjorch.sitemapservice.scraper.implementations.expressen.elements.UrlSet;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

public class ExpressenSitemapScraper implements SitemapScraper {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public List<Url> scrapeSitemap(String url) {
        URL sitemapUrl = getUrl(url);
        UrlSet urlSet = JAXB.unmarshal(sitemapUrl, UrlSet.class);
        return urlSet.getUrls();
    }

    private static URL getUrl(String url) {
        try {
            return new URL(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<tbjorch.sitemapservice.domain.valueobjects.Url> scrape() {
        logger.info("Scraping Expressen sitemap");
        var urls = scrapeSitemap("https://www.expressen.se/articles-2023-09.xml");
        return urls.stream()
                .map(Url::getValue)
                .map(tbjorch.sitemapservice.domain.valueobjects.Url::new)
                .collect(Collectors.toList());
    }
}
