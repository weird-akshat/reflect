package com.lifemanagement.reflect.service;

import com.lifemanagement.reflect.dto.TimeEntryDTO;
import com.lifemanagement.reflect.dto.TimeEntryResponseDTO;
import com.lifemanagement.reflect.entity.TimeEntry;
import com.lifemanagement.reflect.mapper.TimeEntryMapper;
import com.lifemanagement.reflect.repository.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepo categoryRepo;




}
