package hellojpa;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("helloJPA");
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());
//            em.remove(findMember);
//            findMember.setName("helloJpaz");

//            List<Member> result = em.createQuery("select m from  Member as m", Member.class)
//                    .setFirstResult(1)
//                    .setMaxResults(8)
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.getName() = " + member.getName());
//            }


            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            em.detach(member);
            System.out.println("=== BEFORE ===");

            Member member1 = em.find(Member.class, 101L);
            Member member2 = em.find(Member.class, 101L);

//            System.out.println("member.getId() = " + member.getId());
//            System.out.println("member.getName() = " + member.getName());

            tx.commit();
//            em.persist(member);
        }
        catch (Exception e) {
            tx.rollback();
        }
        finally {
            em.close();
        }

        emf.close();
    }
}
