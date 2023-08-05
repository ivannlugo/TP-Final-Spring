package com.GameDev.TaskManager.bootstrap;

import com.GameDev.TaskManager.repository.juego.JuegoRepository;
import com.GameDev.TaskManager.service.CSVJuegos.IJuegosCsvService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class bootstrapData implements CommandLineRunner{

    private final JuegoRepository juegoRepository;
    private final IJuegosCsvService juegosCsvService;
    @Override
    public void run(String... args) throws Exception {
        log.info("corriendo Bootstrap");
        //cargarJuegoData();
    }

   /* private void cargarJuegoData() throws FileNotFoundException {

        if (juegoRepository.count() <35){
       File file = ResourceUtils.getFile("classpath:csvdata/datosjuegos.csv");
    List<JuegoCsvRecord> juegoCsvRecordList = juegosCsvService.convertirCSV(file);

    if(!juegoCsvRecordList.isEmpty()){
        for (JuegoCsvRecord juegoCsvRecord:juegoCsvRecordList){
            juegoRepository.save(
                    Juego.builder()
                            .uuidJuego(UUID.randomUUID())
                            .titulo(juegoCsvRecord.getTitulo())
                            .descripcion(juegoCsvRecord.getDescripcion())
                            .desarrolladores(juegoCsvRecord.getDesarrolladores())
                           // .tareas(juegoCsvRecord.getTarea())
                            .build()
            );
        }
    }
        }


    }
*/
}
