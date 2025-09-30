package com.lifemanagement.reflect.controller;

import com.lifemanagement.reflect.dto.TimeEntryDTO;
import com.lifemanagement.reflect.dto.TimeEntryResponseDTO;
import com.lifemanagement.reflect.service.TimeEntryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/time-entry")
public class TimeEntryController {
    private final TimeEntryService timeEntryService;

    @PostMapping
    public ResponseEntity<TimeEntryResponseDTO> createTimeEntry(@RequestBody TimeEntryDTO timeEntryDTO){
        try {

            TimeEntryResponseDTO timeEntryResponseDTO= timeEntryService.saveTimeEntry(timeEntryDTO);

            return new ResponseEntity<>(timeEntryResponseDTO,HttpStatus.CREATED);


        }
        catch (Exception e){

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


}
