# #spring

## #依赖注入

### #配置Bean的三种方式

#### #基于XML的配置

```
<bean id="demo" class="com.bean.Demo">
	<property name="name" value = "world"></property>
	<constructor-arg type="String" value ="spring"></constructor-arg>
</bean>
```

```
package com.bean;

import org.springframework.stereotype.Service;

@Service
public class Demo {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Demo(String name) {
		super();
		this.name = name;
	}

	public Demo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		
		System.out.println("Demo [name=" + name + "]");
		return "Demo [name=" + name + "]";
	}

}

```

#### #基于注解的配置

​	@Component是Spring容器中的基本注解，表示容器中的一个组件（bean），可以作用在任何层次。

注解配置示例：

```
@Component
public class ExampleBean {...}
```

这句话等效于XML文件中的配置

```
<bean id="exampleBean" class="com.bean.ExampleBean"> </bean>
```

​	此外，还有一些其他的可以被用来注解bean的注解，这些可以让注解类本身的用途更加清晰，此外，特定的注解也具备特定的功能。

##### #Bean的生命周期注解

​	1.）实现Spring提供的两个接口：InitializingBean  &  DisposableBean

```
public class LifeBean implements InitializingBean , DisposableBean {...}
```

​	2.）在XML文件中使用 <bean> 的 init-method  &  destory-method 属性，指定初始化之和回调之前的回调方法

```
<bean id = "lifeBean" class ="com.bean.LifeBean"  init-method="start" destroy-method="stop">
```

##### #Bean的自动装配注解

​	@Autowired可以对成员变量、方法和构造函数进行标注，来完成自动装配的工作，他根据类型进行自动装配，如果需要按名称进行装配，则需要配合@Qualifier使用。

​	当标注了@Autowired的方法所需的类型在Spring容器中不存在的话会抛出异常。

```
@Service  
public class ExampleBean {
	@Autowired
	private AnotherBean beanOne;
	@Autowired
	@Qualifier("ac")
	private YetAnotherBean beanTwo;
```

#### #基于JAVA类的配置

​	基于Java类定义Bean配置元数据，其实就是通过Java类定义Spring配置元数据，且直接消除XML配置文件。

​	首先让我们看一下基于Java类如何定义Bean配置元数据，具体步骤如下：

​		1. 使用@Configuration注解需要作为配置的类，表示该类将定义Bean的元数据

​		2. 使用@Bean注解相应的方法，该方法名默认就是Bean的名称，该方法返回值就是Bean的对象。

​		3. AnnotationConfigApplicationContext或子类进行加载基于java类的配置

```
@Configuration
public class SampleConfig {...}
```

```
package com.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class SampleConfig {
	
	@Bean
	public ExampleBean exampleBean() {
		
		ExampleBean exampleBean = new ExampleBean();
		exampleBean.setBeanOne(anotherBean());
		exampleBean.setBeanTwo(yetAnotherBean());
		return exampleBean;
	}
	
	private AnotherBean anotherBean() {
		AnotherBean anotherBean = new AnotherBean();
		anotherBean.setName("i ' m anotherBean");
		return anotherBean;
	}

	private YetAnotherBean yetAnotherBean() {
		YetAnotherBean yetAnotherBean = new YetAnotherBean();
		yetAnotherBean.setName("i ' m yetAnotherBean");
		return yetAnotherBean;
	}
}

```

# #Spring-Boot

## #@PropertySource

​	通过@PropertySource注解将properties配置文件中的值存储到Spring的 Environment中，Environment接口提供方法去读取配置文件中的值，参数是properties文件中定义的key值。

```
@Configuration
@PropertySource(value = "classpath:test.properties")
@ConfigurationProperties(prefix = "com.example")
public class User {...}

```

## #@RestController

​	@RestController是@ResponseBody和@Controller的组合注解。

​	原来返回json需要@ResponseBody和@Controller配合。

```
@RestController
public class MyController {...}
```

## #@RequestMapping

​	@RequestMapping 配置url映射	

​	@RequestMapping此注解即可以作用在控制器的某个方法上，也可以作用在此控制器类上。

