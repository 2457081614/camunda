package com.example.camunda.listener;

import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;

/**
 * @ClassName : InformAssigneeTaskListener
 * @Author : yangliu@tiduyun.com
 * @Date: 2020-08-25 10:10
 * @Description :
 */
public class InformAssigneeTaskListener implements TaskListener {

    public static List<String> assigneeList = new ArrayList<String>();

    private static InformAssigneeTaskListener instance = null;

    protected InformAssigneeTaskListener() {
    }

    public static InformAssigneeTaskListener getInstance() {
        if (instance == null) {
            instance = new InformAssigneeTaskListener();
        }
        return instance;
    }

    @Override
    public void notify(DelegateTask delegateTask) {

        String assignee = delegateTask.getAssignee();
        assigneeList.add(assignee);

        // LOGGER.info("Hello " + assignee + "! Please start to work on your
        // task " + delegateTask.getName());
    }

}