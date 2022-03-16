package extensions;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class Writer_Text
{
    enum OutputExt
    {
        txt,
        csv
    }

    protected BufferedWriter fileWriter;

    // <editor-fold defaultstate="collapsed" desc="Initialization">

    public Writer_Text(){}

    public Writer_Text(String path2output, String ext) throws FileNotFoundException
    {
        init(path2output, ext);
    }

    protected void init(String path2output, String ext) throws FileNotFoundException
    {
        if(ext.isEmpty())
            ext = "." + OutputExt.txt.name();
        else if(!ext.startsWith("."))
            ext = "." + ext;
        fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path2output + "." + ext)));
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Write Data">

    protected void write_data(String data) throws IOException
    {
        fileWriter.write(data);
    }

    protected void write_data_and_newLine(String data) throws IOException
    {
        write_data(data);
        fileWriter.newLine();
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getter">

    protected String get_data_delimitByPipe(String[] arr, String delimiter)
    {
        String data2write = "";
        for(int i = 0; i < arr.length; i++)
            data2write += arr[i] + delimiter;
        return get_removed_last_delimiter(data2write);
    }

    protected String get_data_delimitByPipe(List<String> arr, String delimiter)
    {
        String data2write = "";
        for(int i = 0; i < arr.size(); i++)
            data2write += arr.get(i) + delimiter;
        return get_removed_last_delimiter(data2write);
    }

    private String get_removed_last_delimiter(String data)
    {
        return data.substring(0, data.length() - 1);
    }

    // </editor-fold>

    protected void close(String closed_msg, int total_tab) throws IOException
    {
        if(closed_msg.isEmpty())
            closed_msg = "- Generate text file successful";

        String tab = "";
        for(int i = 0; i < total_tab; i++)
             tab += "\t";

        fileWriter.close();
        System.out.println(tab + closed_msg);
    }

    // <editor-fold defaultstate="collapsed" desc="Example codes">

//    Generate a new text file everytime you called
//    public void generate()
//    {        
//        fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path2output + ".txt")));
//        ****************************************************
//        fileWriter.write("YOUR DATA TO WRITE IN TEXT FILE");
//        fileWriter.newLine();
//        ****************************************************
//        fileWriter.close();
//    }

//    Generate 1 text file
//    public void generate()
//    {
        //new bufferdWriter outside this method
//        fileWriter.write("YOUR DATA TO WRITE IN TEXT FILE");
//        fileWriter.newLine();
        //close fileWriter outside this method
//    }

    // </editor-fold>
}