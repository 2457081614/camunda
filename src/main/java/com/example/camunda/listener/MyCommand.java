package com.example.camunda.listener;

import org.camunda.bpm.engine.impl.interceptor.Command;
import org.camunda.bpm.engine.impl.interceptor.CommandContext;

/**
 * @Author : yangliu@tiduyun.com
 */
public class MyCommand implements Command<Void> {



    @Override
    public Void execute(CommandContext commandContext) {
        System.out.println("hello ");
        return null;
    }
}
