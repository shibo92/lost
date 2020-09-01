package com.shibo.lost.fiegn.fallback;

import com.shibo.lost.fiegn.client.ContentClient;
import org.springframework.stereotype.Component;

/**
 * @author by shibo on 2020/8/21.
 */
// 使用ContentClientFallBackFactory代替
// @Component
public class ContentClientFallBack implements ContentClient {

    @Override
    public String helloWorld() {
        return "数据获取异常";
    }
}
