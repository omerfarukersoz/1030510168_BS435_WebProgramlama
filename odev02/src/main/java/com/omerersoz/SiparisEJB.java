package com.omerersoz;

@Stateless
public class SiparisEJB {
    @PersistenceContext
    private EntityManager em;

    public void kaydet(Siparis siparis) {
        em.persist(siparis);
    }

    public Siparis bul(Long id) {
        return em.find(Siparis.class, id);
    }

    public List<Siparis> tumSiparisler() {
        TypedQuery<Siparis> query = em.createQuery("SELECT s FROM Siparis s", Siparis.class);
        return query.getResultList();
    }

    public List<Siparis> musteriSiparisleri(Long musteriId) {
        TypedQuery<Siparis> query = em.createQuery("SELECT s FROM Siparis s WHERE s.musteri.id = :musteriId", Siparis.class);
        query.setParameter("musteriId", musteriId);
        return query.getResultList();
    }
}
