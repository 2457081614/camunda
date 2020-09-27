package com.example.camunda.listener;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

/**
 * @ClassName : RollBackListener
 * @Author : yangliu@tiduyun.com
 * @Date: 2020-09-01 16:14
 * @Description :
 */
public class RollBackListener implements ExecutionListener {

    @Override
    public void notify(DelegateExecution execution) throws Exception {

        System.out.println("roll back");

    }
}
