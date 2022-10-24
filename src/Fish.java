public class Fish extends GameObject {
    public Fish(int startX, int startY, int distance) {
        super(startX, startY, distance);
    }

    @Override
    protected void move() {

        int n = (int) (Math.random() * 4);
        switch (n) {
            case 0:
                x += distance;
                if (x >= Gamee.w) x = Gamee.w - 1;
                break;
            case 1:
                x -= distance;
                if (x < 0) x = 0;
                break;
            case 2:
                y += distance;
                if (y >= Gamee.h) x = Gamee.h - 1;
                break;
            case 3:
                y -= distance;
                if (y < 0) y = 0;
                break;
        }
    }

    @Override
    protected char getShape() {
        return '$';
    }
}
