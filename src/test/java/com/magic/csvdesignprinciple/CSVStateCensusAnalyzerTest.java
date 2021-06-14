package com.magic.csvdesignprinciple;
import org.junit.Assert;
import org.junit.Test;
public class CSVStateCensusAnalyzerTest {
    @Test
    public void validating_if_stateCensus_records_matches_no_of_entries() {
        CSVStateCensusAnalyzer csvStateCensusAnalyzer=new CSVStateCensusAnalyzer();
        int fromCSVfile = csvStateCensusAnalyzer.loadCensusDataFromCSVfile("C:\\Users\\ayuanshi\\Downloads\\StateCensusData.csv");
        Assert.assertEquals(29,fromCSVfile);
    }
}