package repo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AppData {

    private String[] header;
    private int[][]  data;

    public AppData(){}

    public AppData(String [] header, int [][] data){
        this.header = header;
        this.data = data;
    }

    public void readFileCsv (File filename) throws IOException{
        int x = 0;
        String line;
        StringBuilder str = new StringBuilder("");
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while((line = reader.readLine()) != null) {
                if(x == 0) header = line.split(";");
                else str.append(line + ";"); 
                x++;
            }
        }
        String[] str2 = str.toString().split(";");
        int q = 0;
        data = new int[x - 1][header.length];
        for (int z = 0;z < x - 1;z++){
            int i = 0;
            for(i = 0;i < header.length;i++){
                data[z][i] = Integer.parseInt(str2[q]);
                q++;
            }
        }
        System.out.println("Выполнена загрузка данных из csv файла!");
    }

    public void writeFile1Csv (File filename) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(String.join(";", header));
            writer.write("\n"); 
            int i = 0;
            try {
                for(int z = 0;z < data.length;z++){
                    for(i = 0;i < data[0].length;i++){
                        writer.write(Integer.toString(data[z][i]));
                        if(i != header.length - 1) writer.write(";");
                    }
                if(z != data.length - 1)writer.write("\n");
                }
                System.out.println("Выполнено сохранение данных в csv файл!");
            } catch (ArrayIndexOutOfBoundsException a){
                System.out.println("Ошибка вводных данных!");
            }
        }
        
    }

    public String [] getHeader(){
        return header;
    }

    public void setHeader(String [] header){
        this.header = header;
    }

    public int [][] getData(){
        return data;
    }

    public void setData(int [][] data){
        this.data = data;
    }
}
