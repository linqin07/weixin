package com.mapper;

import com.WeixinApplication;
import com.entity.User;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WeixinApplication.class)
public class UserMapperTest {

      @Resource
        private UserMapper userMapper;

//        @Test
        @Rollback
        @Ignore
        public void findByName() throws Exception {
             userMapper.findUserInfo();
        }


}
