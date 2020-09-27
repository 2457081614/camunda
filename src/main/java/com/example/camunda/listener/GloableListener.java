package com.example.camunda.listener;

import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.impl.ServletProcessApplication;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName : GloableListener
 * @Author : yangliu@tiduyun.com
 * @Date: 2020-08-25 09:29
 * @Description :
 */
@Component
public class GloableListener extends ServletProcessApplication {

    @Override
    public TaskListener getTaskListener() {
        return new TaskListener() {
            @Override
            public void notify(DelegateTask delegateTask) {
                // handle all Task Events from Invoice Process
                System.out.println(delegateTask.getAssignee());
            }
        };
    }

    @Override
    public ExecutionListener getExecutionListener() {
        return new ExecutionListener() {
            @Override
            public void notify(DelegateExecution execution) throws Exception {
                System.out.println(execution.getEventName());
            }
        };
    }
}
