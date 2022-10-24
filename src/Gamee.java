public class Gamee {
    public static int h = 10;
    public static int w = 20;
    static char[][] lake = new char[h][w];

    Bear BB;
    Fish FF;


    public Gamee() {
        for (int i = 0; i < lake.length; i++) {       //initial set
            for (int j = 0; j < lake[i].length; j++) {
                lake[i][j] = '-';
            }
        }
        BB = new Bear(0, 0, 1);
        FF = new Fish(9, 5, 1);
    }


    private void set(Bear BB, Fish FF) {    //set B&$ on lake array
        for (int i = 0; i < lake.length; i++) {
            for (int j = 0; j < lake[i].length; j++) {
                lake[i][j] = '-';
                if(i==FF.getY() && j==FF.getX()) {
                    lake[i][j]=FF.getShape();
                }
                if(i==BB.getY() && j==BB.getX()) {
                    lake[i][j]=BB.getShape();
                }
            }
        }
    }


    public void draw() {       //draw lake array
        System.out.println();
        for (int i = 0; i < lake.length; i++) {
            for (int j = 0; j < lake[i].length; j++) {
                System.out.print(lake[i][j]);
            }
            System.out.println();
        }
    }

    public void run() {       // start
        System.out.println("** Bear & Fish Game Start **");

        set(BB,FF);
        draw();

        int[] randarr = new int[2];

        while (!BB.collide(FF)) {         //while ~ B(x,y)=$(x,y)

            for(int n=0; n<2; n++) {       // FF.move() Run Twice Out Of 5 Times Randomly
                int rand = (int) (Math.random() * 4);  //rand=0~5
                randarr[n]=rand;
                for (int j = 0; j < n; j++) {
                    if (randarr[n] == randarr[j]) {    //randarr means when FF.move() run
                        n--;
                    }
                }
            }

            for (int i=0; i<5; i++) {
                BB.move();
                for (int j = 0; j < 2; j++) {
                    if (i == randarr[j])
                        FF.move();
                }
                set(BB,FF);
                draw();
                //System.out.println("Bear : ("+BB.getX()+","+BB.getY()+")  Fish : ("+FF.getX()+","+FF.getY()+")");
            }
        }
        System.out.println("win");
    }


    public static void main(String[] args) {
        Gamee game = new Gamee();
        game.run();
    }
}

