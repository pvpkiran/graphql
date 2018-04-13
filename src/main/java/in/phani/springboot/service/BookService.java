package in.phani.springboot.service;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Service
public class BookService {

  @Value("classpath:books.graphql")
  Resource resource;

  private final AllBooksFetcher allBooksFetcher;

  private final SpecificBookFetcher specificBookFetcher;

  private GraphQL graphQL;

  @Autowired
  public BookService(final AllBooksFetcher allBooksFetcher, final SpecificBookFetcher specificBookFetcher) {
    this.allBooksFetcher = allBooksFetcher;
    this.specificBookFetcher = specificBookFetcher;
  }

  @PostConstruct
  public void buildGraphql() throws IOException {
    File schemaFile =  resource.getFile();
    TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(schemaFile);
    RuntimeWiring wiring = buildRuntimeWiring();
    GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, wiring);
    graphQL = GraphQL.newGraphQL(schema).build();
  }

  private RuntimeWiring buildRuntimeWiring() {
    return RuntimeWiring.newRuntimeWiring()
        .type("Query", builder -> builder
            .dataFetcher("allBooks", allBooksFetcher)
            .dataFetcher("book", specificBookFetcher))
        .build();
  }

  public GraphQL getGraphQL() {
    return graphQL;
  }
}
