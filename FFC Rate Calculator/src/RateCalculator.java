import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * Created by user on 02-Jan-17.
 */
public class RateCalculator implements ActionListener {

    public JPanel panel;

    private JComboBox dest;
    private JTextField wt;
    private JTextField baseprice;
    private JTextField servicetax;
    private JCheckBox INSURANCEAPPLICABLE;
    private JTextField itemprice;
    private JTextField payableamt;
    private JTextField insuranceamt;
    private JButton calculateButton;
    private JTextField FAIZABADTextField;
    private JCheckBox PARCELCheckBox;
    public int weight;
    public int xtra, i, cmt, amt, flag, count, temp, itprice;
    public double tamt, item, insprice = 0, tax, tprice,itax;


    public RateCalculator() {

        this.panel.setPreferredSize(new Dimension(500, 400));
        this.calculateButton.addActionListener(this);
//        this.dest.addActionListener(this);
        this.INSURANCEAPPLICABLE.addActionListener(this);
        FAIZABADTextField.setText("FAIZABAD");
        payableamt.setEditable(false);
        insuranceamt.setEditable(false);
        baseprice.setEditable(false);
        servicetax.setEditable(false);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == calculateButton)
            this.calculate();
        if (actionEvent.getSource() == INSURANCEAPPLICABLE)
            this.ins();

    }

    public void calculate() {
        DecimalFormat dff=new DecimalFormat(".##");
        count = 0;
        xtra = 0;
        temp = 0;
        if (wt.getText().equals("")) {
            this.reset();
            JOptionPane.showMessageDialog(null, "enter weight in gms");
        }
        if (itemprice.getText().equals("")&&INSURANCEAPPLICABLE.isSelected()==true) {
            this.reset();
            JOptionPane.showMessageDialog(null, "enter item price");
        }

        weight = Integer.parseInt(wt.getText());
        int z = this.combo();
        if (z == 0) {
            this.reset();
            JOptionPane.showMessageDialog(null, "select destination");
        }
        if (z == 1) {
            cmt = 35;
            xtra = 12;
        } else if (z == 2) {
            cmt = 45;
            xtra = 16;
        } else if (z == 3) {
            cmt = 90;
            xtra = 25;
        } else if (z == 4) {
            cmt = 110;
            xtra = 35;
        } else if (z == 5) {
            cmt = 135;
            xtra = 45;
        } else if (z == 6) {
            cmt = 20;
            xtra = 10;
        }
        if (PARCELCheckBox.isSelected())
            cmt = cmt + 20;


        i = weight;
        if (i <= 250)
            temp = 0;
        else {
            for (i = 250; i < weight; i++) {

                if (i % 250 == 0) {
                    temp = temp + xtra;
                    count++;
                }


            }


        }
        amt = cmt + temp;
        tamt = amt + (amt * 0.33);
        tax = tamt * 0.15;

        baseprice.setText(String.valueOf(dff.format(tamt)));
        if (flag == 1)
            item = Double.parseDouble(itemprice.getText());
        if (flag == 0)
            item = 0;
        insprice = (2 * item) / 100;
        insuranceamt.setText(String.valueOf(insprice));
        tprice = tamt + tax + insprice;

//        System.out.println("ayush");
        itprice = (int) (tprice);
        if ((tprice - itprice) != 0) {
            System.out.println("round off");
            itprice = itprice + 1;
        }

        itax = itprice - tamt-insprice;
        System.out.println(itprice);
        servicetax.setText(String.valueOf(dff.format(itax)));
        payableamt.setText(String.valueOf(itprice));
        //System.out.println(insprice);
        //System.out.println(flag);
        if (INSURANCEAPPLICABLE.isSelected() == true && PARCELCheckBox.isSelected() == false) {
            this.reset();
            JOptionPane.showMessageDialog(null, "non-parcel item can't be booked as insured");

        }


//        if(INSURANCEAPPLICABLE.isSelected()&&itemprice.getText().equals(""))
//            JOptionPane.showMessageDialog(null, "enter Item Price");

    }

    public int combo() {
        int a = dest.getSelectedIndex();
        return a;
    }


    public void ins() {
        if (INSURANCEAPPLICABLE.isSelected()) {
            itemprice.setEnabled(true);
            itemprice.setEditable(true);
            insuranceamt.setEnabled(true);
            PARCELCheckBox.setSelected(true);
            flag = 1;
        } else {
            itemprice.setText(" ");
            insuranceamt.setText(" ");
            itemprice.setEnabled(false);
            insuranceamt.setEnabled(false);
            flag = 0;
        }
    }

    public void reset() {
        wt.setText("0.0");
        dest.setSelectedIndex(0);
        INSURANCEAPPLICABLE.setSelected(false);
        itemprice.setEditable(false);
        PARCELCheckBox.setSelected(false);
        servicetax.setText("0.0");
        baseprice.setText("0.0");
        payableamt.setText("0.0");
        itemprice.setText("0.0");
        insuranceamt.setText("0.0");
    }


}
