package com.shibo.lost.fiegn.fallback;

import com.shibo.lost.fiegn.client.ContentClient;

/**
 * @author by shibo on 2020/8/21.
 */
// 使用ContentClientFallBackFactory代替
// @Component
public class SentinelContentClientFallBack implements ContentClient {

    @Override
    public String helloWorld() {
        return "熔断了";
    }
}
