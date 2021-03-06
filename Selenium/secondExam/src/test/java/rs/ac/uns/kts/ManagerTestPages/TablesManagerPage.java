package rs.ac.uns.kts.ManagerTestPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import rs.ac.uns.kts.pages.AdminTestPages.Utilities;

public class TablesManagerPage {
    private WebDriver driver;

    public TablesManagerPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath = "//a[contains(text(),'Tables manager')]")
    private WebElement tables;

    @FindBy(xpath = "/html/body/app-root/html/body/restourant-tables/div/mat-sidenav-container/mat-sidenav/div/div[3]/button")
    private WebElement floor;

    @FindBy(xpath = "/html/body/app-root/html/body/restourant-tables/div/mat-sidenav-container/mat-sidenav-content/button[1]")
    private WebElement addTable;

    @FindBy(xpath = "/html/body/app-root/html/body/restourant-tables/div/mat-sidenav-container/mat-sidenav-content/div/div/p")
    private WebElement table;

    @FindBy(xpath = "/html/body/app-root/html/body/restourant-tables/div/mat-sidenav-container/mat-sidenav-content/button[3]")
    private WebElement deleteTable;

    public void tablesManagerLinkClick() {
        
        Utilities.clickableWait(driver, this.tables, 1000).click();
    }

    public void addTableLinkClick() {
        Utilities.clickableWait(driver, this.addTable, 1000).click();
    }

    public void choseTableLinkClick() {
        Utilities.clickableWait(driver, this.table, 1000).click();
    }

    public void choseFloorLinkClick() {
        Utilities.clickableWait(driver, this.floor, 1000).click();
    }

    public void deleteTableLinkClick() {
        Utilities.clickableWait(driver, this.deleteTable, 1000).click();
    }


}
