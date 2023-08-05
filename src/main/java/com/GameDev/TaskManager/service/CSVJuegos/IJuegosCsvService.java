package com.GameDev.TaskManager.service.CSVJuegos;

import com.GameDev.TaskManager.model.Csv.JuegoCsvRecord;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;


public interface IJuegosCsvService {

    List<JuegoCsvRecord> convertirCSV(File file) throws FileNotFoundException;

}
