/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.domain;

import java.io.IOException;

/**
 *
 * @author Shyasuo
 */
public interface SignUpInterface {
     int SignupWithUsernameAndPassword(String username, String password) throws IOException;
}