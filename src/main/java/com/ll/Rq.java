package com.ll;

import java.util.ArrayList;
import java.util.List;

public class Rq {
    String wt;
    String action;
    String queryString;

    List<String> paramNames;
    List<String> paramValues;


    Rq(String wt){
        paramNames = new ArrayList<>();
        paramValues = new ArrayList<>();
        this.wt =wt;

        String[] wtBits = wt.split("\\?",2);
        action = wtBits[0].trim();
        queryString = wtBits[1].trim();

        String[] queryStringBits = queryString.split("&");

        for(int i = 0; i< queryStringBits.length; i++){
            String queryParamStr = queryStringBits[i];
            String[] queryParamStrBits = queryParamStr.split("=", 2);

            String paramName = queryStringBits[0];
            String paramValue = queryStringBits[1];

            paramNames.add(paramName);
            paramValues.add(paramValue);
        }


    }

    String getAction() {
        return action;
    }

    public int getParamAsInt(String paramName, int defaultValue) {
        int index = paramNames.indexOf(paramName);

        if(index == -1) return defaultValue;

        String paramValue = paramValues.get(index);

        try{
            return Integer.parseInt(paramValue);
        }
        catch (NumberFormatException e){
            return defaultValue;
        }

    }
}
