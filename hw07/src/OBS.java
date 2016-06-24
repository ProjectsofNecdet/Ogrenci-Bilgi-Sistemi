import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;


/**
 * Created by Necdet on 23.5.2015.
 */
public class OBS {
    private JTabbedPane Pane1;
    private JPanel sil;
    private JPanel ekle;
    private JPanel guncelle;
    private JPanel arama;
    private JPanel listele;
    private JLabel noLabel;
    private JLabel adLabel;
    private JLabel soyadLabel;
    private JLabel bolumLabel;
    private JLabel notLabel;
    private JTextField noText;
    private JTextField adText;
    private JTextField soyadText;
    private JTextField bolumText;
    private JTextField notText;
    private JButton ekleButton;
    private JLabel noSilLabel;
    private JTextField noSilText;
    private JButton silButton;
    private JList lOgrenciList;
    private JList sOgrenciList;
    private JList gOgrenciList;
    private JTextField gNoText;
    private JLabel gNoLabel;
    private JTextField gAdText;
    private JTextField gSoyadText;
    private JTextField gBolumText;
    private JTextField gNotText;
    private JButton guncelleButton;
    private JLabel gAdLabel;
    private JLabel gSoyadLabel;
    private JLabel gBolumLabel;
    private JLabel gNotLabel;
    private JTextField aNoText;
    private JButton AraButton;
    private JList aOgrenciList;
    private JLabel aNoLabel;
    private JPanel OBSPanel;
    private JButton listeleButton;
    private JTextField aAdText;
    private JTextField aSoyadText;
    private JTextField aBolumText;
    private JTextField aNotText;
    private JLabel aAdLabel;
    private JLabel aSoyadLabel;
    private JLabel aBolumLabel;
    private JLabel aNotLabel;
    private JButton sListButton;
    private JButton gListeButton;
    private static Ogrenci ogrenci,yeniOgrenci;
    private static OgrenciList list = new OgrenciList();
    private Integer no,oldno;
    private String ad, soyad, bolum;
    private Double not;

    DefaultListModel listModelA,listModelL,listModelS,listModelG;

    public static void main(String[] args) {
        JFrame frame = new JFrame("OBS");
        frame.setContentPane(new OBS().OBSPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public OBS() {

        listModelA = new DefaultListModel();
        listModelL = new DefaultListModel();
        listModelS = new DefaultListModel();
        listModelG = new DefaultListModel();
        sOgrenciList.setModel(listModelS);
        aOgrenciList.setModel(listModelA);
        lOgrenciList.setModel(listModelL);
        gOgrenciList.setModel(listModelG);

        ekleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                no=Integer.parseInt(noText.getText());
                ad = adText.getText();
                soyad = soyadText.getText();
                bolum = bolumText.getText();
                not=Double.parseDouble(notText.getText());

                ogrenci = new Ogrenci(no, ad, soyad, bolum, not);
                list.addOgrenci(ogrenci);

                JOptionPane.showMessageDialog(null,"Kayıt Başarıyla Oluşturuldu.");

                noText.setText("");
                adText.setText("");
                soyadText.setText("");
                bolumText.setText("");
                notText.setText("");
            }
        });
        AraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(!aNoText.getText().equals("")) {
                    listModelA.clear();
                    no = Integer.parseInt(aNoText.getText());
                    list.noBul(listModelA,aOgrenciList,no);
                    aNoText.setText("");
                }
                if (!aAdText.getText().equals(""))
                {
                    listModelA.clear();
                    ad=aAdText.getText();
                    list.adBul(listModelA,aOgrenciList,ad);
                    aAdText.setText("");
                }
                if (!aSoyadText.getText().equals(""))
                {
                    listModelA.clear();
                    soyad=aSoyadText.getText();
                    list.soyadBul(listModelA,aOgrenciList,soyad);
                    aSoyadText.setText("");
                }
                if(!aBolumText.getText().equals(""))
                {
                    listModelA.clear();
                    bolum=aBolumText.getText();
                    list.bolumBul(listModelA,aOgrenciList,bolum);
                    aBolumText.setText("");
                }
                if(!aNotText.getText().equals(""))
                {
                    listModelA.clear();
                    not=Double.parseDouble(aNotText.getText());
                    list.notBul(listModelA,aOgrenciList,not);
                    aNotText.setText("");
                }
            }
        });

        guncelleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                no=Integer.parseInt(gNoText.getText());

                    ad = gAdText.getText();
                    soyad = gSoyadText.getText();
                    bolum = gBolumText.getText();
                    not = Double.parseDouble(gNotText.getText());

                    yeniOgrenci = new Ogrenci(no, ad, soyad, bolum, not);

                    list.guncelleme(oldno, yeniOgrenci);
                oldno=yeniOgrenci.getNo();


                listModelG.clear();
                list.print(listModelG,gOgrenciList);

            }
        });
        listeleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModelL.clear();
                list.print(listModelL,lOgrenciList);
            }
        });
        silButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModelS.clear();
                String newOgrenci = noSilText.getText();
                list.ogrenciSil(newOgrenci);
                list.print(listModelS,sOgrenciList);
                noSilText.setText("");
            }
        });
        sListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModelS.clear();
                list.print(listModelS,sOgrenciList);
            }
        });
        sOgrenciList.addMouseListener(new MouseAdapter() {
        });
        sOgrenciList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(e.getValueIsAdjusting()) {
                    noSilText.setText(String.valueOf(sOgrenciList.getSelectedValue()));
                }
            }
        });
        gListeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModelG.clear();
                list.print(listModelG,gOgrenciList);
            }
        });

        gOgrenciList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JList lists = (JList)e.getSource();
                if (e.getClickCount() == 1) {

                    String[] studentLines = lists.getSelectedValue().toString().split(" ");

                    gNoText.setText(studentLines[0]);
                    gAdText.setText(studentLines[1]);
                    gSoyadText.setText(studentLines[2]);
                    gBolumText.setText(studentLines[3]);
                    gNotText.setText(studentLines[4]);

                    oldno=Integer.parseInt(studentLines[0]);
                }
            }
        });

    }
}