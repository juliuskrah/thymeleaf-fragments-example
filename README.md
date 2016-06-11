# Thymeleaf Fragments Example
[![Build Status](https://travis-ci.org/juliuskrah/thymeleaf-fragments-example.svg?branch=master)](https://travis-ci.org/juliuskrah/thymeleaf-fragments-example)

This is to illustrate layouts example in thymeleaf using the Thymeleaf Standard Layout System. For more
information on using the standard template check out [this][layouts-blog] article.

The template used in this example was downloaded from [Start Boostrap][sb-admin 2].

This example uses [Thymeleaf 3.0.0.RELEASE][Thymeleaf 3 announcement] to render the templates.

Some minor configuration changes are required to use Thymeleaf 3 with [Spring 4][Spring Framework].

## Pre-requisites
- Maven 3.3+
- Java 8+
- Jetty 9+ or Tomcat 8+ (Optional)
- Spring Framework 4.2.x
- Thymeleaf 3.0.x

## Configuration
The fist thing required is to declare your depencies in your `pom.xml`

```xml
<dependency>
  <groupId>org.thymeleaf</groupId>
  <artifactId>thymeleaf</artifactId>
  <version>3.0.0.RELEASE</version>
</dependency>
<dependency>
  <groupId>org.thymeleaf</groupId>
  <artifactId>thymeleaf-spring4</artifactId>
  <version>3.0.0.RELEASE</version>
</dependency>
```

The second thing to do is your spring configuration

```java
@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = { Controllers.class })
public class WebAppConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {
	private ApplicationContext applicationContext;

	private static final String VIEWS = "classpath:templates/";
	...
	
	@Bean
	public ViewResolver viewResolver() {
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(templateEngine());
		resolver.setCharacterEncoding("UTF-8");
		return resolver;
	}

	private TemplateEngine templateEngine() {
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setTemplateResolver(templateResolver());
		return engine;
	}

	private ITemplateResolver templateResolver() {
		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
		resolver.setApplicationContext(applicationContext);
		resolver.setPrefix(VIEWS);
		resolver.setSuffix(".html");
		resolver.setTemplateMode(TemplateMode.HTML);
		return resolver;
	}
}
```

The first difference with the Thymeleaf 3 configuration is that now the recommended template resolver for Spring applications is 
`SpringResourceTemplateResolver`. It needs a reference to the Spring `ApplicationContext` so the configuration bean has to implement 
the `ApplicationContextAware` interface.

The second difference is that the template mode has a value of `TemplateMode.HTML`. Template modes are not strings anymore and the 
possible values are a bit different from Thymeleaf 2.

## Running the Application
Your can run the application by specifying a maven goal `mvn jetty:run`, which will start an embedded Jetty instance.
Visit your new application on [http://127.0.0.1:8080/](http://127.0.0.1:8080/).



[layouts-blog]: http://www.thymeleaf.org/doc/articles/layouts.html
[sb-admin 2]: http://startbootstrap.com/template-overviews/sb-admin-2/
[Thymeleaf 3 announcement]: http://forum.thymeleaf.org/Thymeleaf-3-0-is-here-td4029676.html
[Spring Framework]: http://projects.spring.io/spring-framework/
