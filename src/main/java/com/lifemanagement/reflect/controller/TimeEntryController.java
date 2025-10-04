package com.lifemanagement.reflect.controller;

import com.lifemanagement.reflect.dto.TimeEntryDTO;
import com.lifemanagement.reflect.dto.TimeEntryResponseDTO;
import com.lifemanagement.reflect.entity.TimeEntry;
import com.lifemanagement.reflect.service.TimeEntryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/time-entry")
public class TimeEntryController {
    private final TimeEntryService timeEntryService;

    @PostMapping
    public ResponseEntity<TimeEntryResponseDTO> createTimeEntry(@RequestBody TimeEntryDTO timeEntryDTO){
        System.out.println("Issue in timeentryrespons");

        try {



            TimeEntryResponseDTO timeEntryResponseDTO= timeEntryService.saveTimeEntry(timeEntryDTO);
            System.out.println("no issue in timeentryresponse");
            return new ResponseEntity<>(timeEntryResponseDTO,HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<TimeEntryResponseDTO> updateTimeEntry(@PathVariable long id, @RequestBody TimeEntryDTO timeEntryDTO){
        try {

            TimeEntryResponseDTO timeEntryResponseDTO= timeEntryService.saveTimeEntry(id,timeEntryDTO);
            System.out.print("noo");

            return new ResponseEntity<>(timeEntryResponseDTO,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping
    public ResponseEntity<List<TimeEntry>> getTimeEntries(){

        return new ResponseEntity<>(timeEntryService.getListEntries(),HttpStatus.OK);

    }
}
