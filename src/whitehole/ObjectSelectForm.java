/*
    Copyright 2012 The Whitehole team

    This file is part of Whitehole.

    Whitehole is free software: you can redistribute it and/or modify it under
    the terms of the GNU General Public License as published by the Free
    Software Foundation, either version 3 of the License, or (at your option)
    any later version.

    Whitehole is distributed in the hope that it will be useful, but WITHOUT ANY 
    WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
    FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along 
    with Whitehole. If not, see http://www.gnu.org/licenses/.
*/

package whitehole;

import java.awt.Toolkit;
import java.util.*;
import java.util.Map.Entry;
import javax.swing.DefaultComboBoxModel;
import javax.swing.tree.*;
import whitehole.smg.ZoneArchive;

public class ObjectSelectForm extends javax.swing.JDialog
{
    /**
     * Creates new form ObjectSelectForm
     */
    public ObjectSelectForm(java.awt.Frame parent, int game, String selobj)
    {
        super(parent, true);
        initComponents();
        
        setIconImage(Toolkit.getDefaultToolkit().createImage(Whitehole.class.getResource("/Resources/icon.png")));
        
        this.game = game;
        this.selectedObject = selobj;
        
        if (selobj != null)
        {
            lblZone.setVisible(false);
            cbxZone.setVisible(false);
            lblLayer.setVisible(false);
            cbxLayer.setVisible(false);
            sepSelect.setVisible(false);
            
            selectedZone = "#lolz#";
            selectedLayer = "#lolz#";
        }
        else
        {
            GalaxyEditorForm gal_parent = (GalaxyEditorForm)parent;
            //if (!gal_parent.galaxyMode)
            {
                lblZone.setVisible(false);
                cbxZone.setVisible(false);
                lblLayer.setText("Add to layer: ");
                
                selectedZone = "#lolz#";
            }
            
            DefaultComboBoxModel layerlist = (DefaultComboBoxModel)cbxLayer.getModel();
            layerlist.addElement("Common");
            for (int l = 0; l < 26; l++)
            {
                String ls = String.format("Layer%1$c", 'A'+l);
                if (gal_parent.curZoneArc.objects.containsKey(ls.toLowerCase()))
                    layerlist.addElement(ls);
            }
            
            selectedLayer = "Common";
            cbxLayer.setSelectedItem(selectedLayer);
            
            selectedObject = "";
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

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tvObjectList = new javax.swing.JTree();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        epObjDescription = new javax.swing.JEditorPane();
        jToolBar2 = new javax.swing.JToolBar();
        lblZone = new javax.swing.JLabel();
        cbxZone = new javax.swing.JComboBox();
        lblLayer = new javax.swing.JLabel();
        cbxLayer = new javax.swing.JComboBox();
        sepSelect = new javax.swing.JToolBar.Separator();
        btnSelect = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Select object");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jSplitPane1.setDividerLocation(320);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setResizeWeight(1.0);
        jSplitPane1.setFocusable(false);
        jSplitPane1.setLastDividerLocation(320);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jLabel1.setText("Search: ");
        jLabel1.setToolTipText("");
        jToolBar1.add(jLabel1);

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        jToolBar1.add(txtSearch);

        jPanel1.add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        tvObjectList.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        tvObjectList.setShowsRootHandles(true);
        tvObjectList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tvObjectListMouseClicked(evt);
            }
        });
        tvObjectList.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                tvObjectListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(tvObjectList);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jSplitPane1.setTopComponent(jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        epObjDescription.setEditable(false);
        epObjDescription.setContentType("text/html"); // NOI18N
        jScrollPane3.setViewportView(epObjDescription);

        jPanel2.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        lblZone.setText("Add to zone: ");
        jToolBar2.add(lblZone);

        jToolBar2.add(cbxZone);

        lblLayer.setText(" Layer: ");
        jToolBar2.add(lblLayer);

        jToolBar2.add(cbxLayer);
        jToolBar2.add(sepSelect);

        btnSelect.setText("Select");
        btnSelect.setEnabled(false);
        btnSelect.setFocusable(false);
        btnSelect.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSelect.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });
        jToolBar2.add(btnSelect);

        jPanel2.add(jToolBar2, java.awt.BorderLayout.PAGE_END);

        jSplitPane1.setRightComponent(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowOpened
    {//GEN-HEADEREND:event_formWindowOpened
        DefaultTreeModel thelist = (DefaultTreeModel)tvObjectList.getModel();
        objList = new DefaultMutableTreeNode((ZoneArchive.gameMask == 2) ? "SMG2 objects" : "SMG1 objects");
        thelist.setRoot(objList);
        
        LinkedHashMap<Integer, DefaultMutableTreeNode> catlist = new LinkedHashMap<>(ObjectDB.categories.size());
        for (Entry<Integer, String> cat : ObjectDB.categories.entrySet())
        {
            DefaultMutableTreeNode tn = new DefaultMutableTreeNode(cat.getValue());
            catlist.put(cat.getKey(), tn);
        }
        
        LinkedHashMap<String, MyObjTreeNode> tempnodelist = new LinkedHashMap<>(ObjectDB.objects.size());
        for (ObjectDB.Object obj : ObjectDB.objects.values())
        {
            if ((obj.games & game) == 0) continue;
            
            DefaultMutableTreeNode tn = catlist.get(obj.category);
            MyObjTreeNode objnode = new MyObjTreeNode(obj.ID);
            tn.add(objnode);
            tempnodelist.put(obj.ID, objnode);
        }
        
        for (DefaultMutableTreeNode catnode : catlist.values())
        {
            if (catnode.getChildCount() == 0)
                continue;
            
            objList.add(catnode);
        }
        
        if (!selectedObject.isEmpty() && ObjectDB.objects.containsKey(selectedObject))
        {
            TreePath path = new TreePath(((DefaultTreeModel)tvObjectList.getModel()).getPathToRoot(tempnodelist.get(selectedObject)));
            tvObjectList.setSelectionPath(path);
            tvObjectList.scrollPathToVisible(path);
        }
        else
        {
            TreePath path = new TreePath(((DefaultTreeModel)tvObjectList.getModel()).getPathToRoot(objList.getChildAt(0)));
            tvObjectList.scrollPathToVisible(path);
        }
        
        searchList = new DefaultMutableTreeNode("Search results");
    }//GEN-LAST:event_formWindowOpened

    private void tvObjectListValueChanged(javax.swing.event.TreeSelectionEvent evt)//GEN-FIRST:event_tvObjectListValueChanged
    {//GEN-HEADEREND:event_tvObjectListValueChanged
        if (tvObjectList.getSelectionPath() == null)
        {
            epObjDescription.setText("");
            btnSelect.setEnabled(false);
            return;
        }
        
        MutableTreeNode tn = (MutableTreeNode)tvObjectList.getSelectionPath().getLastPathComponent();
        if (tn.getClass() != MyObjTreeNode.class)
        {
            epObjDescription.setText("");
            btnSelect.setEnabled(false);
            return;
        }
        
        ObjectDB.Object dbinfo = ObjectDB.objects.get(((MyObjTreeNode)tn).objectID);
        
        epObjDescription.setText(String.format(
                "<b>%1$s</b> (%2$s)<br><br>%3$s", 
                dbinfo.name, dbinfo.ID, dbinfo.notes));
        
        btnSelect.setEnabled(true);
    }//GEN-LAST:event_tvObjectListValueChanged

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSelectActionPerformed
    {//GEN-HEADEREND:event_btnSelectActionPerformed
        MutableTreeNode tn = (MutableTreeNode)tvObjectList.getSelectionPath().getLastPathComponent();
        if (tn.getClass() != MyObjTreeNode.class)
        {
            throw new NullPointerException("oops");
        }
        
        selectedObject = ((MyObjTreeNode)tn).objectID;
        if (!selectedZone.equals("#lolz#")) selectedZone = (String)cbxZone.getSelectedItem();
        if (!selectedLayer.equals("#lolz#")) selectedLayer = (String)cbxLayer.getSelectedItem();
        dispose();
    }//GEN-LAST:event_btnSelectActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txtSearchKeyReleased
    {//GEN-HEADEREND:event_txtSearchKeyReleased
        String search = txtSearch.getText().toLowerCase();
        if (search.isEmpty())
        {
            ((DefaultTreeModel)tvObjectList.getModel()).setRoot(objList);
        }
        else
        {
            searchList.removeAllChildren();
            for (ObjectDB.Object obj : ObjectDB.objects.values())
            {
                if ((obj.games & game) == 0) continue;
                if (!obj.ID.toLowerCase().contains(search) && !obj.name.toLowerCase().contains(search)) continue;

                MyObjTreeNode objnode = new MyObjTreeNode(obj.ID);
                searchList.add(objnode);
            }
            
            if (searchList.getChildCount() == 0)
                searchList.add(new DefaultMutableTreeNode("(no results)"));
            
            ((DefaultTreeModel)tvObjectList.getModel()).setRoot(searchList);
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void tvObjectListMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_tvObjectListMouseClicked
    {//GEN-HEADEREND:event_tvObjectListMouseClicked
        if (tvObjectList.getSelectionPath() == null)
            return;
        
        MutableTreeNode tn = (MutableTreeNode)tvObjectList.getSelectionPath().getLastPathComponent();
        if (tn.getClass() != MyObjTreeNode.class)
            return;
        
        if (evt.getClickCount() < 2)
            return;
        
        selectedObject = ((MyObjTreeNode)tn).objectID;
        dispose();
    }//GEN-LAST:event_tvObjectListMouseClicked

    
    public class MyObjTreeNode implements MutableTreeNode
    {
        public MyObjTreeNode(String objid)
        {
            this.parent = null;
            this.objectID = objid;
        }


        @Override
        public void insert(MutableTreeNode child, int index) {}
        @Override
        public void remove(int index) {}
        @Override
        public void remove(MutableTreeNode node) {}

        @Override
        public void setUserObject(Object object) {}

        @Override
        public void removeFromParent()
        {
            parent = null;
            System.out.println("[MyObjTreeNode] REMOVE FROM PARENT");
        }

        @Override
        public void setParent(MutableTreeNode newParent)
        {
            parent = newParent;
        }

        @Override
        public TreeNode getChildAt(int childIndex)
        {
            return null;
        }

        @Override
        public int getChildCount()
        {
            return 0;
        }

        @Override
        public TreeNode getParent()
        {
            return parent;
        }

        @Override
        public int getIndex(TreeNode node)
        {
            return -1;
        }

        @Override
        public boolean getAllowsChildren()
        {
            return false;
        }

        @Override
        public boolean isLeaf()
        {
            return true;
        }

        @Override
        public Enumeration children()
        {
            return null;
        }


        @Override
        public String toString()
        {
            ObjectDB.Object dbinfo = ObjectDB.objects.get(objectID);
            return dbinfo.name + " (" + dbinfo.ID + ")";
        }


        public TreeNode parent;
        public String objectID;
    }
    
    
    private int game;
    public String selectedObject, selectedZone, selectedLayer;
    private DefaultMutableTreeNode objList, searchList;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelect;
    private javax.swing.JComboBox cbxLayer;
    private javax.swing.JComboBox cbxZone;
    private javax.swing.JEditorPane epObjDescription;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel lblLayer;
    private javax.swing.JLabel lblZone;
    private javax.swing.JToolBar.Separator sepSelect;
    private javax.swing.JTree tvObjectList;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
