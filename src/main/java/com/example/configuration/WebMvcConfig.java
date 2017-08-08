package com.example.configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	 @Override
	    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		 PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
		 resolver.setPageParameterName("page.page");
		 resolver.setSizeParameterName("page.size");
		 resolver.setFallbackPageable(new PageRequest(0, 50));
		 resolver.setOneIndexedParameters(true);
		 argumentResolvers.add(resolver);
		 super.addArgumentResolvers(argumentResolvers);
	    }
	 
	 @Bean
		public HttpMessageConverters customConverters()
		{
			Collection<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
			GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();
			messageConverters.add(gsonHttpMessageConverter);
			HttpMessageConverters httpMessageConverters = new HttpMessageConverters(true, messageConverters);
			return httpMessageConverters;
		}

}