package tetris2;

import java.io.IOException;

public class Tetris2 {
    
    static int[][] board = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1}
    };
    
    final static int[][][] FIGURES = {
                { 
                    {5,1},
                    {5,2},
                    {5,3},
                    {5,4},
                    
                    {1}
                },
                {
                    {5,1}, 
                    {5,2},{6,2},
                          {6,3},
                        
                    {2}
                },
                {
                          {6,1}, 
                    {5,2},{6,2},
                    {5,3},
                    
                    {3}
                },
                {
                          {6,1}, 
                          {6,2},
                    {5,3},{6,3},
                    
                    {4}
                },
                {
                    {5,1},
                    {5,2},
                    {5,3},{6,3},
                    
                    {5}
                },
                {
                    {5,1}, 
                    {5,2},{6,2},
                    {5,3},
                    
                    {6}
                },

                {
                    {5,1},{6,1},
                    {5,2},{6,2},
                    
                    {7}
                },
	};
    
    static int currentFigureNumber;
    static int[][] currentFigureCoords = {
        {0,0}, {0, 0}, {0, 0}, {0, 0}
    };
    static int score = 0;
    
    static int[][] temp = {
        {0,0}, {0, 0}, {0, 0}, {0, 0}
    };
    

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        generateFigure();
        while(true){
            printBoard();
            int in = readUserInput();
            getOrders(in);
        }
    }
    
    public static void printBoard(){
        for(int y = 0; y < board.length; y++){
            for(int x = 0; x < board[0].length; x++){
                    if(isFigure(x, y) || board[y][x] == 3){
                        System.out.print("* ");
                    }else
                    if(board[y][x] == 1 || board[y][x] == 2){
                        System.out.print("# ");
                    }else
                    if(board[y][x] == 0){
                        System.out.print("  ");
                    }
            }
            System.out.println();
        }
        
    }
    
    public static boolean isFigure(int x, int y){
        
        if(x == 0 && y == 0){
            return false;
        }
        
        for(int i = 0; i < 4; i++){
                if(currentFigureCoords[i][0] == x && currentFigureCoords[i][1] == y){
                    return true;
                }
        }
        return false;
    }
    
    public static void generateFigure(){
        int random = (int )(Math.random() * 7);
        
        currentFigureNumber = FIGURES[random][4][0];
        for(int i = 0; i < 4; i++){
            currentFigureCoords[i][0] = FIGURES[random][i][0];
            currentFigureCoords[i][1] = FIGURES[random][i][1];
        }
        if(isGameOver()){
            System.out.println("Game Over!");
            System.out.println("Your score is: " + score);
            System.exit(0);
        }   
    }
    
    public static int readUserInput() throws IOException{
		int n = System.in.read();
		while (System.in.available() > 0)
			System.in.read();
		return n;
    }
    
    public static void getOrders(int n){
        switch(n){
            case 'a': moveLeft(); break;
            case 'd': moveRight(); break;
            case 's': moveDown(); break;
            case 'w':  if(currentFigureNumber != 7) {rotateFigure();}; break;
	}
    }
    
    public static void moveDown(){
        if(!checkCollideDown()){
            for(int i = 0; i < 4; i++){
                currentFigureCoords[i][1] = currentFigureCoords[i][1]+1;
            }
        } else {
            placeFigure();
        }
    }
    
    public static void moveLeft(){
        if(!checkCollideSide("left")){
            for(int i = 0; i < 4; i++){
                currentFigureCoords[i][0] = currentFigureCoords[i][0]-1;
            }
        }
    }
    
    public static void moveRight(){
        if(!checkCollideSide("right")){
            for(int i = 0; i < 4; i++){
                currentFigureCoords[i][0] = currentFigureCoords[i][0]+1;
            }
        }
    }
    
    public static void rotateFigure(){
        double centerX = currentFigureCoords[1][0];
        double centerY = currentFigureCoords[1][1];
        double x1, x2, y1, y2;
        
        for(int i = 0; i < 4; i++){
                x1 = currentFigureCoords[i][0] - centerX;
                y1 = currentFigureCoords[i][1] - centerY;
                x2 = x1 * Math.cos(Math.toRadians(90)) - y1 * Math.sin(Math.toRadians(90));
                y2 = x1 * Math.sin(Math.toRadians(90)) + y1 * Math.cos(Math.toRadians(90));
                temp[i][0] = (int) (x2 + centerX);
                temp[i][1] = (int) (y2 + centerY);
        }
        
        if(!checkCollideRotate()){
            for(int i = 0; i < 4; i++){
                currentFigureCoords[i][0] = temp[i][0];
                currentFigureCoords[i][1] = temp[i][1];
            }
        }
        
    }
    
    public static boolean checkCollideDown(){
        int x, y;
        for(int i = 0; i < 4; i++){
            x = currentFigureCoords[i][0];
            y = currentFigureCoords[i][1];
            if(board[y+1][x] == 2 || board[y+1][x] == 3){
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean checkCollideRotate(){
        int x, y;
        for(int i = 0; i < 4; i++){
            x = temp[i][0];
            y = temp[i][1];
            if(board[y][x] != 0){
                return true;
            }
        }
        return false;
    }
    
    public static boolean checkCollideSide(String side){
        int x, y;
        for(int i = 0; i < 4; i++){
            x = currentFigureCoords[i][0];
            y = currentFigureCoords[i][1];
            if("left".equals(side) && (board[y][x-1] == 1 || board[y][x-1] == 3)){
                return true;
            }
            if("right".equals(side) && (board[y][x+1] == 1 || board[y][x+1] == 3)){
                return true;
            }
        }
        
        return false;
    }
    
    public static void placeFigure(){
        int x, y;
        for(int i = 0; i < 4; i++){
            x = currentFigureCoords[i][0];
            y = currentFigureCoords[i][1];
            board[y][x] = 3;
        }
        removeLines();
        generateFigure();
    }
    
    public static void removeLines(){
        int y;
        while(findFullLine() > 0){
            y = findFullLine();
            for(int x = 1; x < board[0].length-1; x++){
                board[y][x] = 0;
            }
            pushLines(y);
            score++;
        }
    }
    
    public static int findFullLine(){
        boolean isFull = true;
        for(int y = 1; y < board.length-1; y++){
            for(int x = 1; x < board[0].length-1; x++){
               if(board[y][x] == 0){
                   isFull = false;
               }
            }
            if(isFull){
                return y;
            } else {
                isFull = true;
            }
        }
        return 0;
    }
    
    public static void pushLines(int iy){
        for(int y = iy; y > 1; y--){
            for(int x = 1; x < board[0].length-1; x++){
               board[y][x] = board[y-1][x];
            }
        }
    }

    public static boolean isGameOver() {
        int x,y;
        for(int i = 0; i < 4; i++){
           x = currentFigureCoords[i][0];
           y = currentFigureCoords[i][1];
            if(board[y][x] != 0){
                return true;
            }
        }
        return false;
    }
    
}
