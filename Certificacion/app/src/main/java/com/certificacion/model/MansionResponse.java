package com.certificacion.model;

import java.util.ArrayList;

public class MansionResponse {
    private Integer count;
    private String next,previus;
    private ArrayList<Mansion> result;

    public MansionResponse(Integer count, String next, String previus, ArrayList<Mansion> result) {
        this.count = count;
        this.next = next;
        this.previus = previus;
        this.result = result;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevius() {
        return previus;
    }

    public void setPrevius(String previus) {
        this.previus = previus;
    }

    public ArrayList<Mansion> getResult() {
        return result;
    }

    public void setResult(ArrayList<Mansion> result) {
        this.result = result;
    }
}
