
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class test extends Frame implements ActionListener,ItemListener{
    static test frm = new test();
    static Button start = new Button("start");
    static Button setting = new Button("setting");
    static Dialog startfrm = new Dialog(frm);
    static Dialog settingfrm = new Dialog(frm);
    static Label time = new Label();
    static Label score = new Label("score:");
    static Label gmover = new Label("GAMEOVER");
    static int point = 0;
    static Button click = new Button("Click");
    static Label change_color = new Label("Background color");
    static Label change_font = new Label("Font");
    static Button Ok_btn = new Button("OK");
    static Button Cancel_btn = new Button("Cancel");
    static Choice background_color = new Choice();
    static Checkbox font1 = new Checkbox("DIALOG");
    static Checkbox font2 = new Checkbox("SERIF");
    static Color color;
    static int minute = 10;
    static String[] font = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();


    public static void main(String[] args) throws InterruptedException {
        CheckboxGroup grp = new CheckboxGroup();
        frm.setTitle("點擊次數計算器");
        startfrm.setTitle("開始點擊");
        settingfrm.setTitle("設定");
        frm.setSize(400, 300);
        frm.setLocationRelativeTo(null);
        frm.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 60));
        startfrm.setLayout(null);
        settingfrm.setLayout(null);
        Ok_btn.setBounds(200, 250, 60, 25);// 設定按鈕的位置大小
        Cancel_btn.setBounds(280, 250, 60, 25);
        change_color.setBounds(70, 80, 100, 25);
        background_color.setBounds(220, 80, 150, 25);
        change_font.setBounds(140, 150, 100, 25);
        font1.setBounds(220,135,100,25);
        font2.setBounds(220,170,100,25);
        time.setBounds(295,50,100,50);
        time.setFont(new Font("標楷體",Font.BOLD,40));
        click.setBounds(155,170,100,50);
        gmover.setBounds(90,170,250,50);
        gmover.setFont(new Font("標楷體",Font.BOLD,40));
        score.setBounds(50,50,160,50);
        score.setFont(new Font("標楷體",Font.BOLD,35));
        start.addActionListener(frm);
        click.addActionListener(frm);
        setting.addActionListener(frm);
        Cancel_btn.addActionListener(frm);
        Ok_btn.addActionListener(frm);
        background_color.addItemListener(frm);
        font1.addItemListener(frm);
        font2.addItemListener(frm);
        font1.setCheckboxGroup(grp);
        font2.setCheckboxGroup(grp);
        frm.add(start);
        frm.add(setting);
        startfrm.add(time);
        startfrm.add(click);
        startfrm.add(score);
        startfrm.add(gmover);
        settingfrm.add(Ok_btn);
        settingfrm.add(Cancel_btn);
        settingfrm.add(change_color);
        settingfrm.add(change_font);
        settingfrm.add(background_color);
        settingfrm.add(font1);
        settingfrm.add(font2);

        background_color.add("yellow");         // 加入選項到下拉表單物件
        background_color.add("orange");
        background_color.add("pink");
        background_color.add("cyan");
        close();
        frm.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        Button btn = (Button) e.getSource();
        if (btn == start) {
            startfrm.setVisible(true);
            startfrm.setSize(400, 300);
            minute=10;
            point=0;
            click.setVisible(true);
            gmover.setVisible(false);
            miniute();
        }else if (btn == click){
            point = point+1;
            score.setText("score:"+String.valueOf(point));
        } else if (btn == setting) {
            settingfrm.setVisible(true);
            settingfrm.setSize(400, 300);
        } else if (btn == Ok_btn) {
            frm.setBackground(color);
            startfrm.setBackground(color);
            settingfrm.setBackground(color);
            gmover.setBackground(color);
            time.setBackground(color);
            score.setBackground(color);
            change_color.setBackground(color);
            change_font.setBackground(color);
            font1.setBackground(color);
            font2.setBackground(color);

            settingfrm.setVisible(false);
        } else if (btn == Cancel_btn) {
            settingfrm.setVisible(false);
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        String chc = background_color.getSelectedItem();
        if (chc == "yellow") {
            color = Color.yellow;
        }else if (chc == "orange") {
            color = Color.orange;
        }else if (chc == "pink") {
            color = Color.pink;
        }else if (chc == "cyan") {
            color = Color.cyan;
        }
        if (font1.getState()==true) {
            score.setFont(new Font(Font.DIALOG, Font.PLAIN, 35));
            time.setFont(new Font(Font.DIALOG, Font.PLAIN, 40));
            gmover.setFont(new Font(Font.DIALOG, Font.PLAIN, 40));
        }else if (font2.getState()==true) {
            score.setFont(new Font(Font.SERIF,Font.ITALIC,35));
            time.setFont(new Font(Font.SERIF,Font.ITALIC,40));
            gmover.setFont(new Font(Font.SERIF,Font.ITALIC,40));
        }
    }


     static void miniute() {
         final int[] a = {0};
        Timer timer3 = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                minute = minute - 1;
                time.setText(String.valueOf(minute));
                if (minute < 0) {
                    time.setText("0");
                    click.setVisible(false);
                    gmover.setVisible(true);
                    a[0] = 1;
                }
            }
        });
            timer3.start();
            if (a[0] ==1) {
                timer3.stop();
            }
        }
    static void close(){
        frm.addWindowListener(new WindowAdapter()
        {
            public void windowClosing (WindowEvent e) { //<--- 當按下關閉視窗時
                System.exit (0); //<--- 結束程式
            }
        });
        startfrm.addWindowListener(new WindowAdapter()
        {
            public void windowClosing (WindowEvent e) { //<--- 當按下關閉視窗時
               startfrm.setVisible(false); //<--- 關閉視窗
                score.setText("score:");
            }
        });
        settingfrm.addWindowListener(new WindowAdapter()
        {
            public void windowClosing (WindowEvent e) { //<--- 當按下關閉視窗時
                settingfrm.setVisible(false); //<--- 關閉視窗
            }
        });
    }
}
