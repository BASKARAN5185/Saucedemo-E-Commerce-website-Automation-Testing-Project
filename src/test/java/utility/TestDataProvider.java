package utility;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
    
    @DataProvider(name = "userData")
    public Object[][] provideLoginValidTestData() {
        return new Object[][] {
                { "standard_user@example.com", "secret_sauce" }, 
                { "locked_out_user@company.com", "secret_sauce" },
                { "problem_user@domain.com", "secret_sauce" },
                { "performance_glitch_user@service.com", "secret_sauce" },
                { "error_user@platform.com", "secret_sauce" },
                { "visual_user@domain.co", "secret_sauce" },
        };
    }

    @DataProvider(name = "userInvalidData")
    public Object[][] provideLoginInvalidTestData() {
        return new Object[][] {
                { "invalid_user@xyz.com", "secret_sauce" },
                { "standard_user@example.com", "wrong_password" },
                { "locked_out_user@company.com", "wrong_password" },
                { "problem_user@domain.com", "wrong_password" },
                { "performance_glitch_user@service.com", "wrong_password" },
                { "error_user@platform.com", "wrong_password" },
                { "visual_user@domain.co", "wrong_password" },
                { "", "secret_sauce" },
                { "standard_user@example.com", "" },
                { "", "" },
        };
    }
}