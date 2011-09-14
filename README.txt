Java Repository Pattern implementation

Just because I am sick of having to do this over and over and figured you might feel the same way!

Currently supports Hibernate 4 (in other words it has an implementation based on Hibernate 4)

Usage is something like (if you have declared a persistence unit)

//Example
UnitOfWork unitOfWork = new HibernateUnitOfWork(Persistence.createEntityManagerFactory("MyUnit"));

Repository<Profile> repository = new HibernateRepository<Profile>(unitOfWork.getEntityManager());
repository.add(entityToSave);

try {
    unitOfWork.commit();
} catch (PersistenceException ex) {
    unitOfWork.rollback();
}
//End example