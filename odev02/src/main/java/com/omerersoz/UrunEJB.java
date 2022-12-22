package com.omerersoz;

@Stateless
public class UrunEJB {

    @PersistenceContext(unitName = "products-pu")
    private EntityManager em;

    public Urun urunEkle(Urun urun) {
        em.persist(ürün);
        return urun;
    }

    public List<Urun> tumUrunler() {
        TypedQuery<Urun> query = em.createQuery("SELECT p FROM Ürün p", Ürün.class);
        return query.getResultList();
    }

    public Urun urunGetir(Long id) {
        return em.find(Urun.class, id);
    }
    }