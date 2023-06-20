public class Boundary {
    private int x;
    private int y;
    private int[] posX;
    private int[] posY;
    private int gameOver;
    
    public Boundary(int x, int y, int[] posX, int[] posY) {
        this.x = x;
        this.y = y;
        this.posX = posX;
        this.posY = posY;
        this.gameOver = 0;
    }
    
    public void draw() {
        for(int i=-1; i<=10; i++) {
            for(int j=-1; j<=50; j++) {
                if(i==-1 || i==10 || j==-1 || j==50) {
                    System.out.print("#");
                } else {
                    if(i==y && j==x) {
                        System.out.print("P");
                        for(int k=0; k<4; k++) {
                            if(posX[k]==x && posY[k]==y) {
                                posX[k]=-1;
                                posY[k]=-1;
                                gameOver++; // if we are here means we are able to collect the jewels hence incrementing gameOver.
                            }
                        }
                    } else {
                        if(posX[0]==j && posY[0]==i) {
                            System.out.print("a");
                        } else if(posX[1]==j && posY[1]==i) {
                            System.out.print("b");
                        } else if(posX[2]==j && posY[2]==i) {
                            System.out.print("c");
                        } else if(posX[3]==j && posY[3]==i) {
                            System.out.print("d");
                        } else {
                            System.out.print(" ");
                        }
                    }
                }
            }
            System.out.println();
        }
    }
    
    public int getGameOver() {
        return gameOver;
    }
}
