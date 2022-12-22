package com.omerersoz;

public class MusteriEJB {
    @PersistenceContext
    private EntityManager em;

    public void kaydet(Musteri musteri) {
        em.persist(musteri);
    }

    public Musteri bul(Long id) {
        return em.find(Musteri.class, id);
    }

    public List<Musteri> tumMusteriler() {
        TypedQuery<Musteri> query = em.createQuery("SELECT m FROM Musteri m", Musteri.class);
        return query.getResultList();
    }
}
