/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.domain;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Shyasuo
 */
public interface FileController {
    void writeFileInDirectory(String mode,String moves) throws IOException;
    
    String readFile(File file) throws IOException;
    
    void getfilesFromDirectory() throws IOException;
}
