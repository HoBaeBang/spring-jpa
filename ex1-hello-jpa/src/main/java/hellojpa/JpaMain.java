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


//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            em.detach(member);
//            System.out.println("=== BEFORE ===");
//
//            Member member1 = em.find(Member.class, 101L);
//            Member member2 = em.find(Member.class, 101L);

//            System.out.println("member.getId() = " + member.getId());
//            System.out.println("member.getName() = " + member.getName());

//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "A");

//            em.persist(member1);
//            em.persist(member2);

            Member member = em.find(Member.class, 150L);
            member.setName("AAAAA");
//            Member member = new Member(200L, "member200");
//            em.persist(member);
//            em.flush(); //db에 바뀐내용을 적용

//            em.detach(member);
//            em.clear();
//            em.close();
            System.out.println("==================");
            tx.commit();
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
