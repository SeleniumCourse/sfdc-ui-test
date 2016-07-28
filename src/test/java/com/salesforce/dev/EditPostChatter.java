package com.salesforce.dev;

import com.salesforce.dev.framework.DataDrivenManager;
import com.salesforce.dev.framework.Objects.Chatter;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Chatter.ChatterHome;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Home.LoginPage;
import com.salesforce.dev.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;

/**
 * Created by Veronica Prado on 9/3/2015.
 */
public class EditPostChatter {
    HomePage homePage;
    MainPage mainPage;
    NavigationBar navigationBar;
    ChatterHome chatterHome;

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp(){
        //create
        DataDrivenManager dataDrivenManager = new DataDrivenManager();
        Iterator<Chatter[]> chattersData = dataDrivenManager.getChatter("Chatter.json");
        Chatter createChatter = chattersData.next()[0];
        mainPage = LoginPage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
        chatterHome = navigationBar.goToChatterHome();
        chatterHome.clickPost();
        chatterHome.setPost(createChatter.getPost());
        chatterHome.clickShareBtn();
    }
    @DataProvider(name = "dataDriven")
    public Iterator<Chatter[]> getValues() {
        DataDrivenManager dataDrivenManager = new DataDrivenManager();
        return dataDrivenManager.getChatter("EditChatter.json");
    }

    @Test(groups = {"Acceptance"}, dataProvider ="dataDriven")
    public void CreatePostAndComment(Chatter chatter){
        System.out.println("va*erk:");
        chatterHome.editPost(chatter.getPost());
        Assert.assertTrue(chatterHome.VerifyPostCreated(chatter.getPost()), "Post has been not Updated");
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown(){
        chatterHome.DeletePost();
    }
}
