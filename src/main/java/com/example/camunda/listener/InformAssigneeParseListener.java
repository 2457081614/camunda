package com.example.camunda.listener;

import org.camunda.bpm.engine.impl.bpmn.behavior.UserTaskActivityBehavior;
import org.camunda.bpm.engine.impl.bpmn.parser.AbstractBpmnParseListener;
import org.camunda.bpm.engine.impl.pvm.delegate.ActivityBehavior;
import org.camunda.bpm.engine.impl.pvm.process.ActivityImpl;
import org.camunda.bpm.engine.impl.pvm.process.ScopeImpl;
import org.camunda.bpm.engine.impl.util.xml.Element;

/**
 * @ClassName : InformAssigneeParseListener
 * @Author : yangliu@tiduyun.com
 * @Date: 2020-08-25 10:10
 * @Description :
 */
public class InformAssigneeParseListener extends AbstractBpmnParseListener {

    @Override
    public void parseUserTask(Element userTaskElement, ScopeImpl scope, ActivityImpl activity) {
        ActivityBehavior activityBehavior = activity.getActivityBehavior();
        if (activityBehavior instanceof UserTaskActivityBehavior) {
            UserTaskActivityBehavior userTaskActivityBehavior = (UserTaskActivityBehavior) activityBehavior;
            userTaskActivityBehavior.getTaskDefinition().addTaskListener("assignment", InformAssigneeTaskListener.getInstance());
        }
    }
}