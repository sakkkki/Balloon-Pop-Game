import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Balloon {
    private int x;
    private int y;
    private Color color;

    // バルーン設定
    public Balloon() {
        Random rand = new Random();

        // バルーンの位置をランダム設定
        x = rand.nextInt(BalloonPopGame.WIDTH - 2 * BalloonPopGame.BALLOON_RADIUS);
        y = rand.nextInt(BalloonPopGame.HEIGHT - 2 * BalloonPopGame.BALLOON_RADIUS);

        // バルーンの色をランダム設定
        color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }

    // バルーンを描画
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, 2 * BalloonPopGame.BALLOON_RADIUS, 2 * BalloonPopGame.BALLOON_RADIUS);
    }

    // バルーンのX座標取得メソッド
    public int getX() {
        return x;
    }

    // バルーンのY座標取得メソッド
    public int getY() {
        return y;
    }
}
