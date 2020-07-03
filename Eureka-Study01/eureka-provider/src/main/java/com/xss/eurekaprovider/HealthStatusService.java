package com.xss.eurekaprovider;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Service;

/**
 * @ClassName HealthStatusService
 * @Description 健康状态修改-修改服务状态为down
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/7/1 2:48 下午
 * @Return
 */

@Service
public class HealthStatusService implements HealthIndicator {

    private Boolean status = true;

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status.toString();
    }

    @Override
    public Health health() {
        if(status)
            return new Health.Builder().up().build();
            return new Health.Builder().down().build();
    }
}
