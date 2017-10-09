package edu.mum.mpp.service;


import edu.mum.mpp.model.ICacheManager;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.store.MemoryStoreEvictionPolicy;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

/**
 * C
 */


@ConditionalOnProperty(name = "cache.manager", havingValue = "ehCacheManager")
@Service
public class EhCacheManager implements ICacheManager {

    private final static CacheManager singletonManager = CacheManager.create();


    @Override
    public Object createCache(String appName, String cacheName, long ttl) {
        CacheConfiguration config = new CacheConfiguration(appName + ":" + cacheName, 0)
                .memoryStoreEvictionPolicy(MemoryStoreEvictionPolicy.LFU)
                .eternal(false)
                .diskExpiryThreadIntervalSeconds(0)
                .overflowToDisk(false);
        if(ttl > 0){
            config.timeToIdleSeconds(ttl);
        }

        Cache cache = new Cache(config);
        singletonManager.addCache(cache);

        return cache;
    }

    @Override
    public void destroyCache(Object cache) {
        singletonManager.removeCache(((Cache)cache).getName());
    }

    @Override
    public void put(Object cache, String key, Object data) {
        Element element = new Element(key, data);
        ((Cache)cache).put(element);
    }

    @Override
    public Object get(Object cache, String key) {
        Element ele = ((Cache) cache).get(key);
        if(null == ele){
            return null;
        }

        return ele.getObjectValue();
    }

    @Override
    public boolean isPresent(Object cache, String key) {
        return ((Cache)cache).get(key) != null;
    }

    @Override
    public boolean remove(Object cache, String key) {
        return ((Cache)cache).remove(key);
    }

    @Override
    public  void purgeExpiredElements(Object cache){
        ((Cache)cache).evictExpiredElements();
    }
}
