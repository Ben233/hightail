/*
 * ProblemJPanel.java
 *
 * Created on 2011-02-17, 23:13:02
 */

package org.hightail.ui;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.hightail.Config;
import org.hightail.KeyboardShortcuts;
import org.hightail.Problem;
import org.hightail.Testcase;
import org.hightail.TestcaseSet;
import org.hightail.util.TestingListener;

public class ProblemJPanel extends javax.swing.JPanel implements TestingListener {
    
    protected Problem problem;
    protected JFrame parentWindow; // used as parent for modal dialogs
    protected boolean isTesting; // are the tests running now
    private TestTableModel testTableModel; // used to notify testTable about the testcaseSet changes

    /** Creates new form ProblemJPanel */
    public ProblemJPanel(Problem problem, JTabbedPane tabbedPane, JFrame parentWindow) {
        this.problem = problem;
        this.testTableModel = new TestTableModel(problem.getTestcaseSet());
        this.parentWindow = parentWindow;
        this.isTesting = false;
        
        initComponents();
        
        makeShortcuts();
        
        ListSelectionListener listSelectionListener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                boolean enable = !(testTable.getSelectionModel().isSelectionEmpty() || isTesting);
                editTestcaseButton.setEnabled(enable);
                deleteTestcaseButton.setEnabled(enable);
                copyInputButton.setEnabled(true);
            }
        };
        testTable.getSelectionModel().addListSelectionListener(listSelectionListener);
        
        sourceFile.setText(problem.getPathToExec());
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        testcasePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        testTable = new javax.swing.JTable();
        testTable.setDefaultRenderer(String.class, new MultilineTableCellRenderer());
        newTestcaseButton = new javax.swing.JButton();
        editTestcaseButton = new javax.swing.JButton();
        deleteTestcaseButton = new javax.swing.JButton();
        runTestsButton = new javax.swing.JButton();
        abortAllTestsButton = new javax.swing.JButton();
        copyInputButton = new javax.swing.JButton();
        abortCurrentTestButton = new javax.swing.JButton();
        saveTestsButton = new javax.swing.JButton();
        openContainingDirectoryButton = new javax.swing.JButton();
        executableFileLabel = new javax.swing.JLabel();
        sourceFile = new javax.swing.JTextField();

        testcasePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Test cases"));

        testTable.setModel(testTableModel);
        testTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                testTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(testTable);

        newTestcaseButton.setText("<html><center>New<br />test case</center></html");
        newTestcaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newTestcaseButtonActionPerformed(evt);
            }
        });

        editTestcaseButton.setText("Edit");
        editTestcaseButton.setEnabled(false);
        editTestcaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTestcaseButtonActionPerformed(evt);
            }
        });

        deleteTestcaseButton.setText("<html><center>Delete<br />test case</center></html>");
        deleteTestcaseButton.setEnabled(false);
        deleteTestcaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTestcaseButtonActionPerformed(evt);
            }
        });

        runTestsButton.setText("<html><center>Run<br />tests</center></html>");
        runTestsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runTestsButtonActionPerformed(evt);
            }
        });

        abortAllTestsButton.setText("<html><center>Abort<br />all</center></html>");
        abortAllTestsButton.setEnabled(false);
        abortAllTestsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abortAllTestsButtonActionPerformed(evt);
            }
        });

        copyInputButton.setText("<html><center>Copy<br />input</center></html>");
        copyInputButton.setEnabled(false);
        copyInputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyInputButtonActionPerformed(evt);
            }
        });

        abortCurrentTestButton.setText("<html><center>Abort<br />current</center></html>");
        abortCurrentTestButton.setEnabled(false);
        abortCurrentTestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abortCurrentTestButtonActionPerformed(evt);
            }
        });

        saveTestsButton.setText("<html><center>Save<br />tests</center></html>");
        saveTestsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveTestsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout testcasePanelLayout = new javax.swing.GroupLayout(testcasePanel);
        testcasePanel.setLayout(testcasePanelLayout);
        testcasePanelLayout.setHorizontalGroup(
            testcasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testcasePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newTestcaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editTestcaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteTestcaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(copyInputButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveTestsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                .addComponent(runTestsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(abortCurrentTestButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(abortAllTestsButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        testcasePanelLayout.setVerticalGroup(
            testcasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, testcasePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(testcasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(saveTestsButton)
                    .addComponent(copyInputButton)
                    .addComponent(deleteTestcaseButton)
                    .addComponent(editTestcaseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newTestcaseButton)
                    .addComponent(abortCurrentTestButton)
                    .addComponent(runTestsButton)
                    .addComponent(abortAllTestsButton)))
        );

        openContainingDirectoryButton.setText("Browse...");
        openContainingDirectoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openContainingDirectoryButtonActionPerformed(evt);
            }
        });

        executableFileLabel.setText("Path to executable file:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(testcasePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(executableFileLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sourceFile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(openContainingDirectoryButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(executableFileLabel)
                    .addComponent(sourceFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(openContainingDirectoryButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(testcasePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void makeShortcuts() {
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyboardShortcuts.getShortcut("run tests"), "run tests");
        getActionMap().put("run tests", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runTests();
            }
        });
        
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyboardShortcuts.getShortcut("save tests"), "save tests");
        getActionMap().put("save tests", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveTests();
            }
        });
        
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyboardShortcuts.getShortcut("new testcase"), "new testcase");
        getActionMap().put("new testcase", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newTestcase();
            }
        });
        
        AbstractAction copyInputAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                copyInput();
            }
        };
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyboardShortcuts.getShortcut("copy input"), "copy input");
        getActionMap().put("copy input", copyInputAction);
        testTable.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyboardShortcuts.getShortcut("copy input"), "copy input");
        testTable.getActionMap().put("copy input", copyInputAction);
        // both of these are needed: the second one gets invoked if the row/table has focus, while the first one gets invoked
        // when something else has focus (it's possible that no row is selected or even exists; in that case we do nothing)
        // (and to have a Ctrl+C shortcut, we needed to override JTable's default behaviour for Ctrl+C)
        
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyboardShortcuts.getShortcut("abort tests"), "abort tests");
        getActionMap().put("abort tests", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abortAllTests();
            }
        });
        
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyboardShortcuts.getShortcut("abort current test"), "abort current test");
        getActionMap().put("abort current test", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abortCurrentTest();
            }
        });
        
        testTable.getInputMap().put(KeyboardShortcuts.getShortcut("abort tests"), "abort tests");
        testTable.getActionMap().put("abort tests", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abortAllTests();
            }
        });
        
        testTable.getInputMap().put(KeyboardShortcuts.getShortcut("abort current test"), "abort current test");
        testTable.getActionMap().put("abort current test", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abortCurrentTest();
            }
        });
        // delete key for delete testcase
        testTable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "delete testcase");
        testTable.getActionMap().put("delete testcase", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteTestcase();
            }
        });
        // enter for edit current testcase
        testTable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "edit testcase");
        testTable.getActionMap().put("edit testcase", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editCurrentTestcase();
            }
        });
    }
    
    private void newTestcase() {
        if (isTesting) {
            return;
        }
        Testcase newTestcase = new Testcase();
        TestcaseJDialog dialog = new TestcaseJDialog(parentWindow, newTestcase, true);
        dialog.setVisible(true); // this is modal; it will block until window is closed
        if (dialog.getReturnValue()) {
            // we need to add the newTestcase
            problem.addTestcase(newTestcase);
            testTableModel.rowInserted();
        }
    }
    
    private void newTestcaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newTestcaseButtonActionPerformed
        newTestcase();
    }//GEN-LAST:event_newTestcaseButtonActionPerformed
    
    private void editTestcaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTestcaseButtonActionPerformed
        editCurrentTestcase();
    }//GEN-LAST:event_editTestcaseButtonActionPerformed
    
    private void editCurrentTestcase() {
        if (isTesting) {
            return;
        }
        int selectedRow = testTable.getSelectedRow();
        if (selectedRow == -1) {
            throw new UnsupportedOperationException("Implementation error: edit button clicked, but no row selected");
        }
        Testcase editedTestcase = problem.getTestcase(selectedRow);
        TestcaseJDialog dialog = new TestcaseJDialog(parentWindow, editedTestcase, false);
        dialog.setVisible(true); // this is modal; it will block until window is closed
        if (dialog.getReturnValue()) {
            // the test case was edited
            testTableModel.rowUpdated(selectedRow);
        }
    }
    
    private void deleteTestcase() {
        if (isTesting) {
            return;
        }
        int selectedRow = testTable.getSelectedRow();
        if (selectedRow == -1) {
            throw new UnsupportedOperationException("Implementation error: delete button clicked, but no row selected");
        }
        // display confirm dialog
        int confirmed = JOptionPane.showConfirmDialog(this, "Are you sure?", "Confirm delete", JOptionPane.YES_NO_OPTION);
        
        if (confirmed == JOptionPane.YES_OPTION) {
            // we need to delete
            problem.deleteTestcase(selectedRow);
            testTableModel.rowDeleted(selectedRow);
            copyInputButton.setEnabled(false);
        }
    }
    
    private void deleteTestcaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTestcaseButtonActionPerformed
        deleteTestcase();
    }//GEN-LAST:event_deleteTestcaseButtonActionPerformed
    
    private void setEnabledOnInvasiveButtons(boolean state) {
        runTestsButton.setEnabled(state);
        newTestcaseButton.setEnabled(state);
        boolean isTestcaseSelected = !testTable.getSelectionModel().isSelectionEmpty();
        editTestcaseButton.setEnabled(isTestcaseSelected);
        deleteTestcaseButton.setEnabled(isTestcaseSelected);
        copyInputButton.setEnabled(isTestcaseSelected);
    }
    
    protected void runTests() {
        if (isTesting) {
            return;
        }
        final String pathToExecFile = sourceFile.getText();
        File execFile = new File(pathToExecFile);
        if (!execFile.exists()) {
            // executable file does not exist
            JOptionPane.showMessageDialog(this, "Executable file does not exist.", "Wrong file", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (execFile.isDirectory()) {
            // file path points to a directory, not a file
            JOptionPane.showMessageDialog(this, "Selected path to executable is a directory.", "Wrong file", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!Config.isPrependingCommandNonempty() && !execFile.canExecute()) {
            // application cannot execute this file
            JOptionPane.showMessageDialog(this, "Executable file cannot be executed.", "Wrong file", JOptionPane.ERROR_MESSAGE);
            return;
        } // TODO: if Config.isPrependingCommandNonempty(), then do this check for the prepending command itself
        if (problem.getTestcaseSet().isEmpty()) {
            // no tests
            JOptionPane.showMessageDialog(this, "No tests to run.", "No tests", JOptionPane.ERROR_MESSAGE);
            return;
        }
        problem.emptyResultsOfAllTestcases();
        testTableModel.fireTableDataChanged();
        testTableModel.setTemporaryIndexesForTestcases();
        setEnabledOnInvasiveButtons(false);
        isTesting = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                problem.runTests(ProblemJPanel.this, pathToExecFile);
            }
        }).start();
        abortAllTestsButton.setEnabled(true);
        abortCurrentTestButton.setEnabled(true);
        // now tests are running, they will call notifyResultsOfSingleTestcase and notifyEndOfTesting
    }
    
    private void runTestsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runTestsButtonActionPerformed
        runTests();
    }//GEN-LAST:event_runTestsButtonActionPerformed
    
    private void abortAllTests() {
        if (!isTesting) {
            return;
        }
        problem.abortAllTests();
    }
    
    private void abortAllTestsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abortAllTestsButtonActionPerformed
        abortAllTests();
    }//GEN-LAST:event_abortAllTestsButtonActionPerformed
    
    private void openContainingDirectoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openContainingDirectoryButtonActionPerformed
        File currentDirectory = new File(sourceFile.getText());
        if (!currentDirectory.isDirectory()) {
            currentDirectory = currentDirectory.getParentFile();
        }
        // the dialog will open the current selected directory if it's correct or home directory otherwise
        JFileChooser fc = new JFileChooser(currentDirectory);
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String filePath = fc.getSelectedFile().getAbsolutePath();
            sourceFile.setText(filePath);
        }
    }//GEN-LAST:event_openContainingDirectoryButtonActionPerformed
    
    private void testTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_testTableMouseClicked
        if (evt.getClickCount() == 2) { // double-click
            editCurrentTestcase();
        }
    }//GEN-LAST:event_testTableMouseClicked

    private void copyInput() {
        if (isTesting) {
            return;
        }
        int selectedRow = testTable.getSelectedRow();
        if (selectedRow == -1) {
            return; // this is possible if keyboard shortcut was pressed but no row is selected (maybe no row even exists)
        }
        Testcase testcase = problem.getTestcase(selectedRow);
        StringSelection strSel = new StringSelection(testcase.getInput());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(strSel, null);
    }
    
    private void copyInputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyInputButtonActionPerformed
        copyInput();
    }//GEN-LAST:event_copyInputButtonActionPerformed

    private void abortCurrentTest() {
        if (!isTesting) {
            return;
        }
        problem.abortCurrentTest();
    }
    
    private void abortCurrentTestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abortCurrentTestButtonActionPerformed
        abortCurrentTest();
    }//GEN-LAST:event_abortCurrentTestButtonActionPerformed

    private void saveTests() {
        TestcaseSet tests = problem.getTestcaseSet();
        PrintWriter writer;
        int testIndex = 1;
        String problemDirectory = new File(problem.getPathToExec()).getParent() + java.io.File.separator;
        for (Testcase test : tests) {
            try {
                writer = new PrintWriter(problemDirectory + testIndex + ".in", "UTF-8");
                writer.println(test.getInput());
                writer.close();
                
                writer = new PrintWriter(problemDirectory + testIndex + ".out", "UTF-8");
                writer.println(test.getExpectedOutput());
                writer.close();
            } catch (FileNotFoundException | UnsupportedEncodingException ex) {
                JOptionPane.showMessageDialog(this, "Error while saving inputs/outputs.\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
//                Logger.getLogger(ProblemJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            testIndex++;
        }
        JOptionPane.showMessageDialog(this, "Inputs and outputs saved succesfully.", "Tests saved", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void saveTestsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveTestsButtonActionPerformed
        saveTests();
    }//GEN-LAST:event_saveTestsButtonActionPerformed
    
    @Override
    public void notifyResultsOfSingleTestcase (int index) {
        // Testcase object is already updated by now
        testTableModel.fireTableRowsUpdated(index, index);
    }
    
    @Override
    public void notifyEndOfTesting () {
        abortAllTestsButton.setEnabled(false);
        abortCurrentTestButton.setEnabled(false);
        // TODO: report the main result of testing (all OK => OK, etc.)
        setEnabledOnInvasiveButtons(true);
        isTesting = false;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abortAllTestsButton;
    private javax.swing.JButton abortCurrentTestButton;
    private javax.swing.JButton copyInputButton;
    private javax.swing.JButton deleteTestcaseButton;
    private javax.swing.JButton editTestcaseButton;
    private javax.swing.JLabel executableFileLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newTestcaseButton;
    private javax.swing.JButton openContainingDirectoryButton;
    private javax.swing.JButton runTestsButton;
    private javax.swing.JButton saveTestsButton;
    private javax.swing.JTextField sourceFile;
    private javax.swing.JTable testTable;
    private javax.swing.JPanel testcasePanel;
    // End of variables declaration//GEN-END:variables
    
}
