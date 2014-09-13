package com.boroda.dictionary;

public class Word {
    public Word(String eng, String rus, String counter) {
        this.eng = eng;
        this.rus = rus;
        this.success= Integer.parseInt(counter);

    }

    public String getEng() {
        return eng;
    }

    public String getRus() {
        return rus;
    }

    public int getSuccess() {
        return success;
    }

    String eng;

    public void setSuccess(int success) {
        this.success = success;
    }

    String rus;
    int success;


}
