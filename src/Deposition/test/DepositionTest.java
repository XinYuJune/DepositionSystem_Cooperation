package src.Deposition.test;

import org.junit.Assert;
import org.junit.Test;
import src.Deposition.Deposition;


/*
 *@Author:222401 Jun
 *Description:TODO
 *@DateTime: 2022/10/20-12:09
 **/
public class DepositionTest {
    Deposition deposition=new Deposition();


    @Test
    public void getCurrentBalance() {
        deposition.setCurrentBalance(200);
        Assert.assertEquals(200,deposition.getCurrentBalance(),0.001);
    }

    @Test
    public void setcurrentBalance() {
        deposition.setCurrentBalance(200);
        Assert.assertEquals(deposition.getCurrentBalance(),200,0.001);
    }

    @Test
    public void isLegalInputNum() {
        deposition.setCurrentBalance(300);
        Assert.assertTrue(deposition.isLegalInputNum(200));
        Assert.assertFalse(deposition.isLegalInputNum(-1));
        Assert.assertFalse(deposition.isLegalInputNum(500));
    }
}