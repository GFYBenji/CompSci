import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

class Screen extends JPanel implements MouseListener, ActionListener, KeyListener, WindowListener {

    private MyImage mandelImage, mJImage, jImage;
    private JLabel mandelLabel;
    private JTextField txtRe;
    private JTextField txtIm;
    private JButton btnConfirm;
    private int xx, yy, width, height;
    private JFrame juliaWindow, mJuliaWindow;
    private Boolean julia, mJulia;

    public Screen(MyImage inImage) {
        mandelImage = inImage;
        mandelFrame();
        width = mandelImage.getWidth();
        height = mandelImage.getHeight();
        julia = mJulia = false;
    }

    private void mandelFrame() {
        JFrame mandelWindow = new JFrame("MoodleBroot");
        mandelWindow.setBounds(0, 0, mandelImage.getWidth(), mandelImage.getHeight());
        mandelWindow.setResizable(false);
        mandelWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mandelWindow.setLocationRelativeTo(null);
        mandelLabel = new JLabel();
        mandelLabel.setBounds(0, 0, mandelImage.getWidth(), mandelImage.getHeight());
        mandelLabel.setIcon(new ImageIcon(mandelImage));
        mandelLabel.addMouseListener(this);
        mandelLabel.addKeyListener(this);
        mandelLabel.setFocusable(true);
        mandelWindow.add(mandelLabel);
        mandelWindow.setVisible(true);
    }

    private void juliaFrame(MyImage image) {
        juliaWindow = new JFrame("Jellybread");
        juliaWindow.addWindowListener(this);
        juliaWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        juliaWindow.setBounds(0, 0, image.getWidth(), image.getHeight());
        juliaWindow.setResizable(false);
        juliaWindow.setLocationRelativeTo(null);
        JLabel juliaLabel = new JLabel();
        juliaLabel.setBounds(0, 0, juliaWindow.getWidth(), juliaWindow.getHeight());
        juliaLabel.setIcon(new ImageIcon(image));
        juliaWindow.add(juliaLabel);
        juliaWindow.setVisible(true);
        julia = true;
    }

    private void manualJulia() {
        JLabel lblRe;
        JLabel lblIm;
        JLabel lblTitle;
        JLabel lblSpacer;

        mJuliaWindow = new JFrame("Juliaset Creator");
        JPanel jpanel1 = new JPanel();

        jpanel1.setBorder(BorderFactory.createTitledBorder("Choose Your Values"));

        GridBagLayout gbManualJulia = new GridBagLayout();
        GridBagConstraints gbcManualJulia = new GridBagConstraints();
        jpanel1.setLayout(gbManualJulia);

        btnConfirm = new JButton("Go!");
        btnConfirm.addActionListener(this);
        gbcManualJulia.gridx = 6;
        gbcManualJulia.gridy = 14;
        gbcManualJulia.gridwidth = 9;
        gbcManualJulia.gridheight = 2;
        gbcManualJulia.fill = GridBagConstraints.BOTH;
        gbcManualJulia.weightx = 1;
        gbcManualJulia.weighty = 0;
        gbcManualJulia.anchor = GridBagConstraints.NORTH;
        gbManualJulia.setConstraints(btnConfirm, gbcManualJulia);
        jpanel1.add(btnConfirm);

        txtRe = new JTextField();
        txtRe.setToolTipText("Real Value for Juliaset");
        gbcManualJulia.gridx = 6;
        gbcManualJulia.gridy = 12;
        gbcManualJulia.gridwidth = 1;
        gbcManualJulia.gridheight = 1;
        gbcManualJulia.fill = GridBagConstraints.BOTH;
        gbcManualJulia.weightx = 1;
        gbcManualJulia.weighty = 0;
        gbcManualJulia.anchor = GridBagConstraints.NORTHWEST;
        gbManualJulia.setConstraints(txtRe, gbcManualJulia);
        jpanel1.add(txtRe);

        txtIm = new JTextField();
        txtIm.setToolTipText("Imaginary Value for Juliaset");
        gbcManualJulia.gridx = 14;
        gbcManualJulia.gridy = 12;
        gbcManualJulia.gridwidth = 1;
        gbcManualJulia.gridheight = 1;
        gbcManualJulia.fill = GridBagConstraints.BOTH;
        gbcManualJulia.weightx = 1;
        gbcManualJulia.weighty = 0;
        gbcManualJulia.anchor = GridBagConstraints.NORTH;
        gbManualJulia.setConstraints(txtIm, gbcManualJulia);
        jpanel1.add(txtIm);

        lblRe = new JLabel("Real Value:");
        gbcManualJulia.gridx = 5;
        gbcManualJulia.gridy = 12;
        gbcManualJulia.gridwidth = 1;
        gbcManualJulia.gridheight = 1;
        gbcManualJulia.fill = GridBagConstraints.BOTH;
        gbcManualJulia.weightx = 1;
        gbcManualJulia.weighty = 1;
        gbcManualJulia.anchor = GridBagConstraints.NORTH;
        gbManualJulia.setConstraints(lblRe, gbcManualJulia);
        jpanel1.add(lblRe);

        lblIm = new JLabel("Imaginary Value:");
        gbcManualJulia.gridx = 13;
        gbcManualJulia.gridy = 12;
        gbcManualJulia.gridwidth = 1;
        gbcManualJulia.gridheight = 1;
        gbcManualJulia.fill = GridBagConstraints.BOTH;
        gbcManualJulia.weightx = 1;
        gbcManualJulia.weighty = 1;
        gbcManualJulia.anchor = GridBagConstraints.NORTHEAST;
        gbManualJulia.setConstraints(lblIm, gbcManualJulia);
        jpanel1.add(lblIm);

        lblTitle = new JLabel("Manual Juliaset Calculator");
        gbcManualJulia.gridx = 5;
        gbcManualJulia.gridy = 3;
        gbcManualJulia.gridwidth = 10;
        gbcManualJulia.gridheight = 1;
        gbcManualJulia.fill = GridBagConstraints.VERTICAL;
        gbcManualJulia.weightx = 1;
        gbcManualJulia.weighty = 1;
        gbcManualJulia.anchor = GridBagConstraints.NORTH;
        gbManualJulia.setConstraints(lblTitle, gbcManualJulia);
        jpanel1.add(lblTitle);

        lblSpacer = new JLabel("Spacer Is here");
        lblSpacer.setForeground(new Color(240, 240, 240));
        gbcManualJulia.gridx = 7;
        gbcManualJulia.gridy = 12;
        gbcManualJulia.gridwidth = 6;
        gbcManualJulia.gridheight = 1;
        gbcManualJulia.fill = GridBagConstraints.BOTH;
        gbcManualJulia.weightx = 1;
        gbcManualJulia.weighty = 1;
        gbcManualJulia.anchor = GridBagConstraints.NORTH;
        gbManualJulia.setConstraints(lblSpacer, gbcManualJulia);
        jpanel1.add(lblSpacer);

        mJuliaWindow.add(jpanel1);
        mJuliaWindow.pack();
        mJuliaWindow.setBounds(0, 0, 800, mJuliaWindow.getHeight());
        mJuliaWindow.setLocationRelativeTo(null);
        mJuliaWindow.setVisible(true);
        mJulia = true;
    }

