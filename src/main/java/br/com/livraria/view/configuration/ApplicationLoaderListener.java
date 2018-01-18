package br.com.livraria.view.configuration;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationLoaderListener implements ApplicationListener<ContextRefreshedEvent> {


	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

	}

}