###Some key points

1.Create a jEE project and chose library as the template

2.no application server since we arent running a web app

3.keep build system as maven

4.copy the hibernate.cfg.xml file into the resources folder located inside src

5.update -> this line inside the config ensures a table is created if we do not have it already in the db

6.In order for a class to be allowed in database it has to be an entity, use @Entity annotation from import jakarta.persistence.Entity; above Alien (the class i want to add)

7.There has to be a variable which acts as primary key, here it is "id". use @Id annotation above it from import jakarta.persistence.Id;

8.Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class); -> add annotated class Alien to the hibernate configuration object
