package com.nisum.employeemanagementsystem.Custom.Validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

public class ForeignKeyValidator implements ConstraintValidator<IForeignKeyValidator, Object> {
    private String entity;
    private Class<?> type = null;

    @Autowired
    private ApplicationContext context;
    private Object instance;
    @Override
    public void initialize(IForeignKeyValidator constraintAnnotation) {
        if (constraintAnnotation == null) {

    } else {
        entity=constraintAnnotation.className();
        try {
            type = Class.forName("com.nisum.employeemanagementsystem.Repository."+entity+"Repository");
            instance = context.getBean(type);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        Boolean result=false;
        if(value==null) return true;
        try {
            Object object = type.getMethod("findById", Object.class).invoke(instance, value);
            result = object != Optional.empty();
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            return false;
        }
        return result;
    }



}
