package com.magic.csvdesignprinciple;

import com.opencsv.bean.CsvBindByName;

public class CSVStateCensus {
    @CsvBindByName(column = "State", required = true)
    public String state;
    @CsvBindByName(column = "Population", required = true)
    private Long population;
    @CsvBindByName(column = "AreaInSqKm", required = true)
    private Long areaInSqKm;
    @CsvBindByName(column = "DensityPerSqKm", required = true)
    private Long densityPerSqKm;

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
