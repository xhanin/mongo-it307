package mongo.it307.rest;

import mongo.it307.domain.Company;
import org.bson.types.ObjectId;
import org.jongo.MongoCollection;
import restx.annotations.DELETE;
import restx.annotations.GET;
import restx.annotations.POST;
import restx.annotations.PUT;
import restx.annotations.RestxResource;
import restx.factory.Component;
import restx.jongo.JongoCollection;

import javax.inject.Named;
import java.util.Optional;

/**
 * Date: 22/10/15
 * Time: 09:42
 */
@Component
@RestxResource
public class CompanyResource {
    private final JongoCollection companies;

    public CompanyResource(@Named("companies") JongoCollection companies) {
        this.companies = companies;
    }

    @GET("/companies")
    public Iterable<Company> findCompanies() {
        return getCompanies().find().as(Company.class);
    }

    @GET("/companies/:id")
    public Optional<Company> findCompanyById(String id) {
        return Optional.ofNullable(getCompanies().findOne(new ObjectId(id)).as(Company.class));
    }

    @POST("/companies")
    public Company createCompany(Company company) {
        getCompanies().save(company);

        return company;
    }

    @PUT("/companies/:id")
    public Company updateCompany(String id, Company company) {
        getCompanies().save(company);

        return company;
    }

    @DELETE("/companies/:id")
    public void deleteCompany(String id) {
        getCompanies().remove(new ObjectId(id));
    }

    private MongoCollection getCompanies() {
        return companies.get();
    }
}
