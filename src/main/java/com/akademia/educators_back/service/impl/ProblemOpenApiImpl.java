package com.akademia.educators_back.service.impl;

import com.akademia.educators_back.mapper.ProblemMapper;
import com.akademia.educators_back.repository.CategoryRepository;
import com.akademia.educators_back.repository.ProblemRepository;
import com.akademia.educators_back.validator.ProblemValidator;
import com.openapi.gen.springboot.api.ProblemsApiDelegate;
import com.openapi.gen.springboot.to.ProblemOpenApiTo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.NativeWebRequest;

import java.time.OffsetDateTime;
import java.util.Optional;

@Service
public class ProblemOpenApiImpl implements ProblemsApiDelegate {

    private ProblemRepository problemRepository;
    private ProblemMapper problemMapper;
    private ProblemValidator problemValidator;
    private CategoryRepository categoryRepository;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return ProblemsApiDelegate.super.getRequest();
    }

    @Override
    public ResponseEntity<ProblemOpenApiTo> getProblemById(String id) {
        return ProblemsApiDelegate.super.getProblemById(id);
    }

    @Override
    public ResponseEntity<OffsetDateTime> saveProblem(String id, ProblemOpenApiTo problemOpenApiTo) {
        return ProblemsApiDelegate.super.saveProblem(id, problemOpenApiTo);
    }
}
