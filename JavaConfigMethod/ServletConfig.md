# Servlet配置方式启动

## 1 启动原理

### 1.1 SPI

spring-web项目下META-INF\services\javax.servlet.ServletContainerInitializer文件：

```
org.springframework.web.SpringServletContainerInitializer
```

其中：

```
@HandlesTypes(WebApplicationInitializer.class)
public class SpringServletContainerInitializer implements 			
											ServletContainerInitializer {
```

通过实现WebApplicationInitializer接口,便可以在容器启动的时候实现servlet的初始化.

### 1.2 WebApplicationInitializer

```
WebApplicationInitializer
 |-AbstractContextLoaderInitializer
 	|-AbstractDispatcherServletInitializer
 		|-AbstractAnnotationConfigDispatcherServletInitializer
 |-AbstractReactiveWebInitializer
```

有以下几种方式:

1. 自己实现WebApplicationInitializer接口
2. 继承抽象类AbstractDispatcherServletInitializer
3. 继承抽象类AbstractAnnotationConfigDispatcherServletInitializer

## 2 搭建

```
public class MyServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ServletConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

```

```
@Configuration
//@ComponentScan(basePackages={"com.spring.mvc"})
public class RootConfig {

}
```

```
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.spring.mvc"})
public class ServletConfig extends WebMvcConfigurationSupport {

}
```

```
@RestController
@RequestMapping("/api")
public class BaseController {

    private static final String HELLO = "hello";

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return HELLO;
    }
}
```

pom.xml

```
<build>
        <plugins> <!-- jetty的maven插件，配置这个插件之后，就可以直接在项目的跟目录执行mvn jetty:run来运行项目。 而无需把项目打成war扔到web容器中 -->
            <plugin>
                <groupId>org.eclipse.jetty</groupId>
                <artifactId>jetty-maven-plugin</artifactId>
                <version>9.4.16.v20190411</version>
                <configuration>
                    <scanIntervalSeconds>10</scanIntervalSeconds>
                    <stopKey>foo</stopKey>
                    <stopPort>9999</stopPort>
                    <httpConnector> <!-- jetty端口 -->
                        <port>9090</port>
                    </httpConnector>
                    <webApp>
                        <contextPath>/</contextPath>
                    </webApp>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-war-plugin</artifactId>
                <version>3.2.3</version>
                <configuration> <!-- 因为本例子没有用到web.xml，也没有创建web.xml，所以这里必须配置这个插件。 否则使用maven打包的时候会有问题 -->
                    <failOnMissingWebXml>false</failOnMissingWebXml>
                </configuration>
            </plugin>
        </plugins>
    </build>
```

## 3 详细配置

