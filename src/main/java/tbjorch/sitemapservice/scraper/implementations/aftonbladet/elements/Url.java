package tbjorch.sitemapservice.scraper.implementations.aftonbladet.elements;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Url {
    @XmlElement(name = "loc", namespace = "http://www.sitemaps.org/schemas/sitemap/0.9")
    private String loc;

    public String getValue() {
        return loc;
    }
}
