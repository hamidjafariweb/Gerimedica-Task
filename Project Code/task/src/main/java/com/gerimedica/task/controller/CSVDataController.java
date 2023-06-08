package com.gerimedica.task.controller;

import com.gerimedica.task.model.CSVData;
import com.gerimedica.task.service.CSVDataService;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/CSVData")
public class CSVDataController {
    final
    CSVDataService csvDataService;

    public CSVDataController(CSVDataService csvDataService) {
        this.csvDataService = csvDataService;
    }

    @PostMapping("/uploadData")
    public String  uploadData(@RequestParam("file") MultipartFile file)
    {
        String message;
        List<CSVData> dataList=new ArrayList<>();
        if (file.isEmpty()) {
            message="Please select a CSV file to upload and Try Again!";

        } else {


            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {


                CsvToBean<CSVData> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(CSVData.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();


                 dataList = csvToBean.parse();
                csvDataService.uploadData(dataList);
                message ="Your CSV File Uploaded";


            } catch (Exception ex) {
                message= "An error occurred while processing the CSV file.";
                   }
        }


        return message;
    }

    @GetMapping("/fetchAllData")
    public List<CSVData> fetchAllData()
    {
        return  csvDataService.getAllData();
    }
    @GetMapping("/fetchByCode/{Code}")
    public CSVData fetchByCode(@PathVariable String code)
    {
        return  csvDataService.findByCode(code);
    }
    @DeleteMapping("deleteAllData")
    public String deleteAllData()
    {
        String message;
        csvDataService.deleteAllData();
        message="All Data Deleted";
        return  message;
    }



}
