package org.qa.pages.pages;

import org.openqa.selenium.By;

public class SearchProductPage extends BasePage{
        private final By allCategoryDropdown = By.xpath("(//div[contains(@class,'dropdown')]//following-sibling::button[@type='button'])[1]");
        private final By dropdownOptions = By.xpath("//div[contains(@class,'dropdown-menu-left show')]//a[@class='dropdown-item']");
        private final By searchInput = By.xpath("//input[@name='search' and @data-autocomplete='5']");
        private final By searchButton = By.xpath("//button[text()='Search']");

        public void selectCategoryFromDropdown(){
                click(allCategoryDropdown);
                dropDownList(dropdownOptions);
        }

        public void searchForTheProduct(String searchText){
               type(searchInput, searchText);

        }

        public void clickOnSearchButton(){
                click(searchButton);
        }
}
