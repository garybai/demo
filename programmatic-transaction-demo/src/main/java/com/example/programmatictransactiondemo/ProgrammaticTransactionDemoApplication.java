package com.example.programmatictransactiondemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @description: TODO
 * @author Gary
 *
 * @date 2019-04-06 17:29
 */
@SpringBootApplication
@Slf4j
public class ProgrammaticTransactionDemoApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private TransactionTemplate transactionTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ProgrammaticTransactionDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("COUNT BEFORE TRANSACTION: {}", getCount());
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
				jdbcTemplate.execute("INSERT INTO FOO VALUES (1, 'AAA')");
				log.info("COUNT IN TRANSACTION: {}", getCount());
				transactionStatus.setRollbackOnly();
			}
		});
		log.info("COUNT AFTER TRANSACTION: {}", getCount());
	}

	private Long getCount(){
		return (Long) jdbcTemplate.queryForList("SELECT COUNT(*) CNT FROM FOO")
				.get(0).get("CNT");
	}
}
