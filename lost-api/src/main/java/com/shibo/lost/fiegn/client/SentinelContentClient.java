package com.shibo.lost.fiegn.client;

import com.shibo.lost.fiegn.fallback.ContentClientFallBackFactory;
import com.shibo.lost.fiegn.fallback.SentinelContentClientFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author by shibo on 2020/8/21.
 */
// @FeignClient(value = "lost-content-server", fallback = ContentClientFallBack.class)
@FeignClient(value = "lost-content-server", fallbackFactory = SentinelContentClientFallBackFactory.class)
public interface SentinelContentClient {
    @RequestMapping(method = RequestMethod.GET, value = "/sentinel/content/api/hw")
    String sentinelContentHelloWorld();
}
