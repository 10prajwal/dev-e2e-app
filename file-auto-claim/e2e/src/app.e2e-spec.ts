import { browser, by, element, logging } from "protractor";
import { AppPage } from "./app.po";

describe("workspace-project App", () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
    // adding formControlName as locator
    by.addLocator(
      "formControlName",
      function (
        value: string,
        opt_parentElement: Document,
        opt_rootSelector: any
      ) {
        var using = opt_parentElement || document;

        return using.querySelectorAll('[formControlName="' + value + '"]');
      }
    );
  });

  it("should not create claim when inputs are empty", async () => {
    await page.navigateTo();
    await element(by.css(page.getTestId("submit-claim"))).click();
    expect(await element(by.css(page.getTestId("error"))).getText()).toEqual(
      "Inputs are empty to create claim"
    );
  });

  it("should create claim", async () => {
    await page.navigateTo();

    // using form controls
    await page.getFullName().sendKeys("Prajwal");
    await page.getEmail().sendKeys("shetty10@gmail.com");
    await page.getAccidentDateTime().sendKeys("2021-10-01T02:45PM");

    await element(by.css(page.getTestId("submit-claim"))).click();

    expect(await element(by.css(page.getTestId("claim-id"))).getText()).toEqual(
      "11"
    );
    expect(await element(by.css(page.getTestId("name"))).getText()).toEqual(
      "Prajwal"
    );
  });
});

afterEach(async () => {
  // Assert that there are no errors emitted from the browser
  const logs = await browser.manage().logs().get(logging.Type.BROWSER);
  expect(logs).not.toContain(
    jasmine.objectContaining({
      level: logging.Level.SEVERE,
    } as logging.Entry)
  );
});
