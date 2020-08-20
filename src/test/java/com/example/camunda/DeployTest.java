package com.example.camunda;

import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.repository.Deployment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName : DeployTest
 * @Author : yangliu@tiduyun.com
 * @Date: 2020-08-20 17:20
 */
@SpringBootTest
public class DeployTest {

    @Autowired
    private RepositoryService repositoryService;


    @Autowired
    private RuntimeService runtimeService;

    @Test
    public void test()
    {
        Deployment deploy = repositoryService.createDeployment().addClasspathResource("processes/diagram_1.bpmn").name("test").
                deploy();
        System.out.println(deploy.getId());
    }


    @Test
    public void test1()
    {
        runtimeService.startProcessInstanceByKey("Process_1hi34yh");
    }
}
