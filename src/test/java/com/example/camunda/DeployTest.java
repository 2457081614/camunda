package com.example.camunda;

import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.repository.Deployment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName : DeployTest
 * @Author : yangliu@tiduyun.com
 * @Date: 2020-08-20 17:20
 */
@SpringBootTest(classes = CamundaApplication.class)
public class DeployTest {

    @Autowired
    private RepositoryService repositoryService;


    @Autowired
    private RuntimeService runtimeService;


    @Autowired
    private TaskService taskService;

    @Test
    public void test()
    {
        Deployment deploy = repositoryService.createDeployment().addString("fff.bpmn",
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<bpmn:definitions xmlns:bpmn=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:camunda=\"http://camunda.org/schema/1.0/bpmn\" xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\" id=\"Definitions_1ba1r2i\" targetNamespace=\"http://bpmn.io/schema/bpmn\" exporter=\"Camunda Modeler\" exporterVersion=\"4.2.0\">\n" +
                        "  <bpmn:process id=\"Process_19q4oj1\" isExecutable=\"true\">\n" +
                        "    <bpmn:extensionElements>\n" +
                        "      <camunda:executionListener class=\"com.example.camunda.listener.ServiceBackListener\" event=\"start\" />\n" +
                        "    </bpmn:extensionElements>\n" +
                        "    <bpmn:startEvent id=\"StartEvent_1\">\n" +
                        "      <bpmn:outgoing>Flow_19v7ebn</bpmn:outgoing>\n" +
                        "    </bpmn:startEvent>\n" +
                        "    <bpmn:intermediateThrowEvent id=\"Event_1617krr\">\n" +
                        "      <bpmn:extensionElements>\n" +
                        "        <camunda:executionListener class=\"com.example.camunda.listener.RollBackListener\" event=\"start\" />\n" +
                        "      </bpmn:extensionElements>\n" +
                        "      <bpmn:outgoing>Flow_1hrss6j</bpmn:outgoing>\n" +
                        "      <bpmn:compensateEventDefinition id=\"CompensateEventDefinition_0w6fur8\" />\n" +
                        "    </bpmn:intermediateThrowEvent>\n" +
                        "    <bpmn:sequenceFlow id=\"Flow_1hrss6j\" sourceRef=\"Event_1617krr\" targetRef=\"Activity_1noetht\" />\n" +
                        "    <bpmn:sequenceFlow id=\"Flow_19v7ebn\" sourceRef=\"StartEvent_1\" targetRef=\"Activity_1noetht\" />\n" +
                        "    <bpmn:endEvent id=\"Event_150ijvu\">\n" +
                        "      <bpmn:incoming>Flow_1rsdpe2</bpmn:incoming>\n" +
                        "    </bpmn:endEvent>\n" +
                        "    <bpmn:sequenceFlow id=\"Flow_1rsdpe2\" sourceRef=\"Activity_1noetht\" targetRef=\"Event_150ijvu\" />\n" +
                        "    <bpmn:serviceTask id=\"Activity_1noetht\" name=\"事件测试\" camunda:class=\"com.example.camunda.listener.ServiceBackListener\">\n" +
                        "      <bpmn:incoming>Flow_1hrss6j</bpmn:incoming>\n" +
                        "      <bpmn:incoming>Flow_19v7ebn</bpmn:incoming>\n" +
                        "      <bpmn:outgoing>Flow_1rsdpe2</bpmn:outgoing>\n" +
                        "    </bpmn:serviceTask>\n" +
                        "  </bpmn:process>\n" +
                        "  <bpmndi:BPMNDiagram id=\"BPMNDiagram_1\">\n" +
                        "    <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"Process_19q4oj1\">\n" +
                        "      <bpmndi:BPMNEdge id=\"Flow_1hrss6j_di\" bpmnElement=\"Flow_1hrss6j\">\n" +
                        "        <di:waypoint x=\"302\" y=\"181\" />\n" +
                        "        <di:waypoint x=\"280\" y=\"181\" />\n" +
                        "        <di:waypoint x=\"280\" y=\"160\" />\n" +
                        "      </bpmndi:BPMNEdge>\n" +
                        "      <bpmndi:BPMNEdge id=\"Flow_19v7ebn_di\" bpmnElement=\"Flow_19v7ebn\">\n" +
                        "        <di:waypoint x=\"188\" y=\"120\" />\n" +
                        "        <di:waypoint x=\"230\" y=\"120\" />\n" +
                        "      </bpmndi:BPMNEdge>\n" +
                        "      <bpmndi:BPMNEdge id=\"Flow_1rsdpe2_di\" bpmnElement=\"Flow_1rsdpe2\">\n" +
                        "        <di:waypoint x=\"330\" y=\"120\" />\n" +
                        "        <di:waypoint x=\"362\" y=\"120\" />\n" +
                        "      </bpmndi:BPMNEdge>\n" +
                        "      <bpmndi:BPMNShape id=\"Event_0vwbiz3_di\" bpmnElement=\"Event_1617krr\">\n" +
                        "        <dc:Bounds x=\"302\" y=\"163\" width=\"36\" height=\"36\" />\n" +
                        "      </bpmndi:BPMNShape>\n" +
                        "      <bpmndi:BPMNShape id=\"_BPMNShape_StartEvent_2\" bpmnElement=\"StartEvent_1\">\n" +
                        "        <dc:Bounds x=\"152\" y=\"102\" width=\"36\" height=\"36\" />\n" +
                        "      </bpmndi:BPMNShape>\n" +
                        "      <bpmndi:BPMNShape id=\"Event_150ijvu_di\" bpmnElement=\"Event_150ijvu\">\n" +
                        "        <dc:Bounds x=\"362\" y=\"102\" width=\"36\" height=\"36\" />\n" +
                        "      </bpmndi:BPMNShape>\n" +
                        "      <bpmndi:BPMNShape id=\"Activity_0lzufan_di\" bpmnElement=\"Activity_1noetht\">\n" +
                        "        <dc:Bounds x=\"230\" y=\"80\" width=\"100\" height=\"80\" />\n" +
                        "      </bpmndi:BPMNShape>\n" +
                        "    </bpmndi:BPMNPlane>\n" +
                        "  </bpmndi:BPMNDiagram>\n" +
                        "</bpmn:definitions>\n").name("fff").tenantId("222222222222222").
                deploy();
        System.out.println(deploy.getId());
    }

    

    @Test
    public void test1() throws InterruptedException {
       try {
           runtimeService.startProcessInstanceByKey("Process_19q4oj1");

       }
       finally {

           TimeUnit.HOURS.sleep(1);
       }
    }
}
