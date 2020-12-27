package com.luv2code.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.HttpMethods;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import com.luv2code.ecommerce.entity.Product;
import com.luv2code.ecommerce.entity.ProductCategory;
@Configuration
public class MyDataRestConfig  implements RepositoryRestConfigurer{

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST,HttpMethod.DELETE };
		
		//disable Https Methods for Product
		config.getExposureConfiguration().forDomainType(Product.class)
										.withItemExposure((metadata,HttpMethod)-> HttpMethod.disable(theUnsupportedActions))
										.withCollectionExposure((metadata,HttpMethod)-> HttpMethod.disable(theUnsupportedActions));
		//disable Https Methods for Product Category
				config.getExposureConfiguration().forDomainType(ProductCategory.class)
												.withItemExposure((metadata,HttpMethod)-> HttpMethod.disable(theUnsupportedActions))
												.withCollectionExposure((metadata,HttpMethod)-> HttpMethod.disable(theUnsupportedActions));
				
	}

}
