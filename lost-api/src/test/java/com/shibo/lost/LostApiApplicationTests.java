package com.shibo.lost;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.context.ContextUtil;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LostApiApplicationTests {

    @Test
    void contextLoads() {
        ContextUtil.enter("entranceOne", "appA");
        Entry nodeA = null;
        try {
            nodeA = SphU.entry("nodeA");
        } catch (BlockException e) {
            e.printStackTrace();
        } finally {
            if (nodeA != null) {
                nodeA.exit();
            }
        }
        ContextUtil.exit();
    }

}
