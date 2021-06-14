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
    public int loadCensusDataFromCSVfile(String filePath) throws CustomExceptionsCsvFile {
        int count;
        try {
            BufferedReader reader = Files.newBufferedReader(Path.of(filePath));
            CsvToBean<CSVStateCensus> CsvToBean = new CsvToBeanBuilder<CSVStateCensus>(reader)
                    .withType(CSVStateCensus.class).withIgnoreLeadingWhiteSpace(true).build();
            Iterator<CSVStateCensus> iterator = CsvToBean.iterator();
            Iterable<CSVStateCensus> iterable = () -> iterator;
            count = (int) StreamSupport.stream(iterable.spliterator(), false).count();
        } catch(IOException e){
            if(!filePath.contains(".csv"))
                throw new CustomExceptionsCsvFile(CustomExceptionsCsvFile
                        .ExceptionType.Invalid_FileType,"Invalid file extension");
            throw new CustomExceptionsCsvFile(CustomExceptionsCsvFile
                    .ExceptionType.Invalid_FilePath,"Invalid file path entered");
        }catch(RuntimeException e){
            throw new CustomExceptionsCsvFile(CustomExceptionsCsvFile
                    .ExceptionType.Invalid_Delimiter,"File does not contains specified delimiter");
        }
        return count;
    }
}
