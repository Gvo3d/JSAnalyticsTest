import { Ng2bootPage } from './app.po';

describe('ng2boot App', () => {
  let page: Ng2bootPage;

  beforeEach(() => {
    page = new Ng2bootPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!');
  });
});
