import java.util.Scanner;

public class Bear extends GameObject {
    Scanner sc = new Scanner(System.in);

    public Bear(int startX, int startY, int distance) {
        super(startX, startY, distance);
    }

    @Override
    protected void move() {
        System.out.println("a:left\ns:up\nd:down\nf:right\n>>");
        char c = sc.next().charAt(0);
        switch (c) {
            case 'a':
                x-=1;
                if(x<=0) x=0; break;
            case 's':
                y-=1;
                if(y<=0) y=0; break;
            case 'd':
                y+=1;
                if(y>=Gamee.h) y=Gamee.h-1; break;
            case 'f':
                x+=1;
                if(x>=Gamee.w) x=Gamee.w-1; break;
        }
    }

    @Override
    protected char getShape() {
        return 'B';
    }
}