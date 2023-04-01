package org.example;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ClientLog implements Serializable{
    static final long serialVersionUID = 1L;
    private List<String[]> list = new ArrayList<>();

    public void log(int productNum, int amount){
        String[] str = new String[2];
        str[0] = Integer.toString(productNum);
        str[1] = Integer.toString(amount);
        list.add(str);
    }
    public void exportAsCSV(File txtFile){

        try (CSVWriter writer = new CSVWriter(new FileWriter(txtFile))) {

            writer.writeNext(new String[]{"productNum,amount"});

            for (String[] str : list) {

                writer.writeNext(str, true);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
