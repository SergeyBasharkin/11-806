package ru.kpfu.itis.demo.spring.inside.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import ru.kpfu.itis.demo.spring.inside.annotation.InjectRandomInt;

import java.lang.reflect.Field;
import java.util.Random;
import java.util.stream.Stream;

@Component
public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Random random = new Random();
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        Stream.of(declaredFields)
                .filter(field ->
                        field.getAnnotation(InjectRandomInt.class) != null)
                .forEach(field -> {
                    InjectRandomInt injectRandomInt = field.getAnnotation(InjectRandomInt.class);
                    int min = injectRandomInt.min();
                    int max = injectRandomInt.max();
                    int i = random.nextInt(max - min) + min;
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, bean, i);
                });
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }
}
