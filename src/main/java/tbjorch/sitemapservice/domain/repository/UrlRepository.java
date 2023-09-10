package tbjorch.sitemapservice.domain.repository;

import tbjorch.sitemapservice.domain.valueobjects.Url;

public interface UrlRepository {
    Url save(Url url);

    boolean exists(Url url);
}
