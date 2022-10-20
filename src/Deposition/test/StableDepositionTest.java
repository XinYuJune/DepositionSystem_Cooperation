package src.Deposition.test;

import org.junit.Assert;
import org.junit.Test;
import src.Deposition.StableDeposition;



/*
 *@Author:222401 Jun
 *Description:TODO
 *@DateTime: 2022/10/20-12:10
 **/
public class StableDepositionTest {
    StableDeposition stableDeposition=new StableDeposition();
    @Test
    public void getInterestStage() {
        Assert.assertEquals(0.0135,stableDeposition.getInterestStage(0),0.001);
        Assert.assertEquals(0.0155,stableDeposition.getInterestStage(1),0.001);
        Assert.assertEquals(0.0175,stableDeposition.getInterestStage(2),0.001);
        Assert.assertEquals(0.0225,stableDeposition.getInterestStage(3),0.001);
        Assert.assertEquals(0.0275,stableDeposition.getInterestStage(4),0.001);
    }

    @Test
    public void setInterest() {
        stableDeposition.setInterest(200,2);
        Assert.assertEquals(0.291,stableDeposition.getInterest(),0.001);
    }

    @Test
    public void getInterest() {
        stableDeposition.setInterest(400,2);
        Assert.assertEquals(stableDeposition.getInterest(),0.583,0.001);
    }

    @Test
    public void pMessage() {
        Assert.assertEquals("成功","成功");
    }

    @Test
    public void setDesProcess() {
        stableDeposition.setInterest(200, 0);
        Assert.assertEquals(0.225,stableDeposition.getInterest(),0.001);
    }

    @Test
    public void getInputTime() {
        stableDeposition.getDeadlineTime(1);
        Assert.assertEquals("APRIL",stableDeposition.getInputTime().getMonth().toString());

    }
}