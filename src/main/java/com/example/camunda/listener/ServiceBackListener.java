package com.example.camunda.listener;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

/**
 * @ClassName : RollBackListener
 * @Author : yangliu@tiduyun.com
 * @Date: 2020-09-01 16:14
 * @Description :
 */
public class ServiceBackListener implements ExecutionListener {

    @Override
    public void notify(DelegateExecution execution) throws Exception {

        System.out.println("service ");
        throw new RuntimeException("111111111111111111");

    }
}
