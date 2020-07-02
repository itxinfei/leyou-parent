import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.leyou.sms.LeyouSmsApplication;
import com.leyou.sms.utils.SmsUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = LeyouSmsApplication.class)
//@Import({LeyouSmsApplication.class})
public class SMSTest {


    @Autowired
    private SmsUtils smsUtils;

    @Test
    public void smsTest() throws ClientException {
        //SmsUtils.sendSms("15900846607", "测试验证码推送功能：8888", "心飞为你飞", "SMS_76525096");

       // SendSmsResponse sendSmsResponse = smsUtils.sendSms("15900846607", "测试验证码推送功能：8888", "心飞为你飞", "SMS_76525096");
       // System.out.println(sendSmsResponse);

    }

}
