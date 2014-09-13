package com.boroda.dictionary;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Dictionary {
    Random index = new Random();
    String[] RowData;
    String separator = ",";
    List<Word> csvDict=new LinkedList<Word>();

    public Dictionary() {
    }

    public int getRandomIndexFromDict(int size) {
        if (size > 0) {
            return index.nextInt(size);
        }
        return 0;
    }

    public String getNewEngWordFromDict(List<Word> dict, int index) {
        return dict.get(index).getEng();
    }

    public String getTranslationFromDict(List<Word> dict, int index) {
        return dict.get(index).getRus();
    }

    public void increaseSuccessfulCounter(int index) {
        csvDict.get(index).setSuccess(csvDict.get(index).getSuccess() + 1);
    }

    public List<Word> initCsvDict() throws IOException {
        FileOperations fileOperations = new FileOperations();
        csvDict = fileOperations.readFile("dictionary.csv");
        return csvDict;
    }

//    public List<Word> readСsv(Resources res) {
//        try {
//            InputStream inputStream = res.openRawResource(R.raw.dictionary);
//            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//            try {
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    RowData = line.split(separator);
//                    String eng = RowData[0];
//                    String rus = RowData[1];
//                    String counter = RowData[2];
//                    csvDict.add(new Word(eng, rus, counter));
//                }
//            } catch (Exception e) {
//            }
//            inputStream.close();
//        } catch (Exception e) {
//            // e.printStackTrace();
//        }
//        return csvDict;
//    }
}
