package com.GameDev.TaskManager.service.CSVJuegos;

import com.GameDev.TaskManager.model.Csv.JuegoCsvRecord;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
@Service
public class csvJuegosService implements IJuegosCsvService {

      @Override
    public List<JuegoCsvRecord> convertirCSV(File file) throws FileNotFoundException {
        List<JuegoCsvRecord> juegoCsvRecordList =
                new CsvToBeanBuilder<JuegoCsvRecord>(new FileReader(file))
                        .withType(JuegoCsvRecord.class)
                        .build()
                        .parse();

        return juegoCsvRecordList;
    }

}
