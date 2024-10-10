import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;


public class BalloonPopGame extends JFrame {
    public static final int WIDTH = 700;          // 幅
    public static final int HEIGHT = 450;         // 高さ
    public static final int BALLOON_RADIUS = 30;  // バルーンの半径
    public static final int TIMER_DELAY = 1000;   // タイマーの遅延（ms）
    public static final int GAME_DURATION = 30;   // ゲームの制限時間（秒）

    public static int timeRemaining;
    public static int score;

    private Timer timer;
    private List<Balloon> balloons;

    
    // 表示画面
    public BalloonPopGame() {
        setTitle("Balloon Pop Game");
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // ウィンドウズが閉じるとともにゲーム終了

        timeRemaining = GAME_DURATION;  // 制限時間
        score = 0;                      // スコア初期値

        balloons = new ArrayList<>();
        timer = new Timer(TIMER_DELAY, new GameTimerTask());
        timer.start();

        BalloonPanel balloonPanel = new BalloonPanel(balloons);
        add(balloonPanel);
        addBalloon();

        addMouseListener(new BalloonMouseListener());
    }

    // タイマー機能
    private class GameTimerTask implements ActionListener {

        // タイマー実行時
        public void actionPerformed(ActionEvent e) {
            timeRemaining--;            // 残り時間
            if (timeRemaining <= 0) {   // 0秒になればゲーム終了
                endGame();
            }
            repaint();
        }
    }

    // バルーンの表示
    private void addBalloon() {

        // 同時に表示するバルーンの最大数
        if (balloons.size() < 10) {
            balloons.add(new Balloon());
        }
    }

    // バルーンの削除
    private void removeBalloon(Balloon balloon) {
        balloons.remove(balloon);
    }

    // ゲーム終了時
    private void endGame() {
        timer.stop();
        JOptionPane.showMessageDialog(this, "Game Over!\nYour Score: " + score);  // ゲーム終了時表示画面
        System.exit(0);                                                           // プログラムの正常終了
    }

    // マウス操作
    private class BalloonMouseListener extends MouseAdapter {

        // マウスクリック動作
        public void mouseClicked(MouseEvent e) {
            for (Balloon balloon : new ArrayList<>(balloons)) {
                if (Math.sqrt(Math.pow(e.getX() - (balloon.getX() + BALLOON_RADIUS), 2) +
                             Math.pow(e.getY() - (balloon.getY() + BALLOON_RADIUS), 2)) <= BALLOON_RADIUS) {
                    score++;
                    removeBalloon(balloon);  // バルーンの削除
                    addBalloon();            // バルーンの追加
                    break;
                }
            }
        }
    }

}
