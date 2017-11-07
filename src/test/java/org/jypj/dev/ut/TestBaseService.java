package org.jypj.dev.ut;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.jypj.dev.util.HttpUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-mybatis.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class TestBaseService {


    @Test
    public void testInsertUser() throws Exception {
        String s = HttpUtils.sendGetRequestForService("https://web.umeng.com/main.php?c=user&a=tip&code=1000&param3=aHR0cHM6Ly93ZWIudW1lbmcuY29tL21haW4ucGhwP2M9c2l0ZSZhPWZyYW1lJnNpdGVpZD0xMjYyMTIyNDMw&channel='+escape(window.location.hash)");
        System.out.println(s);
    }

}
