public class Gamee {
    public static int h = 10;
    public static int w = 20;
    static char[][] lake = new char[h][w];

    Bear BB;
    Fish FF;


    public Gamee() {
        for (int i = 0; i < h; i++) {       //처음 set
            for (int j = 0; j < w; j++) {
                lake[i][j] = '-';
            }
        }
        BB = new Bear(0, 0, 1);
        FF = new Fish(9, 5, 1);
    }


    private void set(Bear BB, Fish FF) {    //베어, 피쉬 위치 설정하고 호수 배열 set
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
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


    public void draw() {       //호수 그리기
        System.out.println();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(lake[i][j]);
            }
            System.out.println();
        }
    }

    public void run() {       //게임 start
        System.out.println("** Bear의 Fish 먹기 게임을 시작합니다.**");

        set(BB,FF);
        draw();

        int[] randarr = new int[2];

        while (!BB.collide(FF)) {         //베어와 피쉬의 좌표가 같아질때까지

            for(int n=0; n<2; n++) {          //다섯번 중 피쉬가 이동할 두번의 순서 배열 정하기
                int rand = (int) (Math.random() * 4);
                randarr[n]=rand;
                for (int j = 0; j < n; j++) {
                    if (randarr[n] == randarr[j]) {
                        n--;
                    }
                }
            }

            for (int i=0; i<5; i++) {          //다섯번 실행 - 랜덤으로 정한 두번의 차례엔 피쉬 이동
                BB.move();
                for (int j = 0; j < 2; j++) {
                    if (i == randarr[j])
                        FF.move();
                }
                set(BB,FF);
                draw();
                System.out.println("Bear : ("+BB.getX()+","+BB.getY()+")  Fish : ("+FF.getX()+","+FF.getY()+")");
            }
        }
        System.out.println("win");
    }


    public static void main(String[] args) {
        Gamee game = new Gamee();
        game.run();
    }
}

