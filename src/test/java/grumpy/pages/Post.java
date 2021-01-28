package grumpy.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.WebDriverRunner.url;
import static com.codeborne.selenide.Selenide.*;

public class Post {

  SelenideElement inputField = $(".input").find("textarea");

  public void addPost(String text) {
    inputField.setValue(text);
    new Helpers().button("Post");
  }

  public void deleteDraft(String text) {
    inputField.setValue(text);
    new Helpers().button("Delete draft");
  }

  public void editTo(String newText) {
    inputField.setValue(newText);
    new Helpers().button("Update");
  }

  public void delete() {
    String url = url();
    open(url + "/delete");
  }
}
