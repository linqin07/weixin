package com.controller;

import com.service.EastnetService;
import com.util.SignUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@RestController
@RequestMapping("/weixintest")
public class CoreController {
    //增加日志
    private Logger log=Logger.getLogger("file");

    //验证是否来自微信服务器的消息
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String checkSignature(@RequestParam(name = "signature", required = false) String signature,
                                 @RequestParam(name = "nonce", required = false) String nonce,
                                 @RequestParam(name = "timestamp", required = false) String timestamp,
                                 @RequestParam(name = "echostr", required = false) String echostr,
                                    HttpServletRequest request) {
        request.setAttribute("signature", signature);
        request.setAttribute("timestamp", timestamp);
        request.setAttribute("nonce", nonce);
        request.setAttribute("echostr", echostr);

        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            log.info("接入成功");

            return echostr;
        }
//        log.error("接入失败");
        return "";
    }

    //统一处理消息
    @RequestMapping(value = "",method = RequestMethod.POST)
    public String index(HttpServletRequest request){
        String reqMessage = EastnetService.processRequest(request);
        return reqMessage;
    }
}
