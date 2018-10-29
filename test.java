import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test extends Frame implements ActionListener
{
    static test frm = new test();
    static Button btn = new Button("開始遊戲");
    public static void main(String[] args) {
        frm.setSize(400,300);
        frm.setLayout(new FlowLayout());
        btn.addActionListener(frm);
        frm.add(btn);
        frm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
