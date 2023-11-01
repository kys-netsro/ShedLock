package net.javacrumbs.shedlock.provider.redis.quarkus;

import io.quarkus.redis.datasource.RedisDataSource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import net.javacrumbs.shedlock.core.LockProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class SchedulerLockFactory {

    @ConfigProperty(name = "quarkus.application.name")
    String app;

    @Produces
    @Singleton
    public LockProvider lockProvider(RedisDataSource redisDataSource) {

        return new QuarkusRedisLockProvider(redisDataSource, "job-lock:" + app);
    }
}
