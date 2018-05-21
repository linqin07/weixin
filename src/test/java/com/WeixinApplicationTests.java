package com;


import com.mapper.UserMapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WeixinApplication.class)

public class WeixinApplicationTests {

    @Autowired
    public UserMapper userMapper;

//    @Test
    @Ignore
    public void findByName() throws Exception {
        userMapper.findUserInfo();
    }

}