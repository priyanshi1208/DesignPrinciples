package com.magic.csvdesignprinciple;

import com.opencsv.bean.CsvBindByName;

public class CSVStateCensus {
    @CsvBindByName(column = "State", required = true)
    public String state;
    @CsvBindByName( column = "Population", required = true)
    private String population;
    @CsvBindByName(column = "AreaInSqKm", required = true)
    private String areaInSqKm;
    @CsvBindByName(column = "DensityPerSqKm", required = true)
    private String densityPerSqKm;

    @Override
    public String toString() {
        return "CSVStateCensus{" +
                "state='" + state + '\'' +
                ", population=" + population +
                ", AreaInSquareKm=" + areaInSqKm +
                ", DensityPerSquareKm=" + densityPerSqKm +
                '}';
    }
}
