import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.fabricadeprogramador.persistencia.dao.UsuarioDAOJPA;
import com.fabricadeprogramador.persistencia.entidade.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/springbeans.xml")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
public class TesteSpringContext {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(""
				+ "file:src/main/webapp/WEB-INF/springbeans.xml");
		
		//BasicDataSource dao = (BasicDataSource) context.getBean("dataSource");
		EntityManagerFactory emf =  (EntityManagerFactory)context.getBean("entityManagerFactory");
		
		EntityManager em = emf.createEntityManager();
		
		Usuario usu =  new Usuario();
		usu.setNome("Sifurrento");
		usu.setLogin("Sifu");
		usu.setSenha("46513");
		
		em.getTransaction().begin();
		em.persist(usu);
		em.getTransaction().commit();
		em.close();

	}

}
