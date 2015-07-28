package org.lgn.recommend.stars.test;

import java.io.IOException;
import java.util.Properties;

import org.lgn.recommend.common.Constants;
import org.lgn.recommend.common.DataSet;
import org.lgn.recommend.common.Evaluator;
import org.lgn.recommend.common.Model;
import org.lgn.recommend.stars.model.SimpleFactorizationModel2;

@Deprecated
public class TestSimpleModel2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DataSet traindata = new DataSet.MemDataSet("e:/data/ml-10m/ml-10M100K/ratings.dat.train");
		Model model = new SimpleFactorizationModel2();
		Properties prop = new Properties();
		prop.setProperty(Constants.LOOPS, "15");
		prop.setProperty(Constants.FACTOR, "200");
		model.setProperties(prop);
		model.loadData(traindata);
		model.train();
		DataSet testdata = new DataSet.MemDataSet("e:/data/ml-10m/ml-10M100K/ratings.dat.test");
		System.out.println("RMSE:  " + Evaluator.calculateRMSE1(testdata, model));
	}

}
