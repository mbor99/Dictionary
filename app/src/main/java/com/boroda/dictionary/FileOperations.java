package com.boroda.dictionary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

import android.content.Context;
import android.util.Log;

public class FileOperations {
    public FileOperations() {
    }

    String[] RowData;
    String separator = ",";
    List<Word> csvDict = new LinkedList();

    final String LOG_TAG = "myLogs";

    final String FILENAME = "file";

    final String DIR_SD = "MyFiles";
    final String FILENAME_SD = "fileSD";
//    File file=new File();

    public static void save(String filename, Context ctx) {
        FileOutputStream fos;
        try {
            fos = ctx.openFileOutput(filename, Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject("Hello");
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    void writeFile(Context ctx) {
        try {
            // отрываем поток для записи
            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(ctx.openFileOutput(FILENAME, Context.MODE_PRIVATE)));
            // пишем данные
            bw.write("Содержимое файла");
            // закрываем поток
            bw.close();
            Log.d(LOG_TAG, "Файл записан");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    List<Word> readFile(final String name) {
        Context ctx = null;
        ctx.getApplicationContext();
        try {
            InputStreamReader isr = new InputStreamReader(ctx.openFileInput(name));
            BufferedReader reader = new BufferedReader(isr);
            String line;
            while ((line = reader.readLine()) != null) {
                RowData = line.split(separator);
                String eng = RowData[0];
                String rus = RowData[1];
                String counter = RowData[2];
                csvDict.add(new Word(eng, rus, counter));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return csvDict;
    }
}
//            String line;
//            while((line=reader.readLine())!=null)
//            {
//                RowData = line.split(separator);
//                String eng = RowData[0];
//                String rus = RowData[1];
//                String counter = RowData[2];
//                csvDict.add(new Word(eng, rus, counter));
//            }
//
//
//
//


