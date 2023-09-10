package tbjorch.sitemapservice.infrastructure.repositories;

import tbjorch.sitemapservice.domain.repository.UrlRepository;
import tbjorch.sitemapservice.domain.valueobjects.Url;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUrlRepository implements UrlRepository {

    private final Map<String, Integer> urls = new HashMap<>();

    @Override
    public Url save(Url url) {
        if (exists(url)) {
            throw new UniqueConstraintException();
        }
        urls.put(url.getUrl(), 1);
        return url;
    }

    @Override
    public boolean exists(Url url) {
        return urls.containsKey(url.getUrl());
    }
}
