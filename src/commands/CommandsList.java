/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author PR
 */
public class CommandsList {
    private Map<Character, CommandInterface> commands = new HashMap<>();

    public void registerCommand(Character w, CommandInterface command){
        commands.put(w, command);
    }
    public CommandInterface getCommand(Character w){
        return commands.get(w);
    }
}
