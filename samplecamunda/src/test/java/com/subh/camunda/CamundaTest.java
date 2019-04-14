package com.subh.camunda;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.history.HistoricProcessInstance;
import org.camunda.bpm.engine.impl.cfg.StandaloneInMemProcessEngineConfiguration;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CamundaTest {

    @Rule
    public ProcessEngineRule processEngineRule = new ProcessEngineRule(
            new StandaloneInMemProcessEngineConfiguration().buildProcessEngine());


    @Test
    @Deployment(resources = "loanApproval.bpmn")
    public void testHappyPath() {
        ProcessEngine processEngine = processEngineRule.getProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("loanApproval");

        HistoricProcessInstance historicProcessInstance = processEngineRule.getHistoryService()
                .createHistoricProcessInstanceQuery()
                .processInstanceId(processInstance.getId())
                .singleResult();

        assertNotNull(historicProcessInstance.getEndTime());
    }
}
