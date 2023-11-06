package com.ll;

public class Rq {
    String wt;
    String action;
    String queryString;

    Rq(String wt){
        this.wt =wt;

        String[] wtBits = wt.split("\\?",2);
        action = wtBits[0].trim();
        queryString = wtBits[1].trim();


    }
}
