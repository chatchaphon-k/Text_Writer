package extensions;

import java.io.BufferedWriter;
import java.util.List;

public class Text_Writer
{
    enum OutputExt
    {
        txt,
        csv
    }

    protected BufferedWriter fileWriter;

    //Generate a new text file everytime you called
//    public void generate()
//    {        
//        fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path2output + ".txt")));
//        fileWriter.write("YOUR DATA TO WRITE IN TEXT FILE");
//        fileWriter.newLine();
//        fileWriter.close();
//    }

    //Generate 1 text file
//    public void generate()
//    {
        //new bufferdWriter outside the method
//        fileWriter.write("YOUR DATA TO WRITE IN TEXT FILE");
//        fileWriter.newLine();
        //close fileWriter outside the method
//    }

    protected String get_data_delimitByPipe(String[] arr, String delimiter)
    {
        String data2write = "";
        for(int i = 0; i < arr.length; i++)
            data2write += arr[i] + delimiter;
        return remove_last_delimiter(data2write);
    }

    protected String get_data_delimitByPipe(List<String> arr, String delimiter)
    {
        String data2write = "";
        for(int i = 0; i < arr.size(); i++)
            data2write += arr.get(i) + delimiter;
        return remove_last_delimiter(data2write);
    }

    private String remove_last_delimiter(String data)
    {
        return data.substring(0, data.length() - 1);
    }
}