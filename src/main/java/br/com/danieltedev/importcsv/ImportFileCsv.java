package br.com.danieltedev.importcsv;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * ImportFileCsv
 */
@Component
public class ImportFileCsv {

    private static Logger log = LoggerFactory.getLogger(ImportFileCsv.class);

    @Autowired
    private PessoaRepository pessoaRepository;

    @Scheduled(fixedRate = 6000)
    public void sheduleTask() {
        try {
            log.info("iniciando processo de importação!");
            Path path = new File("/home/daniel/Documentos/files_csv/arquivo.csv").toPath();
            BufferedReader reader = Files.newBufferedReader(path);
            Iterable <CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(reader);
            List<Pessoa> listaPessoas = new ArrayList<>();
            records.forEach(r -> {
                listaPessoas.add(
                    new Pessoa(
                        Long.valueOf(r.get("id")),
                        r.get("nome"),
                        Long.valueOf(r.get("telefone")),
                        r.get("contato"),
                        r.get("texto")));
            });
            pessoaRepository.deleteAll();
            pessoaRepository.saveAll(listaPessoas);
            System.out.println(pessoaRepository.count());
            log.info("importação consluida com sucesso!");
        } catch (IOException e) {
            log.error("Erro no processo de importação!");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}