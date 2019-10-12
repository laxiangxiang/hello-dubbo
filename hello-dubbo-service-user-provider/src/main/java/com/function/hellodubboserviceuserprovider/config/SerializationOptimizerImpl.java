package com.function.hellodubboserviceuserprovider.config;

import org.apache.dubbo.common.serialize.support.SerializationOptimizer;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class SerializationOptimizerImpl implements SerializationOptimizer {

    @Override
    public Collection<Class> getSerializableClasses() {
        List<Class> classes = new LinkedList<>();
//        classes.add() //添加自己需要序列化的类,需要为被序列化的类实现一个无参构造函数，否则会使用java序列化
        return classes;
    }
}
