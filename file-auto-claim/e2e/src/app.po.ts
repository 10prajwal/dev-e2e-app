import { browser, by, element, ElementFinder } from "protractor";

export class AppPage {
  async navigateTo(): Promise<unknown> {
    return browser.get(browser.baseUrl);
  }

  getFullName(): ElementFinder {
    return element(by.formControlName("fullName"));
  }

  getEmail(): ElementFinder {
    return element(by.formControlName("email"));
  }

  getAccidentDateTime(): ElementFinder {
    return element(by.formControlName("accidentDateTime"));
  }

  public getTestId(testId: string): string {
    return `[data-test-id="${testId}"]`;
  }
}
