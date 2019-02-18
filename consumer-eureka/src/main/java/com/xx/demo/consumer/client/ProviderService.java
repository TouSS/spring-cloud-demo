package com.xx.demo.consumer.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xx.demo.consumer.bean.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 注解的方式每个服务接口只能有一个实现客户端
 * 当需要实现多个客户端时可以使用contextId进行区分
 * e.g.
 * @FeignClient(contextId = "fooClient", name = "stores", configuration = FooConfiguration.class)
 * @FeignClient(contextId = "barClient", name = "stores", configuration = BarConfiguration.class)
 *
 * 或者手动创建客户端
 * e.g.
 * @Import(FeignClientsConfiguration.class)
 * class FooController {
 *
 * 	private FooClient fooClient;
 *
 * 	private FooClient adminClient;
 *
 *     	@Autowired
 * 	public FooController(Decoder decoder, Encoder encoder, Client client, Contract contract) {
 * 		this.fooClient = Feign.builder().client(client)
 * 				.encoder(encoder)
 * 				.decoder(decoder)
 * 				.contract(contract)
 * 				.requestInterceptor(new BasicAuthRequestInterceptor("user", "user"))
 * 				.target(FooClient.class, "http://PROD-SVC");
 *
 * 		this.adminClient = Feign.builder().client(client)
 * 				.encoder(encoder)
 * 				.decoder(decoder)
 * 				.contract(contract)
 * 				.requestInterceptor(new BasicAuthRequestInterceptor("admin", "admin"))
 * 				.target(FooClient.class, "http://PROD-SVC");
 *     }
 * }
 *
 * https://cloud.spring.io/spring-cloud-static/spring-cloud-openfeign/2.1.0.RELEASE/single/spring-cloud-openfeign.html#_creating_feign_clients_manually
 */

@FeignClient(value = "PROVIDER", fallback = ProviderServiceFallback.class)
/**
 * 如果需要获取异常数据需要配置fallbackFactory
 */
//@FeignClient(value = "PROVIDER", fallbackFactory = ProviderServiceFallbackFactory.class)
public interface ProviderService {
    @PostMapping("/user/add")
    User addUser(User user);

    @GetMapping("/user/get/{id}")
    User getUser(@PathVariable("id") Integer id);

    @GetMapping("/user/delete/{id}")
    User deleteUser(@PathVariable("id") Integer id);

    @GetMapping("/user/query")
    List<User> query();


    @GetMapping("/compute/add")
    Integer addAB(@RequestParam("a") Integer a, @RequestParam("b") Integer b);

    @GetMapping("/compute/minus")
    Integer minusAB(@RequestParam("a") Integer a, @RequestParam("b") Integer b);

    @GetMapping("/compute/multiply")
    Integer multiplyAB(@RequestParam("a") Integer a, @RequestParam("b") Integer b);

    @RequestMapping(value = "/compute/divide", method = RequestMethod.GET)
    Integer divideAB(@RequestParam("a") Integer a, @RequestParam("b") Integer b);
}