    private void saveItems() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnConfirm) {
            double re, im;
            re = Double.valueOf(txtRe.getText());
            im = Double.valueOf(txtIm.getText());
            mJImage = new MyImage(width, height, MyImage.TYPE_INT_RGB);
            mJImage.Plot(-2.0, 2.0, 2.0, -2.0);
            Calculator calc = new Calculator(mJImage, 200);
            juliaFrame(calc.juliaSet(re, im));
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'j') {
            manualJulia();
        }
        if (e.getKeyChar() == 's') {
            //Save Function
            try {
                File output = new File("saved.png");
                ImageIO.write(jImage, "png", output);
                System.out.println("Saved!");
            } catch (IOException j) {
                System.out.println("Oof");
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        xx = e.getX();
        yy = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        double StartX, StartY, EndX, EndY, re, im;
        if (xx == e.getX() || yy == e.getY()) {
            jImage = new MyImage(width, height, MyImage.TYPE_INT_RGB);
            jImage.Plot(-2.0, 2.0, 2.0, -2.0);
            re = jImage.convertX(xx);
            im = jImage.convertY(yy);
            Calculator calc = new Calculator(jImage, 200);
            //juliaFrame(calc.juliaSet(re, im));
        } else {
            StartX = mandelImage.convertX(xx);
            StartY = mandelImage.convertY(yy);
            EndX = mandelImage.convertX(e.getX());
            EndY = mandelImage.convertY(e.getY());
            mandelImage.Plot(StartX, StartY, EndX, EndY);
            Calculator calc = new Calculator(mandelImage, 200);
            mandelLabel.setIcon(new ImageIcon(calc.mandelBrot()));
            repaint();
        }

    }

    //region NotAbstractClass
    @Override
    public void mouseClicked(MouseEvent e) {

    }


    @Override
    public void mouseEntered(MouseEvent e) {
        //When the mouse enters the JFrame
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //When the mouse leaves the JFrame
        //System.out.println("Help");
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (e.getSource() == juliaWindow) {
            julia = false;
        }
        if (e.getSource() == mJuliaWindow) {
            mJulia = false;
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
    //endregion
}
