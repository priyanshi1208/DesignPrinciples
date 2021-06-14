package com.magic.csvdesignprinciple;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class CSVStateCensusAnalyzer {
    public int loadCensusDataFromCSVfile(String filePath) {
        BufferedReader reader = null;
        try {
            reader = Files.newBufferedReader(Path.of(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert reader != null;
        CsvToBean<CSVStateCensus> CsvToBean = new CsvToBeanBuilder<CSVStateCensus>(reader)
                .withType(CSVStateCensus.class).withIgnoreLeadingWhiteSpace(true).build();
        Iterator<CSVStateCensus> iterator=CsvToBean.iterator();
        Iterable<CSVStateCensus> iterable=()->iterator;
        return (int) StreamSupport.stream(iterable.spliterator(), false).count();
    }
}
