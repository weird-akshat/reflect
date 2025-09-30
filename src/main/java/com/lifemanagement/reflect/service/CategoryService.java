package com.lifemanagement.reflect.service;

import com.lifemanagement.reflect.repository.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepo categoryRepo;



}
