// app19_8, ��ܤ�����������
import java.awt.*;
import java.awt.event.*;
public class app19_8 extends Frame implements ActionListener,ItemListener
{
   static app19_8 frm=new app19_8();
   static Dialog dlg=new Dialog(frm);                    // �إ�Dialog����dlg
   static Button Change_btn=new Button("Change Color");  // ���s
   static Button Ok_btn=new Button("Ok");
   static Button Cancel_btn=new Button("Cancel");
   static Checkbox ckb1=new Checkbox("White");           // �֨����
   static Checkbox ckb2=new Checkbox("Yellow");
   static Color clr;

   public static void main(String args[])
   {
      frm.setLayout(new FlowLayout(FlowLayout.CENTER,5,30));
      CheckboxGroup grp=new CheckboxGroup(); // �إ߸s�ժ���
      ckb1.setCheckboxGroup(grp);            // �N�֨�����[�J�s��
      ckb2.setCheckboxGroup(grp);
      frm.setSize(200,150);
      frm.setTitle("Frame");
      frm.setBackground(Color.pink);
      dlg.setTitle("Dialog"); // �]�w��ܤ�������D
      dlg.setSize(150,120);   // �]�w��ܤ�����j�p
      dlg.setLayout(null);
      ckb1.setBounds(20,50,60,20);  // �]�w�֨��������m�j�p
      ckb2.setBounds(20,70,60,20);
      Ok_btn.setBounds(85,45,50,20);// �]�w���s����m�j�p
      Cancel_btn.setBounds(85,70,50,20);
      dlg.add(Ok_btn);        // �N���s�[�J��ܤ��
      dlg.add(Cancel_btn);
      dlg.add(ckb1);          // �N�֨�����[�J��ܤ��
      dlg.add(ckb2);
      Change_btn.addActionListener(frm);  // �]�wChange_btn����ť��
      Cancel_btn.addActionListener(frm);  // �]�wCancel_btn����ť��
      Ok_btn.addActionListener(frm);      // �]�wOk_btn����ť��
      ckb1.addItemListener(frm);          // �]�w�֨����ckb1����ť��
      ckb2.addItemListener(frm);          // �]�w�֨����ckb2����ť��
      frm.add(Change_btn);
      frm.setVisible(true);
   }

   public void actionPerformed(ActionEvent e)   // ���U��ܤ���W�����s
   {
      Button btn=(Button) e.getSource();        // ���o�Q���U�����s
      if(btn==Change_btn)                       // ���UChange Color�s
      {
         dlg.setLocation(120,80);               // �]�w��ܤ������m
         dlg.setVisible(true);                  // ��ܹ�ܤ��
      }
      else if(btn==Ok_btn)                      // �p�G�OOk�s�Q��
      {
         frm.setBackground(clr);                // �]�w�I���C��
         dlg.setVisible(false);                 // ���ù�ܤ��
      }
      else if(btn==Cancel_btn)                  // �p�G�OCancel�s�Q��
         dlg.setVisible(false);                 // ���ù�ܤ��
   }

   public void itemStateChanged(ItemEvent e)    // ����C��
   {
      if(ckb1.getState())                       // ckb1�Q���
         clr=Color.white;                       // �]���զ�
      else if(ckb2.getState())                  // ckb2�Q���
         clr=Color.yellow;                      // �]������
   }
}
