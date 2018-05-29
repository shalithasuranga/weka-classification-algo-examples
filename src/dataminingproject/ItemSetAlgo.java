/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataminingproject;

import weka.associations.Apriori;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author Shalitha Suranga
 */
public class ItemSetAlgo {
    public static void main(String[] args) {
        Apriori model = new Apriori();
        String path = "nursery.arff";
        try {
            Instances data = DataSource.read(path);
            model.setNumRules(10);
            model.buildAssociations(data);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("======= Item set rules for weather dataset ====== \n");
        
        for(weka.associations.AssociationRule a : model.getAssociationRules().getRules()){
            System.out.println(a);
        }
    }
}
