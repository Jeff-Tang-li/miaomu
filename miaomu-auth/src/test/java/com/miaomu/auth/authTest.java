package com.miaomu.auth;

import com.miaomu.auth.service.IMiaomuUserService;
import jodd.util.ThreadUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Jeff·Tang
 * @version 1.0
 * @date 2021/1/26 9:52
 */
@SpringBootTest
public class authTest {
    @Autowired
    private IMiaomuUserService iMiaomuUserService;

    @Test
    void user() {
        Thread thread = new Thread(this::thread);
        thread.start();
        for (int i = 0; i <30 ; i++) {
            try {
                System.out.println(iMiaomuUserService.user(1)+"----------"+Thread.currentThread().getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void thread()  {
        for (int i = 0; i <30; i++) {
            try {
                System.out.println(iMiaomuUserService.user(1)+"----------"+Thread.currentThread().getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
