package edu.mum.mpp.model;


public interface ICacheManager {

    public Object createCache(String appName, String cacheName, long ttl);
    public  void destroyCache(Object cache);
    public void put(Object cache, String key, Object data);
    public Object get(Object cache, String key);
    public boolean isPresent(Object cache, String key);
    public  boolean remove(Object cache, String key);
    public  void purgeExpiredElements(Object cache);
}
