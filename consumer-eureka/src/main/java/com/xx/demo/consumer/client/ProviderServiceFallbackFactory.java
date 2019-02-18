package com.xx.demo.consumer.client;

import com.xx.demo.consumer.bean.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProviderServiceFallbackFactory implements FallbackFactory<ProviderService> {

    @Override
    public ProviderService create(Throwable throwable) {
        /**
         * 这个可以获取Feign封装的错误异常, 如果需要获取原始异常数据需要自定义ErrorDecoder, 然后返回自定义异常。
         * 如果不希望进入熔断可以吧异常封装为HystrixBadRequestException。
         */

        //返回失败调用
        return new ProviderService() {
            @Override
            public User addUser(User user) {
                return null;
            }

            @Override
            public User getUser(Integer id) {
                return null;
            }

            @Override
            public User deleteUser(Integer id) {
                return null;
            }

            @Override
            public List<User> query() {
                return null;
            }

            @Override
            public Integer addAB(Integer a, Integer b) {
                return null;
            }

            @Override
            public Integer minusAB(Integer a, Integer b) {
                return null;
            }

            @Override
            public Integer multiplyAB(Integer a, Integer b) {
                return null;
            }

            @Override
            public Integer divideAB(Integer a, Integer b) {
                return null;
            }
        };
    }
}
