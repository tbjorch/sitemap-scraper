package tbjorch.sitemapservice.scraper.implementations.aftonbladet.elements;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class UrlSet {
    @XmlElement(name = "url", namespace = "http://www.sitemaps.org/schemas/sitemap/0.9")
    private List<Url> urls;

    public List<Url> getUrls() {
        return urls;
    }
}
