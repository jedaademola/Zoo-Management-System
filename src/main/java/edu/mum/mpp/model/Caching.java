package edu.mum.mpp.model;


import org.springframework.security.core.token.Token;


/**
 * Created by Lukman.Arogundade on 5/8/2015.
 */
public  interface Caching extends Token {

    public void put(String token, Object data);
    public String get(String token);
    public boolean isTokenPresent(String token);
    public void purgeExpiredElements();
    public Object retrieve(String key);
    public  boolean remove(String key);
}
