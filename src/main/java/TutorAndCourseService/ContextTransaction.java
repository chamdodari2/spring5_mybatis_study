package TutorAndCourseService;

import java.util.Collections;
import java.util.HashMap;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

@EnableAspectJAutoProxy //트랜잭션 위에 EnableAspectJAutoProx
@Configuration
public class ContextTransaction {
	@Autowired
	PlatformTransactionManager transactionManager;

	@Bean
	public TransactionInterceptor transactionAdvice() {
		NameMatchTransactionAttributeSource txAttributeSource = new NameMatchTransactionAttributeSource();
		RuleBasedTransactionAttribute txAttribute = new RuleBasedTransactionAttribute();
		txAttribute.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
		txAttribute.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		HashMap<String, TransactionAttribute> txAttributes = new HashMap<String, TransactionAttribute>();
		txAttributes.put("tr*", txAttribute);
		txAttributeSource.setNameMap(txAttributes);
		TransactionInterceptor txAdvice = new TransactionInterceptor();
		txAdvice.setTransactionManager(transactionManager);
		txAdvice.setTransactionAttributeSource(txAttributeSource);
		return txAdvice;
		//service에서 보면 tr로 되어있는데, 저 두개에 대해서 트랜잭션을 적용하겠다는 뜻이기 때문에 위의 service에서 @안해줘도 된다. 이게 aop??
		//트랜잭션 위에 EnableAspectJAutoProx
	}

	@Bean//제약을 둔다. 프로젝트명의 서비스주소! 그럼 해당위치에 적혀있는 두개에만 트랜잭션(?)만 적용되는것이다
	public Advisor transactionAdviceAdvisor() {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("execution(public * gradle_mybatis_spring_study.service..*Service.*(..))");
		return new DefaultPointcutAdvisor(pointcut, transactionAdvice());
	}
}