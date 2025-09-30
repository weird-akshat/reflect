package com.lifemanagement.reflect.mapper;

import com.lifemanagement.reflect.dto.TimeEntryDTO;
import com.lifemanagement.reflect.dto.TimeEntryResponseDTO;
import com.lifemanagement.reflect.entity.Category;
import com.lifemanagement.reflect.entity.TimeEntry;
import com.lifemanagement.reflect.exception.MappingException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeEntryMapper {

    public static TimeEntryResponseDTO timeEntryToDTO(TimeEntry timeEntry){
        try {
            return new TimeEntryResponseDTO(timeEntry.getId(), timeEntry.getDescription(),timeEntry.getStartTime(),timeEntry.getEndTime(),timeEntry.getCategory().getId());
        }
        catch (Exception e){
            log.error("Error converting TimeEntry to TimeEntryResponseDTO: ",e);
            throw new MappingException("Error converting TimeEntry to TimeEntryResponseDTO",e);
        }



    }
    public static TimeEntry dtoToTimeEntry(TimeEntryDTO timeEntryDTO, Category category){
        try{
            return TimeEntry.builder().description(timeEntryDTO.description()).startTime(timeEntryDTO.startTime()).endTime(timeEntryDTO.endTime()).category(category).build();

        }
        catch (Exception e){
            log.error("Error converting TimeEntryDTO to TimeEntry ");
            throw new MappingException("Error converting TimeEntryDTO to TimeEntry",e);
        }

    }
    public static TimeEntry dtoToTimeEntry(Long id, TimeEntryDTO timeEntryDTO, Category category) {
        try{
            return TimeEntry.builder().id(id).description(timeEntryDTO.description()).startTime(timeEntryDTO.startTime()).endTime(timeEntryDTO.endTime()).category(category).build();
        }
        catch (Exception e){
            log.error("Error updating TimeEntryDTO to TimeEntry ");
            throw new MappingException("Error converting TimeEntryDTO to TimeEntry",e);
        }

    }
}
