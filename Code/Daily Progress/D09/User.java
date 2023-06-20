public class User {
    private int x;
    private int y;
    private int noOfMoves;
    private boolean gameQuit;
    
    public User(int x, int y) {
        this.x = x;
        this.y = y;
        this.noOfMoves = 0;
        this.gameQuit = false;
    }
    
    public void changeLocation(char keyPressed) {
        switch(keyPressed) {
            case 'w':
                if(y != 0) {
                    noOfMoves++;
                    y--;
                }
                break;
            case 'a':
                if(x != 0) {
                    noOfMoves++;
                    x--;
                }
                break;
            case 's':
                if(x != 49) {
                    noOfMoves++;
                    x++;
                }
                break;
            case 'z':
                if(y != 9) {
                    noOfMoves++;
                    y++;
                }
                break;
            case 'q':
                gameQuit = true;
                break;
        }
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getNoOfMoves() {
        return noOfMoves;
    }
    
    public boolean getGameQuit() {
        return gameQuit;
    }
}
