package com.example.service;

import com.example.models.entity.Model;
import org.springframework.stereotype.Service;

@Service
public interface ModelService {
    void initializeModels();
    Model findById(Long id);
}
