package ru.kpfu.itis.demo.scope.config;

import javafx.util.Pair;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class CountedScopeConfigurer implements Scope {

    private AtomicInteger count = new AtomicInteger();
    Map<String, Pair<AtomicInteger, Object>> atomicIntegerMap = new HashMap<>();

    @Override
    public Object get(String s, ObjectFactory<?> objectFactory) {
        if (atomicIntegerMap.containsKey(s)){
            Pair<AtomicInteger, Object> pair = atomicIntegerMap.get(s);
            pair.getKey().incrementAndGet();
            if (pair.getKey().get() >= 2) {
                atomicIntegerMap.put(s, new Pair<>(new AtomicInteger(), objectFactory.getObject()));
            }

        } else {
            atomicIntegerMap.put(s, new Pair<>(new AtomicInteger(1), objectFactory.getObject()));
        }
        return atomicIntegerMap.get(s).getValue();
    }

    @Override
    public Object remove(String s) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
