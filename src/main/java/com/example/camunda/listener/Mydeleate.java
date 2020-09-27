package com.example.camunda.listener;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * @ClassName : Mydeleate
 * @Author : yangliu@tiduyun.com
 * @Date: 2020-08-24 17:46
 * @Description :
 */
public class Mydeleate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {

        System.out.println(execution.getEventName() + "  " +execution.getCurrentActivityName());
    }
}
