/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataminingproject;

import com.sun.xml.internal.ws.encoding.DataHandlerDataSource;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.classifiers.rules.OneR;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

/**
 *
 * @author Shalitha Suranga
 */
public class OneRAlgo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String path = "nursery.arff";
        Instances ins;
        OneR one = new OneR();
        
        try {
            ins = ConverterUtils.DataSource.read(path);
            ins.setClassIndex(ins.numAttributes() - 1 );
            one.buildClassifier(ins);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(one);
    }
    
}
