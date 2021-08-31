package com.xiaoju.framework.controller;

import com.xiaoju.framework.entity.response.controller.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @program case-server
 * @description: 压测接口demo
 * @author: xiaopeng
 * @create: 2021/08/31 11:44
 */
@RestController
@RequestMapping("/perf")
public class PerfController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PerfController.class);

    @GetMapping(value = "/sleep")
    public Response<?> sleepSomeSeconds(@RequestParam @NotNull(message = "seconds为空") Long seconds) throws InterruptedException {
        LOGGER.info("sleep {} seconds.", seconds);
        Thread.sleep(seconds * 1000);
        return Response.success();
    }
}
 