​	当控制器在类级别上添加@RequestMapping注解时，这个注解会应用到控制器的所有处理器方法上。处理器方法上的@RequestMapping注解会对类级别上的@RequestMapping的声明进行补充。

```
@RequestMapping(value = "/my")
	public String my() {
		return name + ":" + age;		
	}
```

## #@ConfigurationProperties

​	class文件配置

```
@ConfigurationProperties(prefix = "my")
public class ConfigBean {...}
```

application.yml文件配置

```
my:
  name: jacob
  age: 22
  number: ${random.int[100,999]}
  uuid: ${random.uuid}
  max: ${random.int(10)}
  value: ${random.value
  greeting: Hi , I ' m ${my.name}
```

## #Profile

​	Spring Profiles提供了一种隔离应用程序配置部分的方法，并使其仅在某些环境中可用。任何`@Component`或`@Configuration`可以标记`@Profile`以限制何时加载：

```
@Component
@Profile({"hello","default","dev"})
public class HelloWorld implements Message {

	@Value("${name:World}")
	private String name;

	@Override
	public String getMessage() {
		
		return "Hello" + this.name;
	}
}
```

​	在常规Spring方式中，您可以使用`spring.profiles.active` `Environment`属性指定哪些配置文件处于活动状态。您可以通过任何常用方式指定属性，例如，您可以将其包含在`application.properties`：

```
spring.profiles.active = dev，hello
```

添加活动配置文件

```
name: Jacob
hello: Good Morning
spring:
  profiles:
    active: GoodBye
    
---
spring:
  profiles: GoodBye,dev
name: 123
age: 22
```

## #Logback-日志

​	Spring Boot包含许多Logback扩展，可以帮助进行高级配置。您可以在`logback-spring.xml`配置文件中使用这些扩展名。

```
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
	<include resource = "org/springframework/boot/logging/logback/base.xml"></include>
	<logger name = "com.example" level = "DEBUG"></logger>
	<springProfile name = "staging">
		<logger name = "com.example" level = "TRACE"></logger>
	</springProfile>
</configuration>
```

## #log4j-日志

​	log4j规定了默认的几个级别：trace<debug<info<warn<error

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
    <exclusions>
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-logging</artifactId>
        </exclusion>
    </exclusions>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-log4j2</artifactId>
</dependency>
```

## #Actuator

修改pom.xml文件配置

```
	<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>
```

application.yml文件配置

```
management:
  security:
    enabled:  false 
  port: 8081
  context-path: /jacob
  
  
#endpoints:
#  actuator:
#    enabled: true
#  shutdown:
#    enabled: true
    
info:
  app: 
    name: jacobo
    version: 1.0.0
```

class文件配置

```
@RestController
public class Hello {
	@RequestMapping("/hello")
	public String index() {
		return "Hello World";
	}	
}
```

## #Spring boot Admin监控

​	Spring Boot Admin 是一个针对spring-boot的actuator接口进行UI美化封装的监控工具。实现对多个spring boot应用进行监控，每个客户端应用可以通过HTTP或者使用 Eureka注册到admin server中进行展示。

admin-server：8001

1.) 修改pom.xml文件

```
	<!--引入admin server依赖-->
		<dependency>
			<groupId>de.codecentric</groupId>
			<artifactId>spring-boot-admin-server</artifactId>
			<version>1.5.6</version>
		</dependency>
		<!--admin server的展示-->
		<dependency>
			<groupId>de.codecentric</groupId>
			<artifactId>spring-boot-admin-server-ui</artifactId>
			<version>1.5.6</version>
		</dependency>
```

2.) 启动类上加注解

```
@Configuration
@EnableAutoConfiguration
@EnableAdminServer
```

admin-client：8002

1.) 修改pom.xml文件

```
<dependency>
   <groupId>de.codecentric</groupId>
   <artifactId>spring-boot-admin-starter-client</artifactId>
   <version>1.5.6</version>
</dependency>
```

2.) 修改application.properties文件

```
spring.boot.admin.url=http://localhost:8002 
management.security.enabled=false
```

