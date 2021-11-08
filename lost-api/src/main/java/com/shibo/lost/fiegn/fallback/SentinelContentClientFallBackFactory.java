package com.shibo.lost.fiegn.fallback;

import com.shibo.lost.fiegn.client.ContentClient;
import com.shibo.lost.fiegn.client.SentinelContentClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author by shibo on 2020/8/21.
 */

@Component
public class SentinelContentClientFallBackFactory implements FallbackFactory<SentinelContentClient> {

    Logger logger = LoggerFactory.getLogger(SentinelContentClientFallBackFactory.class);
    @Override
    public SentinelContentClient create(Throwable e) {
        return new SentinelContentClient() {
            @Override
            public String sentinelContentHelloWorld() {
                logger.error("error, e:", e);
                return "数据获取异常" + e.getMessage();
            }
        };
    }
}
