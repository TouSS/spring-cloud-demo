package com.xx.demo.consumer.configuration;

import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

import static feign.FeignException.errorStatus;

/**
 * 自定义feign异常处理
 */
// @Configuration 不生效
public class FeignErrorDecoder implements ErrorDecoder {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public Exception decode(String methodKey, Response response) {
        /**
         * 此处可以包装自己的异常返回
         */
        try {
            logger.info("methodKey: {}", methodKey);
            logger.info("status: {}", response.status());
            logger.info("reason: {}", response.reason());
            logger.info("body: {}", Util.toString(response.body().asReader()));
        } catch (Exception e) {

        }
        return new RuntimeException();
    }
}
