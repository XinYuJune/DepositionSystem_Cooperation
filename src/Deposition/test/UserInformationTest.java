package src.Deposition.test;

import org.junit.Assert;
import org.junit.Test;
import src.Deposition.UserInformation;



/*
 *@Author:222401 Jun
 *Description:TODO
 *@DateTime: 2022/10/20-12:10
 **/public class UserInformationTest {
    UserInformation userInformation=new UserInformation();
    @Test
    public void setUserName() {
        userInformation.setUserName("pj");
        Assert.assertEquals("pj",userInformation.getUserName());
    }

    @Test
    public void setAccount() {
        userInformation.setUserName("20224924");
        Assert.assertEquals(userInformation.getUserName(),"20224924");
    }

    @Test
    public void getUserName() {
        userInformation.setUserName("pj");
        Assert.assertEquals("pj",userInformation.getUserName());
    }

    @Test
    public void getAccount() {
        userInformation.setAccount(20224924);
        Assert.assertEquals(20224924,userInformation.getAccount());
    }

    @Test
    public void getWelcomeMessage() {
        System.out.println("hello!");
    }
}