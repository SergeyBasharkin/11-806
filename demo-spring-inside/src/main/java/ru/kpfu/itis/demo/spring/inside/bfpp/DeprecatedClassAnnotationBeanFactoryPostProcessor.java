package ru.kpfu.itis.demo.spring.inside.bfpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.demo.spring.inside.annotation.DeprecatedClass;

import java.util.stream.Stream;

@Component
public class DeprecatedClassAnnotationBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        String[] beanDefinitionNames = configurableListableBeanFactory.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames)
                .forEach(name -> {
                    BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(name);
                    String beanClassName = beanDefinition.getBeanClassName();
                    try {
                        Class<?> beanClass = Class.forName(beanClassName);
                        DeprecatedClass annotation = beanClass.getAnnotation(DeprecatedClass.class);
                        if (annotation != null){
                            Class newClass = annotation.newClass();
                            beanDefinition.setBeanClassName(newClass.getName());
                        }
                    } catch (Throwable ignore) { }
                });
    }
}
