package com.example.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Job testJob1() {
		return jobBuilderFactory
				.get("testJob")
				.incrementer(new RunIdIncrementer())
				.start(testStep1())
				.build();
	}

	@Bean
	public Step testStep1() {
		return stepBuilderFactory
				.get("step1")
				.<Syain, Syain>chunk(3)
				.reader(testRead())
				.processor(testProc())
				.writer(testWrite())
				.build();
	}

	@Bean
	public FlatFileItemReader<Syain> testRead() {
		return new FlatFileItemReaderBuilder<Syain>()
				.name("testCSV")
				.resource(new ClassPathResource("syain1.csv"))
				.delimited().names(new String[] { "id", "romaji" })
				.fieldSetMapper(new BeanWrapperFieldSetMapper<Syain>() {
					{
						setTargetType(Syain.class);
					}
				}).build();
	}

	@Bean
	public ProcProcess testProc() {
		return new ProcProcess();
	}

	@Bean
	public ProcWrite<Syain> testWrite() {
		return new ProcWrite<Syain>();
	}
}