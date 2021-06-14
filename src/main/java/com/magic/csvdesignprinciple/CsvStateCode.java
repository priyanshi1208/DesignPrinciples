package com.magic.csvdesignprinciple;

import com.opencsv.bean.CsvBindByName;

public class CsvStateCode {
    @CsvBindByName(column = "State", required = true)
    public String state;
    @CsvBindByName(column = "StateCode", required = true)
    public String stateCode;

    @Override
    public String toString() {
        return "CsvStateCode{" +
                "state='" + state + '\'' +
                ", stateCode='" + stateCode + '\'' +
                '}';
    }
}
