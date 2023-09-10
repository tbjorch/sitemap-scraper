package tbjorch.sitemapservice.scraper.implementations.svd.elements;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class UrlSet {
    @XmlElement(name = "url", namespace = "http://www.sitemaps.org/schemas/sitemap/0.9")
    private List<Url> urls;

    public List<Url> getUrls() {
        return urls;
    }
}
