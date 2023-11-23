package repo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
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

    public void readFileCsv () throws FileNotFoundException, IOException{
        int x = 0;
        String line;
        StringBuilder str = new StringBuilder("");
        try(BufferedReader reader = new BufferedReader(new FileReader("repo/file.csv"))){
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
    }

    public void writeFile1Csv () throws IOException {

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("repo/file1.csv"))){
            writer.write(String.join(";", header));
            writer.write("\n"); 
            int i = 0;
            for(int z = 0;z < data.length;z++){
                for(i = 0;i < header.length;i++){
                    writer.write(Integer.toString(data[z][i]));
                    if(i != header.length - 1) writer.write(";");

                }
                if(z != data.length - 1)writer.write("\n");
            }
        }
    }

    public String [] getHeader(){
        return header;
    }

    public int [][] getData(){
        return data;
    }
}
