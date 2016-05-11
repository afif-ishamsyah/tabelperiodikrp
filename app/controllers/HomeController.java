package controllers;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSetFormatter;
import play.mvc.*;

import views.html.*;

import java.io.ByteArrayOutputStream;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index(String unsur) {
        //return ok(index.render("Your new application is ready."));

        QueryExecution qe = QueryExecutionFactory.sparqlService("http://localhost:3030/PeriodicTable/query", "PREFIX group: <http://www.daml.org/2003/01/periodictable/PeriodicTable#> SELECT ?a ?b ?c ?y ?x ?z WHERE {group:"+unsur+" group:atomicNumber ?y . group:"+unsur+" group:atomicWeight ?x . group:"+unsur+" group:casRegistryID ?z . group:"+unsur+" group:name ?a . group:"+unsur+" group:symbol ?b . group:"+unsur+" group:color ?c}");
        org.apache.jena.query.ResultSet results = qe.execSelect();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ResultSetFormatter.outputAsJSON(outputStream, results);
        String json = new String(outputStream.toByteArray());
        qe.close();
        return ok(json);
    }

}
