package com.example.camunda.listener;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

/**
 * @ClassName : TaskListenter
 * @Author : yangliu@tiduyun.com
 * @Date: 2020-08-24 17:57
 * @Description :
 */
public class TaskListenter implements ExecutionListener {
    @Override
    public void notify(DelegateExecution execution) throws Exception {
        System.out.println(execution.getEventName());
    }
}
