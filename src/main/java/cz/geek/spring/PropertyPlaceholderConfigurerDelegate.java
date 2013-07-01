package cz.geek.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * PropertyPlaceholderConfigurer which delegates placeholder resolving to {@link PropertyPlaceholderConfigurer} given
 * in constructor.
 * This delegate is particularly useful when you need to inject properties to Spring MVC Controller.
 *
 * http://forum.springsource.org/showthread.php?82059-How-to-inject-property-value-from-PropertyPlaceholderConfigurer-in-another-bean
 *
 */
public class PropertyPlaceholderConfigurerDelegate implements BeanFactoryPostProcessor {

    private PropertyPlaceholderConfigurer placeHolderConfigurer;

    public PropertyPlaceholderConfigurerDelegate(PropertyPlaceholderConfigurer placeHolderConfigurer) {
        this.placeHolderConfigurer = placeHolderConfigurer;
    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        placeHolderConfigurer.postProcessBeanFactory(beanFactory);
    }

}
