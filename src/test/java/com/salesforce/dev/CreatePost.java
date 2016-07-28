package com.salesforce.dev;

import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Chatter.ChatterHome;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Home.LoginPage;
import com.salesforce.dev.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Monica Pardo on 6/13/2015.
 *
 */
public class CreatePost {

    String post = "Post test";
    String comment = "new comment";

    HomePage homePage;
    MainPage mainPage;
    NavigationBar navigationBar;
    ChatterHome chatterHome;

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp(){
        mainPage = LoginPage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();

    }
    @Test(groups = {"Acceptance"})
    public void CreatePostAndComment(){

        chatterHome = navigationBar.goToChatterHome();
        chatterHome.clickPost();
        chatterHome.setPost(post);
        chatterHome.clickShareBtn();
        Assert.assertTrue(chatterHome.VerifyPostCreated(post), "Post Was not Created");
        chatterHome.clickCommentForPost(post);
        chatterHome.setComment(comment);
        chatterHome.clickCommentBtn();
        Assert.assertTrue(chatterHome.VerifyCommentCreated(comment), "Comment Was not Created");




    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown(){
        chatterHome.DeletePost();
    }

}
