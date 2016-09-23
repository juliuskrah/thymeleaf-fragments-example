package com.jipasoft.thymeleaf.config;

import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import com.jipasoft.thymeleaf.web.Controllers;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = { Controllers.class })
public class WebAppConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private ApplicationContext applicationContext;

	private static final String VIEWS = "classpath:templates/";

	private static final String RESOURCES_HANDLER = "/static/**";
	private static final String RESOURCES_LOCATION = "classpath:static/";

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		log.info("Registering resources...");
		registry.addResourceHandler(RESOURCES_HANDLER).addResourceLocations(RESOURCES_LOCATION);
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		log.debug("Setting up ApplicationContext for Thymeleaf 3...");
		this.applicationContext = applicationContext;
	}

	@Bean
	public ViewResolver viewResolver() {
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(templateEngine());
		resolver.setCharacterEncoding(Charset.forName("UTF-8").name());
		return resolver;
	}

	private TemplateEngine templateEngine() {
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setTemplateResolver(templateResolver());
		engine.setEnableSpringELCompiler(true);
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
