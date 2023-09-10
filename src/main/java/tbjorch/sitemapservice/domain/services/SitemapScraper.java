package tbjorch.sitemapservice.domain.services;

import tbjorch.sitemapservice.domain.valueobjects.Url;

import java.util.List;

public interface SitemapScraper {
    List<Url> scrape();
}
