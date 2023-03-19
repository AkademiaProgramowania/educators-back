package com.akademia.educators_back.config;

import com.akademia.educators_back.entity.ProblemEntity;
import com.akademia.educators_back.repository.ProblemRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private ProblemRepository problemRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ProblemEntity problemEntity = new ProblemEntity();
        problemEntity.setTitle("Primitive types");
        problemEntity.setQuestion("How many primitive types in java do you know?");
        problemRepository.save(problemEntity);
    }
}
