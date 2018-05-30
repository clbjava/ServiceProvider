package com.service.provider.config;

import java.util.concurrent.ThreadPoolExecutor;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.druid.pool.DruidDataSource;
import com.service.provider.comm.exception.SysException;

/**
 * 通用配置
 * 
 * @author CLb
 * @version 1.0.0
 */
/*@Configuration
@ComponentScan
@EnableTransactionManagement
@EnableScheduling
@EnableAsync
@EnableCaching*/
@SpringBootApplication
public class ProviderConfiguration extends WebMvcConfigurerAdapter {

    @Value("${threadpool.task.max-pool-size:8}")
    private int taskMaxPoolSize;

    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.user}")
    private String jdbcUser;

    @Value("${jdbc.initial-size}")
    private int jdbcInitialSize = 5;

    @Value("${jdbc.min-idle}")
    private int jdbcMinIdle;

    @Value("${jdbc.max-active}")
    private int jdbcMaxActive;

    @Value("${jdbc.max-wait}")
    private int jdbcMaxWait;

    @Value("${jdbc.time-between-eviction-runs-millis}")
    private int jdbcTimeBetweenEvictionRunsMillis;

    @Value("${jdbc.min-evictable-idle-time-millis}")
    private int jdbcMinEvictableIdleTimeMillis;

    @Value("${jdbc.validation-query}")
    private String jdbcValidationQuery;

    @Value("${jdbc.validation-query-timeout}")
    private int validationQueryTimeout = 2;

    @Value("${jdbc.test-while-idle:true}")
    private boolean jdbcTestWhileIdle = true;

    @Value("${jdbc.test-on-borrow:false}")
    private boolean jdbcTestOnBorrow = false;

    @Value("${jdbc.test-on-return:false}")
    private boolean jdbcTestOnReturn = false;

    @Value("${jdbc.prepared-statements:true}")
    private boolean jdbcPoolPreparedStatements = true;

    @Value("${jdbc.max-pool-prepared-statement-per-connection-size:20}")
    private int jdbcMaxPoolPreparedStatementPerConnectionSize = 20;

    @Value("${jdbc.filters:'stat'}")
    private String jdbcFilters = "stat";

	@Bean(name = "dataSource")
	public DataSource dataSource() {
		try {
			DruidDataSource ds = new DruidDataSource();
			ds.setUrl(jdbcUrl);
			ds.setUsername(jdbcUser);
			ds.setPassword(jdbcPassword);
			ds.setInitialSize(jdbcInitialSize);
			ds.setMinIdle(jdbcMinIdle);
			ds.setMaxActive(jdbcMaxActive);
			ds.setMaxWait(jdbcMaxWait);
			ds.setTimeBetweenEvictionRunsMillis(jdbcTimeBetweenEvictionRunsMillis);
			ds.setMinEvictableIdleTimeMillis(jdbcMinEvictableIdleTimeMillis);
			ds.setValidationQuery(jdbcValidationQuery);
			ds.setValidationQueryTimeout(validationQueryTimeout);
			ds.setTestWhileIdle(jdbcTestWhileIdle);
			ds.setTestOnBorrow(jdbcTestOnBorrow);
			ds.setTestOnReturn(jdbcTestOnReturn);
			ds.setPoolPreparedStatements(jdbcPoolPreparedStatements);
			ds.setMaxPoolPreparedStatementPerConnectionSize(jdbcMaxPoolPreparedStatementPerConnectionSize);
			ds.setFilters(jdbcFilters);
			return ds;
		} catch (Exception e) {
			throw new SysException("datasource construct failed", e);
		}
	}

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }
    
    @Bean(name = "taskScheduler")
    public ThreadPoolTaskScheduler setTaskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(taskMaxPoolSize);
        return scheduler;
    }

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory() {
		try {
			SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
			factory.setDataSource(dataSource());
			DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
			factory.setConfigLocation(resourceLoader.getResource("classpath:mybatis-config.xml"));
			PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
			Resource[] res = resolver.getResources("classpath:mapper/*.xml");
			factory.setMapperLocations(res);
			return factory.getObject();
		} catch (Exception e) {
			throw new SysException("sqlSessionFactory construct fail", e);
		}
	}
	
	@Bean(name = "servicesExecutor")
	public ThreadPoolTaskExecutor backendThreadPoolTaskExecutor(
			@Value("${core-pool-size:48}") int corePoolSize,
			@Value("${keep-alive-seconds:60}") int keepAliveSeconds,
			@Value("${max-pool-size:48}") int maxPoolSize,
			@Value("${queue-capacity:300}") int queueCapacity,
			@Value("${allow-core-thread-timeout:true}") boolean allowCoreThreadTimeOut,
			@Value("${await-termination-seconds:60}") int awaitTerminationSeconds,
			@Value("${wait-for-task-to-complete-on-shutdown:true}") boolean waitForTasksToCompleteOnShutdown) {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(corePoolSize);
		executor.setKeepAliveSeconds(keepAliveSeconds);
		executor.setMaxPoolSize(maxPoolSize);
		executor.setQueueCapacity(queueCapacity);
		executor.setAllowCoreThreadTimeOut(allowCoreThreadTimeOut);
		executor.setAwaitTerminationSeconds(awaitTerminationSeconds);
		executor.setWaitForTasksToCompleteOnShutdown(waitForTasksToCompleteOnShutdown);
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
		executor.setThreadNamePrefix("work-Executor-");
		return executor;
	}

}