package mongo.it307.domain;

import org.jongo.marshall.jackson.oid.Id;
import org.jongo.marshall.jackson.oid.ObjectId;

/**
 * Date: 22/10/15
 * Time: 09:43
 */
public class Company {
    @ObjectId @Id
    private String id;

    private String name;

    private String address;


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Company setName(final String name) {
        this.name = name;
        return this;
    }

    public Company setAddress(final String address) {
        this.address = address;
        return this;
    }

    public Company setId(final String id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

