**In hibernate.cfg.xml add these lines**

        <property name="cache.use_second_level_cache">true</property>
        <property name="cache.region.factory_class">org.hibernate.cache.ehcache.internal.EhcacheRegionFactory</property>


        
**In pom.xml make sure you have these dependancies which are for ehcache and hibernate**

        
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>5.6.14.Final</version>
        </dependency>
        <dependency>
            <groupId>net.sf.ehcache</groupId>
            <artifactId>ehcache</artifactId>
            <version>2.10.6</version>
        </dependency>
         <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-ehcache</artifactId>
            <version>5.6.14.Final</version>
        </dependency>

**Jdk 9 onwards javax.activation, javaxb-api and javaxb-runtime are not present by default, so add these in pom.xml**
                <dependency>
                    <groupId>javax.xml.bind</groupId>
                    <artifactId>jaxb-api</artifactId>
                    <version>2.3.1</version>
                </dependency>
                <dependency>
                    <groupId>org.glassfish.jaxb</groupId>
                    <artifactId>jaxb-runtime</artifactId>
                    <version>2.3.1</version>
                </dependency>
                 <dependency>
                    <groupId>javax.activation</groupId>
                    <artifactId>activation</artifactId>
                    <version>1.1.1</version>
                </dependency>

**Now we have everything set up so lets move to the class we want to cache, Stud here.
By default classes are not cached in secondary cache, we need to explicitly make them cacheable so that query results pertaining to those are stored in the cache**




        import java.util.*;
        import javax.persistence.*;
        import javax.persistence.Cacheable;
        import org.hibernate.annotations.CacheConcurrencyStrategy;

        @Entity
        @Table(name="studs")
        @Cacheable
        @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
        public class Stud {
            @Id
            private int roll_no;
            private String name;
            private int marks;
            @OneToMany(mappedBy = "stud")
            private List<Laptop> laptops = new ArrayList<>(); // one student can own multiple laptops herepublic int getRoll_no() {
                return roll_no;
            }
        
            public int getMarks() {
                return marks;
            }
        
            public void setMarks(int marks) {
                this.marks = marks;
            }
        
            public String getName() {
                return name;
            }
        
            public void setName(String name) {
                this.name = name;
            }
        
            public List<Laptop> getLaptops() {
                return laptops;
            }
        
            public void setLaptops(List<Laptop> laptops) {
                this.laptops = laptops;
            }
        
            public void setRoll_no(int roll_no) {
                this.roll_no = roll_no;
            }
        }

        

     

    
