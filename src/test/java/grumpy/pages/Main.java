package grumpy.pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class Main {

  @Step
  public void open() {
    Selenide.open("/");
  }

  public void addPost() {
    $(".title_new").click();
  }

  public void editPost() {
    $(".post_meta_edit").click();
  }
}

