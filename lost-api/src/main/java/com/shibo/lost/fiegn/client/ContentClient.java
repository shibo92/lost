package com.shibo.lost.fiegn.client;

import com.shibo.lost.fiegn.fallback.ContentClientFallBack;
import com.shibo.lost.fiegn.fallback.ContentClientFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author by shibo on 2020/8/21.
 */
// @FeignClient(value = "lost-content-server", fallback = ContentClientFallBack.class)
@FeignClient(value = "lost-content-server", fallbackFactory = ContentClientFallBackFactory.class)
public interface ContentClient {
    @RequestMapping(method = RequestMethod.GET, value = "/content/api/hw")
    String helloWorld();
}
