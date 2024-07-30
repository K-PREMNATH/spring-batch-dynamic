package com.spring.batch.config;

import com.spring.batch.dto.WageDetailMapping;
import com.spring.batch.entity.DistinctReqId;
import com.spring.batch.processor.WageRequestProcessor;
import com.spring.batch.writer.WageRequestWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

    @Bean
    public ItemReader<DistinctReqId> reader(EntityManagerFactory entityManagerFactory) {
        return new JpaPagingItemReaderBuilder<DistinctReqId>()
                .name("distinctReqIdReader")
                .entityManagerFactory(entityManagerFactory)
                .queryString("SELECT DISTINCT new DistinctReqId(w.requestId) FROM WageReqEntity w")
                .build();
    }

    @Bean
    public Job importUserJob(JobBuilderFactory jobBuilderFactory, Step step1) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(StepBuilderFactory stepBuilderFactory, ItemReader<DistinctReqId> reader,
                      @Autowired WageRequestProcessor processor, @Autowired WageRequestWriter writer) {
        return stepBuilderFactory.get("step1")
                .<DistinctReqId, WageDetailMapping>chunk(10)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}