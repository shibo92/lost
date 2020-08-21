package com.shibo.lost.fiegn.fallback;

import com.shibo.lost.fiegn.client.ContentClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author by shibo on 2020/8/21.
 */

@Component
public class ContentClientFallBackFactory implements FallbackFactory<ContentClient> {

    Logger logger = LoggerFactory.getLogger(ContentClientFallBackFactory.class);
    @Override
    public ContentClient create(Throwable e) {
        return new ContentClient() {
            @Override
            public String helloWorld() {
                logger.error("error, e:", e);
                return "数据获取异常" + e.getMessage();
            }
        };
    }
}
