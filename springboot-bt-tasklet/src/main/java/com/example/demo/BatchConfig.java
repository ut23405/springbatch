package com.example.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class BatchConfig {
	@Autowired private HelloFirst HelloFirst;
	@Autowired private HelloSecond HelloSecond;
	@Autowired private JobBuilderFactory jobBuilderFactory;
	@Autowired private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job testJob1(Step testStep1,Step testStep2) {
        return jobBuilderFactory.get("testJob")
        		.incrementer(new RunIdIncrementer())
				.start(testStep1)
				.next(testStep2)
                .build();
    }

    @Bean
    public Step testStep1() {
        return stepBuilderFactory.get("TestStep11")
                .tasklet(HelloFirst)
                .build();
    }
    @Bean
    public Step testStep2() {
        return stepBuilderFactory.get("TestStep21")
                .tasklet(HelloSecond)
                .build();
    }
}
