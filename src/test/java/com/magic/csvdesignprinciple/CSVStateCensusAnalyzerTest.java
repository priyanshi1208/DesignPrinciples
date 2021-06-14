package com.magic.csvdesignprinciple;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class CSVStateCensusAnalyzerTest {
    @Test
    public void validating_if_stateCensus_records_matches_no_of_entries() throws CustomExceptionsCsvFile {
        CSVStateCensusAnalyzer csvStateCensusAnalyzer=new CSVStateCensusAnalyzer();
        int fromCSVfile = csvStateCensusAnalyzer.loadCensusDataFromCSVfile("C:\\Users\\ayuanshi\\Downloads\\StateCensusData.csv");
        Assert.assertEquals(29,fromCSVfile);
    }

    @Test
    public void validating_if_exception_arises_and_handles_if_no_such_file_exists()throws CustomExceptionsCsvFile {
       try {
           CSVStateCensusAnalyzer csvStateCensusAnalyzer = new CSVStateCensusAnalyzer();
           csvStateCensusAnalyzer.loadCensusDataFromCSVfile("C:\\Users\\ayuanshi\\Downloads\\StateCensusData1.csv");
       }catch(CustomExceptionsCsvFile e){
        Assert.assertEquals(CustomExceptionsCsvFile.ExceptionType.Invalid_FilePath,e.exceptionType);
       }
    }
    @Test
    public void validating_if_exception_arises_and_handles_if_invalid_file_arrises()throws CustomExceptionsCsvFile {
        try {
            CSVStateCensusAnalyzer csvStateCensusAnalyzer = new CSVStateCensusAnalyzer();
            csvStateCensusAnalyzer.loadCensusDataFromCSVfile("C:\\Users\\ayuanshi\\Downloads\\StateCensusData.doc");
        }catch(CustomExceptionsCsvFile e){
            Assert.assertEquals(CustomExceptionsCsvFile.ExceptionType.Invalid_FileType,e.exceptionType);
        }
    }
    @Test
    public void validating_if_exception_arises_and_handles_if_file_has_different_delimeters()throws CustomExceptionsCsvFile {
        try {
            CSVStateCensusAnalyzer csvStateCensusAnalyzer = new CSVStateCensusAnalyzer();
            csvStateCensusAnalyzer.loadCensusDataFromCSVfile("C:\\Users\\ayuanshi\\Downloads\\StateCensusData1.xlsx");
        }catch(CustomExceptionsCsvFile e){
            Assert.assertEquals(CustomExceptionsCsvFile.ExceptionType.Invalid_Delimiter,e.exceptionType);
        }
    }
}