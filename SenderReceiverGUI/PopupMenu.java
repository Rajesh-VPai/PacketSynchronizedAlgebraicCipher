/*
CC0 1.0 Universal (CC0 1.0) Public Domain Dedication

To the extent possible under law, the author(s) have dedicated all copyright
and related rights to this software to the public domain worldwide. This
software is distributed without any warranty.

You may copy, modify, distribute, and perform the work, even for commercial
purposes, all without asking permission.

For more information, see <https://creativecommons.org/publicdomain/zero/1.0/>
*/
/*
This is free and unencumbered software released into the public domain.

Anyone is free to copy, modify, publish, use, compile, sell, or distribute
this software, either in source code form or as a compiled binary, for any
purpose, commercial or non-commercial, and by any means.

In jurisdictions that recognize copyright laws, the author(s) dedicate any
and all copyright interest in the software to the public domain. We make
this dedication for the benefit of the public at large and to the detriment
of our heirs and successors. We intend this dedication to be an overt act
of relinquishment in perpetuity of all present and future rights to this
software under copyright law.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For more information, please refer to <https://unlicense.org/>
*/
/**
 *
 * @author Rajesh V Pai
 */
package SenderReceiverGUI;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;
import org.apache.log4j.Logger;

/**
 *
 * @author Rajesh V Pai
 */
public class PopupMenu extends JPopupMenu implements ActionListener {

    public static Logger log = Logger.getLogger(PopupMenu.class.getName());
    public static JMenuItem Cut, Copy, Paste, popExitItemMenu;
    //public static final JFrame f=new JFrame("Popup Menu Example");
    public static JFrame f= new JFrame("Basic GUI");
    
    public static JPopupMenu popupMenuTab = new JPopupMenu("Edit");
    private final JTextComponent target;
    public PopupMenu(JTextComponent target) {
    this.target = target;
    Cut = new JMenuItem("Cut");
    Copy = new JMenuItem("Copy");
    Paste = new JMenuItem("Paste");
    popExitItemMenu = new JMenuItem("Exit");

    Cut.addActionListener(this);
    Copy.addActionListener(this);
    Paste.addActionListener(this);
    popExitItemMenu.addActionListener(this);

    // Add items to *this* popup menu
    add(Cut);
    add(Copy);
    add(Paste);
    add(popExitItemMenu);
}

    @Override
public void actionPerformed(ActionEvent e) {
    //popupMenuTab.setVisible(true);
    if (e.getSource() == Cut) {
        String selection = target.getSelectedText();
        if (selection != null) {
            StringSelection clipString = new StringSelection(selection);
            Clipboard cboard = getToolkit().getSystemClipboard();
            cboard.setContents(clipString, clipString);
            target.replaceSelection(""); // Cut
        }
    } else if (e.getSource() == Copy) {
        String selection = target.getSelectedText();
        if (selection != null) {
            StringSelection clipString = new StringSelection(selection);
            Clipboard cboard = getToolkit().getSystemClipboard();
            cboard.setContents(clipString, clipString);
        }
    } else if (e.getSource() == Paste) {
        try {
            Clipboard cboard = getToolkit().getSystemClipboard();
            Transferable clipData = cboard.getContents(null);
            String clipString = (String) clipData.getTransferData(DataFlavor.stringFlavor);
            target.replaceSelection(clipString);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    } else if (e.getSource() == popExitItemMenu) {
        System.exit(0);
    }
}
}

