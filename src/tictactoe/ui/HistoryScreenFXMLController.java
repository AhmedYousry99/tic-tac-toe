/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.ui;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tictactoe.data.MainFileController;
import tictactoe.ui.util.CustomDialogBase;
import tictactoe.ui.util.ScreenController;

/**
 *
 * @author Shyasuo
 */
public class HistoryScreenFXMLController {
    
    
    static boolean getRecordedGames(List<CustomHistoryListTile> listTiles, HistoryScreenFXMLBase historyScreenFXMLBase){
        boolean found;
        String tempName;
        try {
            new MainFileController().getfilesFromDirectory();
            for(File matchFile: MainFileController.storedMatches){
                tempName = matchFile.getName().split("[.]")[0];
                listTiles.add(new CustomHistoryListTile(matchFile, () -> {
                                try {
                ScreenController.pushScreen(new GamePlayBoard(new ReplayMatchController(new MainFileController().readFile(matchFile))), historyScreenFXMLBase);
            } catch (IOException ex) {
                new CustomDialogBase("File is corrupt", "", "Ok", null, null);
            }
                }   
                ));
            }
            found = true;
        } catch (IOException ex) {
            Logger.getLogger(HistoryScreenFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            found = false;  
        }
        return found;
    }
}
