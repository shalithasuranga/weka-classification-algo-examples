/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataminingproject;

import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

/**
 *
 * @author Shalitha Suranga
 */
public class NaiveBayesAlgo {
    public static void main(String[] args) {
        String path = "nursery.arff";
        Instances ins;
        NaiveBayes nb = new NaiveBayes();
        
        try {
            ins = ConverterUtils.DataSource.read(path);
            ins.setClassIndex(ins.numAttributes() - 1 );
            nb.buildClassifier(ins);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(nb);
    }
    
}
