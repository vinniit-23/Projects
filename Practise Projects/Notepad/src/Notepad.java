import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.*;

public class Notepad extends JFrame implements ActionListener {
    JTextArea area;
    StringBuilder text;

    Notepad(){
        setTitle("Notepad");

        ImageIcon notepadIcon = new ImageIcon(ClassLoader.getSystemResource("icons/notepad.png"));
        Image icon = notepadIcon.getImage();
        setIconImage(icon);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.white);

        JMenu file = new JMenu("File");
        file.setFont(new Font("AERIAL", Font.PLAIN,14));

        JMenuItem newDoc = new JMenuItem("New");
        newDoc.addActionListener(this);
        newDoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));

        JMenuItem open = new JMenuItem("Open");
        open.addActionListener(this);
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));

        JMenuItem save = new JMenuItem("Save");
        save.addActionListener(this);
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));

        JMenuItem print = new JMenuItem("Print");
        print.addActionListener(this);
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));

        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(this);
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, InputEvent.CTRL_MASK));

        file.add(newDoc);
        file.add(open);
        file.add(save);
        file.add(print);
        file.add(exit);

        JMenu edit = new JMenu("Edit");
        edit.addActionListener(this);
        edit.setFont(new Font("AERIAL", Font.PLAIN,14));

        JMenuItem copy = new JMenuItem("Copy");
        copy.addActionListener(this);
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));

        JMenuItem paste = new JMenuItem("Paste");
        paste.addActionListener(this);
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));

        JMenuItem cut = new JMenuItem("Cut");
        cut.addActionListener(this);
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));

        JMenuItem selectAll = new JMenuItem("SelectAll");
        selectAll.addActionListener(this);
        selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));

        edit.add(copy);
        edit.add(paste);
        edit.add(cut);
        edit.add(selectAll);

        JMenu helpMenu = new JMenu("Help");
        helpMenu.setFont(new Font("AERIAL", Font.PLAIN,14));

        JMenuItem help = new JMenuItem("About");

        help.addActionListener(this);
        //help.setActionCommand("About");
        help.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_DOWN_MASK)); // Corrected

        helpMenu.add(help);

        JTextArea area = new JTextArea();
        area.setFont(new Font("SAN_SERIF", Font.PLAIN,18));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        add(area);

        JScrollPane pane = new JScrollPane(area);
        pane.setBorder(BorderFactory.createEmptyBorder());
        add(pane);


        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

        setExtendedState(JFrame.MAXIMIZED_BOTH);



      setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
      if (ae.getActionCommand().equals("New")) area.setText("");
      else if (ae.getActionCommand().equals("Open")) {

          /*this code only for .txt file in future I will update to all files and restrict some files to open why I am selecting
          * .txt (Because file extension like pdf doesn't support by notepad )
          * in future I have to improve code to support more file extensions*/

          JFileChooser chooser = new JFileChooser();
          chooser.setAcceptAllFileFilterUsed(false);
          FileNameExtensionFilter restrict = new FileNameExtensionFilter("only .txt files ","txt");
          chooser.addChoosableFileFilter(restrict);

          int action =chooser.showOpenDialog(this);
          if (action != JFileChooser.APPROVE_OPTION){
              return;
          }
          File file = chooser.getSelectedFile();
          try {
              BufferedReader reader = new BufferedReader(new FileReader(file));
              area.read(reader,null);




          } catch (Exception e) {
              e.getStackTrace();
          }


      } else if (ae.getActionCommand().equals("Save")) {
          JFileChooser saveAs = new JFileChooser();
          saveAs.setApproveButtonText("Save");

          int action =saveAs.showOpenDialog(this);
          if (action != JFileChooser.APPROVE_OPTION){
              return;
          }
          File fileName = new File(saveAs.getSelectedFile() + ".txt");
          BufferedWriter outFile = null;
          try {
              outFile = new BufferedWriter(new FileWriter(fileName));
              area.write(outFile);

          } catch (Exception e) {
              e.getStackTrace();
          }



      } else if (ae.getActionCommand().equals("Print")) {
          try {

              area.print();

          } catch (Exception e) {
              e.getStackTrace();
          }

      } else if (ae.getActionCommand().equals("Exit")) {

          System.exit(0);

      } else if (ae.getActionCommand().equals("Copy")) {

          text = new StringBuilder(area.getSelectedText());

      } else if (ae.getActionCommand().equals("Paste")) {
          area.insert(String.valueOf(text),area.getCaretPosition());


      } else if (ae.getActionCommand().equals("Cut")) {
          text = new StringBuilder(area.getSelectedText());
          area.replaceRange("",area.getSelectionStart(),area.getSelectionEnd());

      } else if (ae.getActionCommand().equals("SelectAll")) {
          area.selectAll();

      } else if (ae.getActionCommand().equals("About")) {
        new About().setVisible(true);

      }


    }

    public static void main(String[] args) {
      new Notepad();

    }
}