package com.baseTest;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.service.provider.ProviderServer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProviderServer.class)
public class JunitBaseTest{

}
