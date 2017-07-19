package net.jamesdaniel.cms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import net.jamesdaniel.cms.converter.SystemToSystemsConverter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "net.jamesdaniel.cms")
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Autowired
	SystemToSystemsConverter systemToSystemsConverter;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	/**
     * Configure Converter to be used.
     * In our example, we need a converter to convert string values[system] to Systems in form.jsp
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(systemToSystemsConverter);
    }
	
	/*
	@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        MappingJackson2HttpMessageConverter jacksonMessageConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = jacksonMessageConverter.getObjectMapper();

        objectMapper.registerModule(new JodaModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);

        converters.add(jacksonMessageConverter);
    }
	*/
    
    @Override
    public void configurePathMatch(PathMatchConfigurer matcher) {
        matcher.setUseRegisteredSuffixPatternMatch(true);
    }
    
    
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
	
	
	
}
