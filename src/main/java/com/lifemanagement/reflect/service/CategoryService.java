package com.lifemanagement.reflect.service;

import com.lifemanagement.reflect.dto.CategoryDTO;
import com.lifemanagement.reflect.dto.CategoryResponseDTO;

import com.lifemanagement.reflect.entity.AppUser;
import com.lifemanagement.reflect.entity.Category;
import com.lifemanagement.reflect.entity.TimeEntry;
import com.lifemanagement.reflect.mapper.CategoryMapper;
import com.lifemanagement.reflect.repository.AppUserRepo;
import com.lifemanagement.reflect.repository.CategoryRepo;
import com.lifemanagement.reflect.repository.TimeEntryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class CategoryService {
    private final TimeEntryRepo timeEntryRepo;
    private final CategoryRepo categoryRepo;
    private final AppUserRepo appUserRepo;

    public CategoryResponseDTO saveCategory(CategoryDTO categoryDTO){
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Object userDetails= authentication.getPrincipal();

            if (!(userDetails instanceof UserDetails)){
                throw new RuntimeException("User Auth Error");
            }
            String email= ((UserDetails) userDetails).getUsername();

            AppUser user = appUserRepo.findByEmail(email).orElseThrow(()->new RuntimeException("User not found"));



            Category category = CategoryMapper.categoryDTOtoCategory(categoryDTO,user);

            categoryRepo.save(category);

            return CategoryMapper.categoryToResponseDTO(category);
        }
        catch (Exception e){
            throw new RuntimeException("Exception in saving category ",e);
        }
    }
    public CategoryResponseDTO saveCategory(Long id, CategoryDTO categoryDTO){
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Object userDetails= authentication.getPrincipal();
            if (!(userDetails instanceof UserDetails)){
                throw new RuntimeException("User Details error");
            }
            Category category = categoryRepo.findById(id).orElseThrow(()->new RuntimeException("Category not found"));

            if(!category.getUser().getEmail().equals(((UserDetails) userDetails).getUsername())){
                throw new RuntimeException("Trying to get someone else's category, you naughty naughty");
            }
            category.setColor(categoryDTO.color());
            category.setName(categoryDTO.name());
            category.setDescription(categoryDTO.description());

            categoryRepo.save(category);

            return CategoryMapper.categoryToResponseDTO(category);
        }
        catch (Exception e){
            throw new RuntimeException("Exception in saving category ",e);
        }
    }

    public void deleteCategory(Long id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Object userDetails= authentication.getPrincipal();
        if (!(userDetails instanceof UserDetails)){
            throw  new RuntimeException("User fucking issue");
        }
        String email= ((UserDetails) userDetails).getUsername();
        Category category = categoryRepo.findById(id).orElseThrow(()->new RuntimeException("category not found"));

        if (!category.getUser().getEmail().equals(email)){
            throw new RuntimeException("You naughty naughty, trying to access what is not yours");
        }


        List<TimeEntry> timeEntries= timeEntryRepo.findByCategory(category);

        for (TimeEntry timeEntry: timeEntries){
            timeEntry.setCategory(null);

            timeEntryRepo.save(timeEntry);
        }
        categoryRepo.delete(category);

    }

    public CategoryResponseDTO getCategory(Long id){
        return CategoryMapper.categoryToResponseDTO( categoryRepo.findById(id).orElseThrow(()->new RuntimeException("Category not found")));

    }

    public List<CategoryResponseDTO> getCategoryList(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Object userDetails= authentication.getPrincipal();

        if (!(userDetails instanceof  UserDetails)){
            throw new RuntimeException("THE FUCKING FUUUKK");
        }

        String email = ((UserDetails) userDetails).getUsername();


        List<Category> categories= categoryRepo.findByUser(appUserRepo.findByEmail(email).orElseThrow(()->new RuntimeException("User not found")));

        List<CategoryResponseDTO> categoriesDTOs = new ArrayList<>();
        for (Category category: categories){
            categoriesDTOs.add(CategoryMapper.categoryToResponseDTO(category));
        }
        return categoriesDTOs;

    }


}
