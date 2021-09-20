package com.example.demo;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class HelloFirst implements Tasklet {
	@Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) 
    		throws Exception {
        System.out.println("Hello World First");
        return RepeatStatus.FINISHED;
    }
}
