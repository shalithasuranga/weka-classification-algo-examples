/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataminingproject;

import java.awt.BorderLayout;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;
import weka.gui.treevisualizer.PlaceNode2;
import weka.gui.treevisualizer.TreeVisualizer;

/**
 *
 * @author Shalitha Suranga
 */
public class DecisionTreeAlgo {
    public static void main(String[] args) throws Exception {
        // train classifier
        J48 cls = new J48();
        String path = "nursery.arff";
        Instances data = ConverterUtils.DataSource.read(path);
        cls.setUnpruned(false);
        data.setClassIndex(data.numAttributes() - 1);
        cls.buildClassifier(data);
        System.out.println(cls);

        // display classifier
        final javax.swing.JFrame jf = new javax.swing.JFrame("Weka Classifier Tree Visualizer: J48");
        jf.setSize(2600, 1000);
        jf.getContentPane().setLayout(new BorderLayout());
        TreeVisualizer tv = new TreeVisualizer(null,cls.graph(), new PlaceNode2());
        jf.getContentPane().add(tv, BorderLayout.CENTER);
        jf.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                jf.dispose();
            }
        });

        jf.setVisible(true);
        tv.fitToScreen();
    }
}
