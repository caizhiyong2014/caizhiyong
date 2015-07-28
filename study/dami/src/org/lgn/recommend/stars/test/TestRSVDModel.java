package org.lgn.recommend.stars.test;

import java.util.Properties;

import org.lgn.recommend.common.Constants;
import org.lgn.recommend.common.DataSet;
import org.lgn.recommend.common.Evaluator;
import org.lgn.recommend.common.Model;
import org.lgn.recommend.stars.model.RSVDModel;;

public class TestRSVDModel {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DataSet traindata = new DataSet.MemDataSet("E://SVD//datasets//ul.base");
		Model model = new RSVDModel();
		Properties prop = new Properties();
		prop.setProperty(Constants.LOOPS, "15");
		prop.setProperty(Constants.FACTOR, "100");
		model.setProperties(prop);
		model.loadData(traindata);
		model.train();
		DataSet testdata = new DataSet.MemDataSet("D://workplace//datasets//ul.test");
		System.out.println("RMSE:  " + Evaluator.calculateRMSE1(testdata, model));
		System.out.println("MAE:"+ Evaluator.calculateMAE(testdata, model));

	}

}
