package com.lifemanagement.reflect.service;


import com.lifemanagement.reflect.dto.TimeEntryDTO;
import com.lifemanagement.reflect.dto.TimeEntryResponseDTO;
import com.lifemanagement.reflect.entity.Category;
import com.lifemanagement.reflect.entity.TimeEntry;
import com.lifemanagement.reflect.mapper.TimeEntryMapper;
import com.lifemanagement.reflect.repository.CategoryRepo;
import com.lifemanagement.reflect.repository.TimeEntryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TimeEntryService {
    private final TimeEntryRepo timeEntryRepo;
    private final CategoryRepo categoryRepo;
    public TimeEntryResponseDTO saveTimeEntry(TimeEntryDTO timeEntryDTO){
        try {
            Optional<Category> category= categoryRepo.findById(timeEntryDTO.categoryId());
            if (category.isEmpty()){
                throw new RuntimeException("Category not found.");
            }

            TimeEntry timeEntry = TimeEntryMapper.dtoToTimeEntry(timeEntryDTO,category.get());
            timeEntryRepo.save(timeEntry);
            return TimeEntryMapper.timeEntryToDTO(timeEntry);

        }
        catch (Exception e){
            throw new RuntimeException("Exception in saving time entry");
        }
    }
    public TimeEntryResponseDTO saveTimeEntry(long id,TimeEntryDTO timeEntryDTO){
        try {
            Optional<Category> category= categoryRepo.findById(timeEntryDTO.categoryId());
            if (category.isEmpty()){
                throw new RuntimeException("Category not found.");
            }

            TimeEntry timeEntry = TimeEntryMapper.dtoToTimeEntry(id,timeEntryDTO,category.get());
            timeEntryRepo.save(timeEntry);
            return TimeEntryMapper.timeEntryToDTO(timeEntry);

        }
        catch (Exception e){
            throw new RuntimeException("Exception in saving time entry");
        }
    }

}
