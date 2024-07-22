/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import tictactoe.domain.FileController;
import tictactoe.domain.PlayingMode;

/**
 *
 * @author Kerolos Raouf
 */
public class MainFileController implements FileController{

    @Override
    public void writeFileInHardDisk(String mode, String moves) throws IOException {
        
 
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
    public String readFileFromHardDisk() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
