package com.example.camunda.listener;

import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.engine.impl.bpmn.parser.BpmnParseListener;
import org.camunda.bpm.engine.impl.cfg.AbstractProcessEnginePlugin;
import org.camunda.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.springframework.stereotype.Component;

/**
 * @ClassName : InformAssigneeParseListenerPlugin
 * @Author : yangliu@tiduyun.com
 * @Date: 2020-08-25 10:11
 * @Description :
 */
@Component
public class InformAssigneeParseListenerPlugin extends AbstractProcessEnginePlugin {

    @Override
    public void preInit(ProcessEngineConfigurationImpl processEngineConfiguration) {
        List<BpmnParseListener> preParseListeners = processEngineConfiguration.getCustomPreBPMNParseListeners();
        if (preParseListeners == null) {
            preParseListeners = new ArrayList<BpmnParseListener>();
            processEngineConfiguration.setCustomPreBPMNParseListeners(preParseListeners);
        }
        preParseListeners.add(new InformAssigneeParseListener());
    }

}