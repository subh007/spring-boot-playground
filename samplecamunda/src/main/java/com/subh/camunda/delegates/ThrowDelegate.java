package com.subh.camunda.delegates;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.impl.persistence.entity.ExecutionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThrowDelegate implements JavaDelegate {

    @Autowired
    RuntimeService runtimeService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("sending message");

        runtimeService
                .createMessageCorrelation("WorkflowMessage")
                .processInstanceBusinessKey(((ExecutionEntity) delegateExecution).getProcessDefinition().getKey())
                .correlateWithResult();
        delegateExecution.setVariable("test", "test");
    }
}
