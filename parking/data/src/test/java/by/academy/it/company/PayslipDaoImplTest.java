package by.academy.it.company;

import by.academy.it.TestDaoConfiguration;
import by.academy.it.dao.PayslipDao;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(classes = TestDaoConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class PayslipDaoImplTest extends BaseDbUnitTest {

    @Autowired
    Environment env;
    @Autowired
    private PayslipDao payslipDao;

    @Test
    public void getAnnualSalary() {
        System.out.println("company.url=" + env.getProperty("company.url"));

        //Given
        cleanInsert("/by/academy/it/company/PayslipDaoTest.xml");

        //When
        BigDecimal res = payslipDao.getAnnualSalary("2c9682067d101492017d101495ed0000", (short) 2021);

        //Then
        assertEquals(new BigDecimal("24420.00"), res);
    }

    @After
    public void tearDown() {
        payslipDao = null;
        //deleteDataset();
    }
}