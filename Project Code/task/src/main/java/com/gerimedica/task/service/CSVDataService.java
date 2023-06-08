package com.gerimedica.task.service;
import com.gerimedica.task.model.CSVData;
import com.gerimedica.task.repository.CSVDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public  class CSVDataService {
    final
    CSVDataRepository csvDataRepository;

    public CSVDataService(CSVDataRepository csvDataRepository) {
        this.csvDataRepository = csvDataRepository;
    }
    public void uploadData(List<CSVData> dataList)
    {
        csvDataRepository.saveAll(dataList);
    }
    public List<CSVData> getAllData()
    {
        return csvDataRepository.findAll();
    }

    public CSVData findByCode(String code)
    {
        CSVData sampleCSVData=new CSVData();
        sampleCSVData.setCode(code);
      return  csvDataRepository.findOne(Example.of(sampleCSVData)).get();
    }
    public void deleteAllData()
    {
        csvDataRepository.deleteAll();
    }

}