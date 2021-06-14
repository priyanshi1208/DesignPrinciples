package com.magic.csvdesignprinciple;

import org.junit.Assert;
import org.junit.Test;

public class CSVStateCodeAnalyzerTest {
    @Test
    public void validating_if_stateCensus_records_matches_no_of_entries() throws CustomExceptionsCsvFile {
        CSVStateCodeAnalyzer csvStateCodeAnalyzer=new CSVStateCodeAnalyzer();
        int fromCSVfile = csvStateCodeAnalyzer.loadStateCodeCSVfile("C:\\Users\\ayuanshi\\Downloads\\StateCode.csv");
        Assert.assertEquals(37,fromCSVfile);
    }

    @Test
    public void validating_if_exception_arises_and_handles_if_no_such_file_exists()throws CustomExceptionsCsvFile {
        try {
            CSVStateCodeAnalyzer csvStateCodeAnalyzer = new CSVStateCodeAnalyzer();
            csvStateCodeAnalyzer.loadStateCodeCSVfile("C:\\Users\\ayuanshi\\Downloads\\StateCensusCode1.csv");
        }catch(CustomExceptionsCsvFile e){
            Assert.assertEquals(CustomExceptionsCsvFile.ExceptionType.Invalid_FilePath,e.exceptionType);
        }
    }
    @Test
    public void validating_if_exception_arises_and_handles_if_invalid_file_arrises()throws CustomExceptionsCsvFile {
        try {
            CSVStateCodeAnalyzer csvStateCodeAnalyzer = new CSVStateCodeAnalyzer();
            csvStateCodeAnalyzer.loadStateCodeCSVfile("C:\\Users\\ayuanshi\\Downloads\\StateCode.doc");
        }catch(CustomExceptionsCsvFile e){
            Assert.assertEquals(CustomExceptionsCsvFile.ExceptionType.Invalid_FileType,e.exceptionType);
        }
    }
    @Test
    public void validating_if_exception_arises_and_handles_if_file_has_different_delimeters()throws CustomExceptionsCsvFile {
        try {
            CSVStateCodeAnalyzer csvStateCodeAnalyzer = new CSVStateCodeAnalyzer();
            csvStateCodeAnalyzer.loadStateCodeCSVfile("C:\\Users\\ayuanshi\\Downloads\\StateCensusData1.xlsx");
        }catch(CustomExceptionsCsvFile e){
            Assert.assertEquals(CustomExceptionsCsvFile.ExceptionType.Invalid_Delimiter,e.exceptionType);
        }
    }
    @Test
    public void validating_if_exception_arises_and_handles_if_file_has_different_header()throws CustomExceptionsCsvFile {
        try {
            CSVStateCodeAnalyzer csvStateCodeAnalyzer = new CSVStateCodeAnalyzer();
            csvStateCodeAnalyzer.loadStateCodeCSVfile("C:\\Users\\ayuanshi\\Downloads\\StateCode.csv");
        }catch(CustomExceptionsCsvFile e){
            Assert.assertEquals(CustomExceptionsCsvFile.ExceptionType.Invalid_Header,e.exceptionType);
        }
    }

}