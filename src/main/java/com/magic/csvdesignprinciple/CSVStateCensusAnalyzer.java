package com.magic.csvdesignprinciple;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class CSVStateCensusAnalyzer {
    public int loadCensusDataFromCSVfile(String filePath) throws CustomExceptionsCsvFile {
        int count=0;
        try {
            BufferedReader reader = Files.newBufferedReader(Path.of(filePath));
            assert reader != null;
            CsvToBean<CSVStateCensus> CsvToBean = new CsvToBeanBuilder<CSVStateCensus>(reader)
                    .withType(CSVStateCensus.class).withIgnoreLeadingWhiteSpace(true).build();
            Iterator<CSVStateCensus> iterator = CsvToBean.iterator();
            Iterable<CSVStateCensus> iterable = () -> iterator;
            count = (int) StreamSupport.stream(iterable.spliterator(), false).count();
        }catch(NoSuchFileException e){
            throw new CustomExceptionsCsvFile(CustomExceptionsCsvFile.ExceptionType.Invalid_FilePath,"Enter a valid file path");
        }catch(IOException e){
            e.printStackTrace();
        }
        return count;
    }
}
