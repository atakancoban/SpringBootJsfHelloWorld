package com.atakancoban.helloJsf;



import javax.faces.webapp.FacesServlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.sun.faces.config.ConfigureListener;



@SpringBootApplication
@Configuration
@ComponentScan("com.atakancoban")
public class HelloJsfApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloJsfApplication.class, args);
	}
	
	//JSF Configration Başlangıc
	@Bean
	public ServletRegistrationBean<FacesServlet> facesServletRegistraiton() {
		ServletRegistrationBean<FacesServlet> registration = new ServletRegistrationBean<FacesServlet>(new FacesServlet(),
				new String[] { "*.xhtml" });
		registration.setName("Faces Servlet");
		registration.setLoadOnStartup(1);

		return registration;
	}
	
	@Bean
	public ServletContextInitializer servletContextInitializer() {
		return servletContext -> {
			servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
		};
	}
	
	@Bean
	public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
		return new ServletListenerRegistrationBean<ConfigureListener>(new ConfigureListener());
	}
	//JSF Configration Sonu
}
