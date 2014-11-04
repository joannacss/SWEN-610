package edu.rit.se;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;
import java.util.Deque;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class MainWindow extends javax.swing.JFrame {

    private final int GRID_WIDTH = 9;
    private final int GRID_HEIGHT = 9;

    private Robot robot;

    private Deque<Command> stack;

    /**
     * Creates new form Labyrinth
     */
    public MainWindow() {

        initComponents();
        //initializes the Stack to be used to maintain a history of commands executed
        stack = new ArrayDeque<>();

        //initializes robot in the center
        robot = new Robot(GRID_WIDTH, GRID_HEIGHT);
        robot.updatePosition(GRID_WIDTH / 2, GRID_HEIGHT / 2);

        Command moveDown = new MoveDownCommand(robot);
        Command moveLeft = new MoveLeftCommand(robot);
        Command moveRight = new MoveRightCommand(robot);
        Command moveUp = new MoveUpCommand(robot);

        jButtonDown.addActionListener(new ButtonListener(moveDown));
        jButtonLeft.addActionListener(new ButtonListener(moveLeft));
        jButtonRight.addActionListener(new ButtonListener(moveRight));
        jButtonUp.addActionListener(new ButtonListener(moveUp));

        updateGrid();
    }

    private void updateGrid() {
        jPanelGrid.removeAll();
        jPanelGrid.setLayout(new GridBagLayout());
        System.out.println(robot.getX() + " , " + robot.getY());
        GridBagConstraints gbc = new GridBagConstraints();
        for (int row = 0; row < GRID_HEIGHT; row++) {
            for (int col = 0; col < GRID_WIDTH; col++) {
                gbc.gridx = col;
                gbc.gridy = row;
                JPanel cell = new JPanel();

                //Grid.CellPane cellPane = new TestGrid02.CellPane();
                Border border = null;
                if (row < GRID_HEIGHT - 1) {
                    if (col < GRID_WIDTH - 1) {
                        border = new MatteBorder(1, 1, 0, 0, Color.GRAY);
                    } else {
                        border = new MatteBorder(1, 1, 0, 1, Color.GRAY);
                    }
                } else {
                    if (col < 4) {
                        border = new MatteBorder(1, 1, 1, 0, Color.GRAY);
                    } else {
                        border = new MatteBorder(1, 1, 1, 1, Color.GRAY);
                    }
                }
                cell.setBorder(border);

                if (col == robot.getX() && (GRID_HEIGHT - 1 - row) == robot.getY()) {
                    cell.setBackground(Color.BLUE);
                } else {
                    cell.setBackground(Color.WHITE);
                }

                cell.setPreferredSize(new Dimension(50, 50));
                jPanelGrid.add(cell, gbc);
            }
        }
        jPanelGrid.repaint();
        revalidate();
    }

    private class ButtonListener implements ActionListener {

        private Command command;

        public ButtonListener(Command cmd) {
            this.command = cmd;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            System.out.println("Executing command " + ae.getActionCommand());
            command.execute();
            stack.push(command);
            updateGrid();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelGrid = new javax.swing.JPanel();
        jButtonRight = new javax.swing.JButton();
        jButtonDown = new javax.swing.JButton();
        jButtonUp = new javax.swing.JButton();
        jButtonLeft = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Robot Controller");

        jPanelGrid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanelGridLayout = new javax.swing.GroupLayout(jPanelGrid);
        jPanelGrid.setLayout(jPanelGridLayout);
        jPanelGridLayout.setHorizontalGroup(
            jPanelGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 465, Short.MAX_VALUE)
        );
        jPanelGridLayout.setVerticalGroup(
            jPanelGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 436, Short.MAX_VALUE)
        );

        jButtonRight.setText("→");

        jButtonDown.setText("↓");

        jButtonUp.setText("↑");

        jButtonLeft.setText("←");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonLeft)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonUp, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(jButtonDown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRight, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelGrid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonUp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonLeft)
                            .addComponent(jButtonRight))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDown)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDown;
    private javax.swing.JButton jButtonLeft;
    private javax.swing.JButton jButtonRight;
    private javax.swing.JButton jButtonUp;
    private javax.swing.JPanel jPanelGrid;
    // End of variables declaration//GEN-END:variables

}
