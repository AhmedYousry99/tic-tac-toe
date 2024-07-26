/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import tictactoe.domain.FileController;
import tictactoe.domain.PlayingMode;

/**
 *
 * @author Kerolos Raouf
 */
public class MainFileController implements FileController{

    private String url = "src/tictactoe/data/files";
    static public ArrayList<File> storedMatches;
    
    static{
        storedMatches = new ArrayList<>();
    }
    @Override
    public void writeFileInDirectory(String mode, String moves) throws IOException {
        
 
        File file = new File( url +"/" + prepareName(mode) + ".txt");
        
        createDirectoryIfNotExists();
        if(file.createNewFile())
        {
            FileOutputStream os = new FileOutputStream(file);
            byte[] data = moves.getBytes(); 
            os.write(data);
            os.close();
        }
        
    }
    
    private String prepareName(String mode)
    {
        Date date = new Date();
        String dateStr = mode + " " +date.toString().replace(':', '_');
        return dateStr;
    }

    @Override
    public String readFile(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        int size = fis.available();
        byte[] data= new byte[size];
        fis.read(data);
        String result = new String(data);
        fis.close();
        return result;
    }

    @Override
    public void getfilesFromDirectory() throws IOException {
        
        createDirectoryIfNotExists();
        File file = new File(url);
        
        File[] all = file.listFiles();

        storedMatches.clear();
        for(File f : all)
        {
            storedMatches.add(f);
        } 
    }
    
 
    
    private boolean createDirectoryIfNotExists()
    {
        File dir = new File(url);
        if(!dir.exists())
        {
            return dir.mkdir();
        }
        return true;
    }
    
}
