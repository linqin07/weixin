package com.controller;

import com.model.*;
import com.util.HC;
import com.util.WeixinUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class CreateMenu {

    Logger logger = Logger.getLogger("ss");

    @RequestMapping(value = "/CreateMenu",method = RequestMethod.GET)
    public String index() {
        // 第三方用户唯一凭证
        String appId = HC.appID;
        // 第三方用户唯一凭证密钥
        String appSecret = HC.appsecret;

        // 调用接口获取access_token
        AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);

        if (null != at)

        {
            // 调用接口创建菜单
            int result = WeixinUtil.createMenu(getMenu(), at.getToken());

            // 判断菜单创建结果
            if (0 == result) {
                logger.info("菜单创建成功！");
            } else {
                logger.info("菜单创建失败，错误码：" + result);
            }
        }

        return null;
    }

    /**
     * 组装菜单数据
     *
     * @return
     */
    private static Menu getMenu() {
        CommonButton btn11 = new CommonButton();
        btn11.setName("浦发信用卡申请");
        btn11.setType("click");
        btn11.setKey("PuFa");

        CommonButton btn12 = new CommonButton();
        btn12.setName("民生信用卡申请");
        btn12.setType("click");
        btn12.setKey("MinSheng");

        CommonButton btn13 = new CommonButton();
        btn13.setName("我要贷款");
        btn13.setType("click");
        btn13.setKey("DaiKuan");

        CommonButton btn14 = new CommonButton();
        btn14.setName("我要绑定");
        btn14.setType("click");
        btn14.setKey("BangDing");

        CommonButton btn15 = new CommonButton();
        btn15.setName("自助缴费");
        btn15.setType("click");
        btn15.setKey("JiaoFei");

        CommonButton btn21 = new CommonButton();
        btn21.setName("我的交易");
        btn21.setType("click");
        btn21.setKey("Trans");

        CommonButton btn22 = new CommonButton();
        btn22.setName("我的资料");
        btn22.setType("click");
        btn22.setKey("Info");

        CommonButton btn23 = new CommonButton();
        btn23.setName("我的管家");
        btn23.setType("click");
        btn23.setKey("GuanJia");

        CommonButton btn24 = new CommonButton();
        btn24.setName("我要解绑");
        btn24.setType("click");
        btn24.setKey("JieBang");

        CommonButton btn25 = new CommonButton();
        btn25.setName("购买终端");
        btn25.setType("click");
        btn25.setKey("Buy");

        CommonButton btn31 = new CommonButton();
        btn31.setName("民生直销银行");
        btn31.setType("click");
        btn31.setKey("ZhiXiao");

        CommonButton btn32 = new CommonButton();
        btn32.setName("微官网");
        btn32.setType("click");
        btn32.setKey("WeiGuanWang");

        CommonButton btn33 = new CommonButton();
        btn33.setName("mPos操作指引");
        btn33.setType("click");
        btn33.setKey("mPos");

        CommonButton btn34 = new CommonButton();
        btn34.setName("客户端下载");
        btn34.setType("click");
        btn34.setKey("DownLoad");

        ViewButton viewButton = new ViewButton();
        viewButton.setName("我是链接");
        viewButton.setType("view");
        viewButton.setUrl("http://www.baidu.com");


        ComplexButton mainBtn1 = new ComplexButton();
        mainBtn1.setName("业务申请");
        mainBtn1.setSub_button(new Button[]{btn11, btn12, btn13, btn14, btn15});

        ComplexButton mainBtn2 = new ComplexButton();
        mainBtn2.setName("我的服务");
        mainBtn2.setSub_button(new Button[]{btn21, btn22, btn23, btn24, btn25});

        ComplexButton mainBtn3 = new ComplexButton();
        mainBtn3.setName("掌柜地盘");
        mainBtn3.setSub_button(new Button[]{btn31, btn32, btn33, btn34});

        /**
         * 这是公众号xiaoqrobot目前的菜单结构，每个一级菜单都有二级菜单项<br>
         *
         * 在某个一级菜单下没有二级菜单的情况，menu该如何定义呢？<br>
         * 比如，第三个一级菜单项不是“更多体验”，而直接是“幽默笑话”，那么menu应该这样定义：<br>
         * menu.setButton(new Button[] { mainBtn1, mainBtn2, btn33 });
         */
        Menu menu = new Menu();
        menu.setButton(new Button[]{mainBtn1, mainBtn2, viewButton});

        return menu;
    }
}
