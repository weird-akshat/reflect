package com.lifemanagement.reflect.service;


import com.lifemanagement.reflect.dto.TimeEntryDTO;
import com.lifemanagement.reflect.dto.TimeEntryResponseDTO;
import com.lifemanagement.reflect.entity.AppUser;
import com.lifemanagement.reflect.entity.Category;
import com.lifemanagement.reflect.entity.TimeEntry;
import com.lifemanagement.reflect.mapper.TimeEntryMapper;
import com.lifemanagement.reflect.repository.AppUserRepo;
import com.lifemanagement.reflect.repository.CategoryRepo;
import com.lifemanagement.reflect.repository.TimeEntryRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class TimeEntryService {
    private final TimeEntryRepo timeEntryRepo;
    private final CategoryRepo categoryRepo;

    private final AppUserRepo appUserRepo;
    public TimeEntryResponseDTO saveTimeEntry(TimeEntryDTO timeEntryDTO){
        try {
            Optional<Category> category= categoryRepo.findById(timeEntryDTO.categoryId());
            if (category.isEmpty()){
                throw new RuntimeException("Category not found.");
            }
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            Object userDetails= authentication.getPrincipal();
            if (userDetails instanceof UserDetails){
                Optional<AppUser> user = appUserRepo.findByEmail(((UserDetails) userDetails).getUsername());
                if (user.isEmpty()){
                    throw new RuntimeException("User not found");

                }
                else{
                    TimeEntry timeEntry = TimeEntryMapper.dtoToTimeEntry(timeEntryDTO,category.get(),user.get());
                    timeEntryRepo.save(timeEntry);
                    return TimeEntryMapper.timeEntryToDTO(timeEntry);

                }


            }
            else{
                throw new RuntimeException("user details wrong");
            }



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
    public List<TimeEntry> getListEntries(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object userDetails = authentication.getPrincipal();


        if (userDetails instanceof UserDetails){
            String email= ((UserDetails) userDetails).getUsername();
            System.out.println(email);
            Optional<AppUser> user =appUserRepo.findByEmail(email);
            if (user.isEmpty()){
                throw new RuntimeException("Email not in database idk how.");
            }

            System.out.println(user.get().getId());
            return timeEntryRepo.findByUserId(user.get().getId());




        }
        else{
            throw new RuntimeException("Get List Entry");
        }





    }

}
