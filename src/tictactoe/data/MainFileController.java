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

    static public ArrayList<File> storedGames;
    
    static{
        storedGames = new ArrayList<>();
    }
    @Override
    public void writeFileInDirectory(String mode, String moves) throws IOException {
        
 
        File file = new File("src/tictactoe/data/files/" + prepareName(mode) + ".txt");
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
        File file = new File("src/tictactoe/data/files");
        System.out.println(file.getAbsolutePath());
        
        File[] all = file.listFiles();
        
        for(File f : all)
        {
            storedGames.add(f);
        }
    }
    
}
