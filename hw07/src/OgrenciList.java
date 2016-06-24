import javax.swing.*;

/**
 * Created by Necdet on 25.5.2015.
 */

public class OgrenciList {

    private IntNode front;

    public OgrenciList()
    {
        front = null;
    }

    public void addOgrenci(Ogrenci ogrenci)
    {
        front = new IntNode(ogrenci,front);
    }

    public int length()
    {
        int count=0;
        if(front==null)
            count=0;
        else {
            IntNode temp = front;
            while (temp != null) {
                count++;
                temp = temp.next.next;
            }
        }
        return count;
    }

    public void guncelleme(int oldno, Ogrenci newOgrenci)
    {
        IntNode temp = front;
        while (temp != null)
        {
            int no = temp.ogrenci.getNo();
            if(no==oldno)
                temp.ogrenci=newOgrenci;
            temp=temp.next;
        }
    }

    public boolean ogrenciSil(String newOgrenci) {
        IntNode temp = front;
        IntNode prevNode = null;
        boolean deletedANode = false;

        if (front == null) {
            return deletedANode;
        }

        while (temp != null) {
            String oldOgrenci = String.valueOf(temp.ogrenci);

            if(oldOgrenci.equals(newOgrenci)) {
                if (temp == front) {
                    front = front.next;
                }
                else {
                    prevNode.next = temp.next;
                }
                deletedANode = true;
            }

            prevNode = temp;
            temp = temp.next;
        }

        return deletedANode;
    }

    public Ogrenci print(DefaultListModel listModel,JList list)
    {
        list.setModel(listModel);
        IntNode temp = front;
        while (temp != null)
        {
            listModel.addElement(temp.ogrenci);
            temp = temp.next;
        }
        return null;
    }

    public Ogrenci noBul(DefaultListModel listModel,JList list,int numara)
    {
        IntNode temp = front;
        list.setModel(listModel);
        while (temp != null)
        {
            int no = temp.ogrenci.getNo();
            if(no==numara)
                listModel.addElement(temp.ogrenci);
            temp = temp.next;
        }
        return null;
    }

    public Ogrenci adBul(DefaultListModel listModel,JList list,String adı)
    {
        list.setModel(listModel);
        IntNode temp = front;
        while (temp != null)
        {
            String ad = temp.ogrenci.getAd();
            if(ad.equalsIgnoreCase(adı))
                listModel.addElement(temp.ogrenci);
            temp = temp.next;
        }
        return null;
    }

    public Ogrenci soyadBul(DefaultListModel listModel,JList list,String soyadı)
    {
        list.setModel(listModel);
        IntNode temp = front;
        while (temp != null)
        {
            String soyad = temp.ogrenci.getSoyad();
            if(soyad.equalsIgnoreCase(soyadı))
                listModel.addElement(temp.ogrenci);
            temp = temp.next;
        }
        return null;
    }

    public Ogrenci bolumBul(DefaultListModel listModel,JList list,String bolumu)
    {
        list.setModel(listModel);
        IntNode temp = front;
        while (temp != null)
        {
            String bolum = temp.ogrenci.getBolum();
            if(bolum.equalsIgnoreCase(bolumu))
                listModel.addElement(temp.ogrenci);
            temp = temp.next;
        }
        return null;
    }

    public Ogrenci notBul(DefaultListModel listModel,JList list,Double notu)
    {
        list.setModel(listModel);
        IntNode temp = front;
        while (temp != null)
        {
            Double not = temp.ogrenci.getNot();
            if(not>=notu)
                listModel.addElement(temp.ogrenci);
            temp = temp.next;
        }
        return null;
    }

    private class IntNode
    {
        public Ogrenci ogrenci;
        public IntNode next;

        public IntNode(Ogrenci ogrenci, IntNode next)
        {
            this.ogrenci = ogrenci;
            this.next = next;
        }
    }
}

