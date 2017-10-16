package edu.mum.mpp.service;


import edu.mum.mpp.model.User;
import edu.mum.mpp.security.AuthenticationWithToken;
import edu.mum.mpp.util.LoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.UUID;



@Service
public class TokenService {

    public static final int HALF_AN_HOUR_IN_MILLISECONDS = 30 * 60 * 1000;
    private static final Logger logger = LoggerFactory.getLogger(TokenService.class);
    @Autowired
    TokenCachingService cacheService;

    public TokenService() {
        logger.info("creating TokenService");
    }

    public static User getCurrentUserFromSecurityContext() {

        try {

            AuthenticationWithToken auth = (AuthenticationWithToken) SecurityContextHolder.getContext().getAuthentication();
            // Authentication a = SecurityContextHolder.getContext().getAuthentication();

            //Object principal = a.getPrincipal();

            return (User) auth.getPrincipal();
        } catch (Exception ex) {
            logger.error("Error retrieving User from Security context : " + ex);
            LoggerUtil.logError(logger, ex);
            return null;
        }
    }

    @Scheduled(fixedRate = HALF_AN_HOUR_IN_MILLISECONDS)
    public void evictExpiredTokens() {
        logger.info("Evicting expired tokens");
        cacheService.purgeExpiredElements();
    }

    public String generateNewToken() {
        StringBuilder sb = new StringBuilder(UUID.randomUUID().toString());
        sb.append("-");
        sb.append(UUID.randomUUID().toString());
        sb.append("-");
        sb.append(UUID.randomUUID().toString());
        sb.append("-");
        sb.append(UUID.randomUUID().toString());

        return sb.toString();
    }

    public void store(String token, Object data) {
        cacheService.put(token, data);
    }

    public boolean contains(String token) {
        return cacheService.isTokenPresent(token);
    }

    public Authentication retrieve(String token) {
        return (Authentication) cacheService.retrieve(token);
    }

    public boolean remove(String key) {
        return cacheService.remove(key);
    }
}
