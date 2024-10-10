import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.List;

// パネルの描画/配置機能
public class BalloonPanel extends JPanel {
    private List<Balloon> balloons;

    // バルーンのリストを保持
    public BalloonPanel(List<Balloon> balloons) {
        this.balloons = balloons;
    }

    // パネルの再描画（呼び出し）
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 各バルーンを描画
        for (Balloon balloon : balloons) {
            balloon.draw(g);
        }

        // 残り時間とスコア表示
        g.drawString("Time Remaining: " + BalloonPopGame.timeRemaining, 20, 30);
        g.drawString("Score: " + BalloonPopGame.score, 20, 50);
    }
}


