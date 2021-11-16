package by.academy.it.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PayslipDaoTest extends BaseDbUnitTest {

    private PayslipDao payslipDao;

    @Before
    public void setUp() {
        payslipDao = new PayslipDao(sessionFactory);
    }


    @Test
    public void getAnnualSalary() {
        //Given
        cleanInsert("PayslipDaoTest.xml");

        //When
        BigDecimal res = payslipDao.getAnnualSalary("2c9682067d101492017d101495ed0000", (short) 2021);

        //Then
        assertEquals(new BigDecimal("24420.00"), res);
    }

    @After
    public void tearDown() {
        payslipDao = null;
        deleteDataset();
    }
}