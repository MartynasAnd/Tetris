package tetris2;

import commands.CommandInterface;
import commands.CommandsList;
import commands.ExitCommand;
import commands.MoveDownCommand;
import commands.MoveLeftCommand;
import commands.MoveRightCommand;
import commands.RotateCommand;
import java.io.IOException;

public class Tetris2 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        GameBoard board = new GameBoard();
        TetrisShape shape = new TetrisShape();
        Score score = new Score();
        GameRenderer gameRenderer = new GameRenderer(board, shape);
        GameRules gameRules = new GameRules(board, shape, score);
        
        CommandsList commands = new CommandsList();
        commands.registerCommand('w', new RotateCommand(shape));
        commands.registerCommand('s', new MoveDownCommand(shape));
        commands.registerCommand('a', new MoveLeftCommand(shape));
        commands.registerCommand('d', new MoveRightCommand(shape));
        commands.registerCommand('x', new ExitCommand());

        while(true){
            gameRenderer.render();
            int n = readUserInput();
            
            CommandInterface command = commands.getCommand((char)n);
            if(command != null){
                command.execute();
            }
            
            gameRules.afterSelect();
        }
    }
    
    public static int readUserInput() throws IOException{
		int n = System.in.read();
		while (System.in.available() > 0)
			System.in.read();
		return n;
    }
}
